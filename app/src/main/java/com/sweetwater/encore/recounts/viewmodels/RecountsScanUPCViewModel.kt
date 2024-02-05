package com.sweetwater.encore.recounts.viewmodels

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner
import com.sweetwater.encore.dependency_injection.sound.ISoundService
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService
import com.sweetwater.encore.external_api.inventory.dto.requests.UploadRecountRequest
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository
import com.sweetwater.encore.helpers.extensions.removeNonNumericCharacters
import com.sweetwater.encore.recounts.data.mappers.toRecountLocationsDtoList
import com.sweetwater.encore.recounts.data.mappers.toRecountRequestDto
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository
import com.sweetwater.encore.recounts.state.RecountsScanUPCState
import com.sweetwater.encore.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class RecountsScanUPCViewModel @Inject constructor(
    private val barcodeScanner: IBarcodeScanner,
    private val recountsDataRepository: IRecountsRepository,
    private val soundService: ISoundService,
    private val vibratorService: IVibratorService,
    private val savedStateHandle: SavedStateHandle,
    private val inventoryRepository: IInventoryRepository,
    private val getEmployeeLoginDetailsUseCase: GetEmployeeLoginDetailsUseCase,
    private val ioDispatcher: CoroutineDispatcher,
    private val context: Context,
) : ViewModel() {
    private val _recountsScanUPCState = mutableStateOf(
        RecountsScanUPCState.initialState()
    )
    val recountsScanUPCState: State<RecountsScanUPCState> = _recountsScanUPCState

    private var _locationName = ""
    val locationName: String get() = _locationName

    private var _employeeId = 0
    val employeeId: Int get() = _employeeId

    private var _campusId = ""
    val campusId: String get() = _campusId

    private var _shouldForce = false
    val shouldForce: Boolean get() = _shouldForce

    init {
        viewModelScope.launch {
            getUserData(context)
            _locationName = savedStateHandle["locationName"]!!
            val recountRequest = recountsDataRepository.getCurrentRequest().toRecountRequestDto()
            val expectedSerialNumber = recountRequest.product.serialNumber ?: ""
            _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                recountRequest = recountRequest,
                recountLocations = recountsDataRepository.getCurrentLocations()
                    .toRecountLocationsDtoList(),
                locationName = locationName,
                countStartAt = LocalDateTime.now(),
                expectedSerialNumber = expectedSerialNumber
            )
        }
    }

    fun onNavigatedTo() {
        barcodeScanner.onBarcodeScanned = { text ->
            viewModelScope.launch {
                handleTextInput(text)
            }
        }
    }

    fun onProductClicked() {
        if (_recountsScanUPCState.value.expectedSerialNumber.isEmpty()) {
            _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                updatingQuantity = true
            )
        }
        _recountsScanUPCState.value = recountsScanUPCState.value.copy(
            isKeyboardToggled = true
        )
    }

    fun clearErrorMessage() {
        _recountsScanUPCState.value = recountsScanUPCState.value.copy(
            errorMessage = ""
        )
    }

    fun onKeyboardToggled(isToggled: Boolean) {
        _recountsScanUPCState.value = recountsScanUPCState.value.copy(
            isKeyboardToggled = isToggled
        )

        if (!isToggled) {
            _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                updatingQuantity = false
            )
        }
    }

    fun onKeyboardConfirm(text: String) {
        viewModelScope.launch {
            var updatedText = text

            if (_recountsScanUPCState.value.updatingQuantity) {
                updatedText = updatedText.removeNonNumericCharacters()
            }

            _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                isKeyboardToggled = false
            )
            handleTextInput(updatedText)
            _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                updatingQuantity = false
            )
        }
    }

    private suspend fun handleTextInput(text: String) {
        if (text.equals(locationName, ignoreCase = true)) {
            uploadRecount()
            if (recountsScanUPCState.value.productIdsWithVariance != null) {
                _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                    errorMessage = context.getString(R.string.recounts_variance_detected_double_check_count_error),
                    isVarianceDetected = true
                )
                _shouldForce = true
                displayFullScreenError()
            }

            return
        }

        if (_recountsScanUPCState.value.updatingQuantity) {
            val newQuantity = text.toIntOrNull() ?: _recountsScanUPCState.value.countedQuantity
            _recountsScanUPCState.value.countedQuantity = newQuantity
        } else if (_recountsScanUPCState.value.promptForSerialNumber) {
            validateSerialNumber(text)
        } else {
            handleProductIdentifierInput(text)
        }
        _shouldForce = false
        _recountsScanUPCState.value = recountsScanUPCState.value.copy(
            isVarianceDetected = false
        )
    }

    private fun handleProductIdentifierInput(productIdentifier: String) {
        val matchingProduct =
            _recountsScanUPCState.value.recountRequest?.product?.productIdentifiers?.find { identifier ->
                identifier.equals(productIdentifier, ignoreCase = true)
            }

        if (matchingProduct != null) {
            val newQuantity = if (_recountsScanUPCState.value.expectedSerialNumber.isNotEmpty()) 1
            else recountsScanUPCState.value.countedQuantity + 1
            _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                countedQuantity = newQuantity
            )
            if (serialNumberPending()) {
                _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                    promptForSerialNumber = true
                )
                vibratorService.singleClick()
                soundService.playNotificationSound()
            }
        } else {
            viewModelScope.launch {
                soundService.playNegativeFeedbackSound()
                vibratorService.singleClick()
                _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                    errorMessage = context.getString(R.string.recounts_invalid_barcode_for_product_error),
                )
                displayFullScreenError()
            }
        }
    }

    private fun serialNumberPending(): Boolean {
        return _recountsScanUPCState.value.expectedSerialNumber.isNotEmpty() && _recountsScanUPCState.value.inputSerialNumber.isEmpty()
    }

    private suspend fun getUserData(context: Context) {
        getEmployeeLoginDetailsUseCase().flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Error -> {
                    _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                        errorMessage = context.getString(R.string.login_user_data_not_found_in_db_error)
                    )
                }

                is Resource.Loading -> {
                    _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                        isLoading = it.isLoading
                    )
                }

                is Resource.Success -> {
                    _employeeId = it.data!!.employeeId
                    _campusId = it.data.campusId.toString()
                }
            }
        }
    }

    private suspend fun uploadRecount() {
        val request = UploadRecountRequest(
            countedByEmployee = employeeId,
            countedQuantity = recountsScanUPCState.value.countedQuantity,
            countEndAt = LocalDateTime.now().toString(),
            countStartAt = recountsScanUPCState.value.countStartAt.toString(),
            serialNumber = recountsScanUPCState.value.recountRequest!!.product.serialNumber
        )

        val recountRequestId = recountsScanUPCState.value.recountRequest!!.recountRequestId
        val recountLocationId =
            recountsScanUPCState.value.recountLocations.find { it.location.name == locationName }!!.recountLocationId

        inventoryRepository.uploadProductRecountsForRecountRequest(
            campusId, recountRequestId, recountLocationId, request, shouldForce
        ).flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Success -> {
                    soundService.playPositiveFeedbackSound()
                    _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                        hasCompletedRecount = true, productIdsWithVariance = null
                    )
                }

                is Resource.Loading -> {
                    _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                        isLoading = it.isLoading
                    )
                }

                is Resource.Error -> {
                    soundService.playNegativeFeedbackSound()
                    vibratorService.heavyClick()
                    _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                        errorMessage = it.message!!.message, productIdsWithVariance = it.data
                    )
                }
            }
        }
    }

    private suspend fun displayFullScreenError() {
        _recountsScanUPCState.value = recountsScanUPCState.value.copy(
            displayFullScreenError = true
        )
        delay(2000)
        _recountsScanUPCState.value = recountsScanUPCState.value.copy(
            displayFullScreenError = false
        )
    }

    private fun validateSerialNumber(text: String) {
        if (text == _recountsScanUPCState.value.expectedSerialNumber) {
            _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                inputSerialNumber = text, promptForSerialNumber = false
            )
        } else {
            _recountsScanUPCState.value = recountsScanUPCState.value.copy(
                errorMessage = context.getString(R.string.recounts_serial_number_mismatch_error)
            )
            vibratorService.doubleClick()
            soundService.playNegativeFeedbackSound()
        }
    }
}