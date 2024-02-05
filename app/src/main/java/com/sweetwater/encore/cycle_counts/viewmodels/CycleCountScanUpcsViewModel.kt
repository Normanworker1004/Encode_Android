package com.sweetwater.encore.cycle_counts.viewmodels

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase
import com.sweetwater.encore.cycle_counts.dto.ProductScanInfo
import com.sweetwater.encore.cycle_counts.state.CycleCountScanUpcsState
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner
import com.sweetwater.encore.dependency_injection.sound.ISoundService
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService
import com.sweetwater.encore.external_api.inventory.dto.requests.UploadProductCountsRequest
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository
import com.sweetwater.encore.external_api.products.dto.ProductInfo
import com.sweetwater.encore.external_api.products.dto.SerialNumbersValidationResponse
import com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository
import com.sweetwater.encore.helpers.extensions.removeNonNumericCharacters
import com.sweetwater.encore.utilities.IKeyboardInputViewModel
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
class CycleCountScanUpcsViewModel @Inject constructor(
    private val inventoryRepository: IInventoryRepository,
    private val productsRepository: IProductsRepository,
    private val getEmployeeLoginDetailsUseCase: GetEmployeeLoginDetailsUseCase,
    private val barcodeScanner: IBarcodeScanner,
    private val soundService: ISoundService,
    private val vibratorService: IVibratorService,
    private val ioDispatcher: CoroutineDispatcher,
    private val context: Context,
    savedStateHandle: SavedStateHandle
) : ViewModel(), IKeyboardInputViewModel {
    private var _cycleCountScanUpcsState = mutableStateOf(
        CycleCountScanUpcsState.initialState()
    )
    val cycleCountScanUpcsState: State<CycleCountScanUpcsState> = _cycleCountScanUpcsState

    private var _locationName = ""
    val locationName: String get() = _locationName

    private var _countRequestId = 0
    val countRequestId: Int get() = _countRequestId

    private var _employeeId = 0
    val employeeId: Int get() = _employeeId

    private var _campusId = ""
    val campusId: String get() = _campusId

    private var currentProductInfo = ArrayList<ProductInfo>()

    private var _shouldForce = false
    val shouldForce: Boolean get() = _shouldForce

    private var _isValidSerialNumber: SerialNumbersValidationResponse? = null;

    init {
        _locationName = savedStateHandle["locationName"]!!
        _countRequestId = savedStateHandle["countRequestId"]!!
        viewModelScope.launch {
            getUserData(context)
        }
    }

    fun onNavigatedTo() {
        barcodeScanner.onBarcodeScanned = { text ->
            handleTextInput(isKeyed = false, text)
        }
    }

    fun onDoneButtonClicked() {
        viewModelScope.launch {
            uploadProductCountsForCountRequest(shouldForce)

            if (_cycleCountScanUpcsState.value.productIdsWithVariance != null) {
                _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                    errorMessage = context.getString(R.string.cycle_count_variance_detected_error)
                )
                updateScanInfoWithVariance()
                _shouldForce = true
                displayFullScreenError()
            }
        }
    }

    fun onProductClicked(name: String, serialNumber: String, requiresSerialNumber: Boolean) {
        if (requiresSerialNumber) {
            _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                updatingSerialNumber = true,
            )
        } else {
            _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                updatingQuantity = true,
            )
        }
        _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
            isKeyboardToggled = true,
            editingProduct = _cycleCountScanUpcsState.value.scannedProductList.find { it.name == name && it.serialNumber == serialNumber }
        )
    }

    fun clearErrorMessage() {
        _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
            errorMessage = ""
        )
    }

    private fun handleTextInput(isKeyed: Boolean, text: String) {
        if (_cycleCountScanUpcsState.value.updatingQuantity) {
            updateEditingProductQuantity(text.toIntOrNull())
        } else if (_cycleCountScanUpcsState.value.updatingSerialNumber) {
            updateEditingProductSerialNumber(text)
        } else if (_cycleCountScanUpcsState.value.serialNumberPrompt) {
            handleSerialNumberInput(text)
        } else {
            handleProductIdentifierInput(isKeyed, text)
        }
    }

    private fun handleSerialNumberInput(serialNumber: String) {

        viewModelScope.launch {
            validateSerialNumbersForProductId(serialNumber, _cycleCountScanUpcsState.value.scannedProductList[0].productId)

            if(_isValidSerialNumber?.valid == true) {
                _cycleCountScanUpcsState.value.scannedProductList[0].serialNumber = serialNumber

                _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                    serialNumberPrompt = false
                )
            }

            _isValidSerialNumber = null
        }
    }

    private fun handleProductIdentifierInput(isKeyed: Boolean, productIdentifier: String) {
        val existingProduct = _cycleCountScanUpcsState.value.scannedProductList.find { product ->
            product.productIdentifiers.any {
                it.equals(
                    productIdentifier,
                    ignoreCase = true
                )
            } && !product.isSerialNumberRequired
        }
        if (existingProduct != null) {
            updateProductQuantity(existingProduct, existingProduct.productQuantity + 1)
            return
        }
        viewModelScope.launch {
            getProductInfo(productIdentifier)

            if (currentProductInfo.isEmpty() || _cycleCountScanUpcsState.value.errorMessage.isNotEmpty()) {
                return@launch
            }

            val productScanInfo = ProductScanInfo(
                productId = currentProductInfo[0].productId,
                name = currentProductInfo[0].name,
                imageUrl = currentProductInfo[0].imageURL,
                productManufacturer = currentProductInfo[0].manufacturer,
                shortDescription = currentProductInfo[0].shortDescription,
                isSerialNumberRequired = currentProductInfo[0].requiresSerialNumber,
                productIdentifiers = currentProductInfo[0].productIdentifiers + currentProductInfo[0].name,
                serialNumber = "",
                isIdentifierKeyed = isKeyed,
                isQuantityKeyed = false,
                productQuantity = 1,
                countForProductStartedAt = LocalDateTime.now().toString()
            )

            _cycleCountScanUpcsState.value.scannedProductList.add(0, productScanInfo)

            if (currentProductInfo[0].requiresSerialNumber) {
                vibratorService.doubleClick()
                soundService.playNotificationSound()
                _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                    serialNumberPrompt = true,
                )
            }

            _shouldForce = false
        }
    }

    private fun updateEditingProductQuantity(quantity: Int?) {
        updateProductQuantity(_cycleCountScanUpcsState.value.editingProduct!!, quantity)
        _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
            isKeyboardToggled = false,
            editingProduct = null,
            updatingQuantity = false
        )
    }

    private fun updateEditingProductSerialNumber(serialNumber: String) {

        viewModelScope.launch {
            validateSerialNumbersForProductId(
                serialNumber,
                _cycleCountScanUpcsState.value.editingProduct!!.productId
            )

            if(_isValidSerialNumber?.valid == true) {
                updateProductSerialNumber(
                    _cycleCountScanUpcsState.value.editingProduct!!,
                    serialNumber
                )
                _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                    isKeyboardToggled = false,
                    editingProduct = null,
                    updatingSerialNumber = false,
                    serialNumberPrompt = false
                )

                _isValidSerialNumber = null
            }
        }
    }

    private fun updateProductQuantity(product: ProductScanInfo, quantity: Int?) {
        val index = _cycleCountScanUpcsState.value.scannedProductList.indexOf(product)
        val newQuantity =
            quantity ?: _cycleCountScanUpcsState.value.scannedProductList[index].productQuantity

        _cycleCountScanUpcsState.value.scannedProductList[index] =
            cycleCountScanUpcsState.value.scannedProductList[index].copy(
                productQuantity = newQuantity,
                isVarianceDetected = false,
                isQuantityKeyed = true
            )

        _shouldForce = false
    }

    private fun updateProductSerialNumber(product: ProductScanInfo, serialNumber: String) {
        val index =
            _cycleCountScanUpcsState.value.scannedProductList.indexOf(product)

        _cycleCountScanUpcsState.value.scannedProductList[index] =
            cycleCountScanUpcsState.value.scannedProductList[index].copy(
                serialNumber = serialNumber,
                isVarianceDetected = false
            )

        _shouldForce = false
    }

    private fun updateScanInfoWithVariance() {
        for (productId in _cycleCountScanUpcsState.value.productIdsWithVariance!!.productIdsWithVariance) {
            val index = _cycleCountScanUpcsState.value.scannedProductList.indexOfFirst { scanInfo ->
                scanInfo.productId == productId
            }

            if (index != -1) {
                _cycleCountScanUpcsState.value.scannedProductList[index] =
                    cycleCountScanUpcsState.value.scannedProductList[index].copy(
                        isVarianceDetected = true
                    )
            }
        }
    }

    private suspend fun getProductInfo(productIdentifier: String) {
        productsRepository.getProductInfo(productIdentifier).flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Success -> {
                    currentProductInfo = it.data!!
                }

                is Resource.Loading -> {
                    _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                        isLoading = it.isLoading
                    )
                }

                is Resource.Error -> {
                    soundService.playNegativeFeedbackSound()
                    viewModelScope.launch {
                        _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                            errorMessage = it.message!!.message,
                        )
                        displayFullScreenError()
                    }
                }
            }
        }
    }

    private suspend fun validateSerialNumbersForProductId(serialNumber: String, productId: Number) {
        productsRepository.validateSerialNumbersForProductId(serialNumber, productId).collectLatest {
            when (it) {
                is Resource.Success -> {
                    _isValidSerialNumber = it.data
                }
                is Resource.Loading -> {
                    _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                        isLoading = it.isLoading
                    )
                }
                is Resource.Error -> {
                    soundService.playNegativeFeedbackSound()
                    viewModelScope.launch {
                        _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                            errorMessage = it.message!!.message,
                        )
                        displayFullScreenError()
                    }
                }
            }
        }
    }

    private suspend fun uploadProductCountsForCountRequest(force: Boolean) {
        val requests = _cycleCountScanUpcsState.value.scannedProductList.map { scanInfo ->
            UploadProductCountsRequest(
                countEndAt = LocalDateTime.now().toString(),
                countStartAt = scanInfo.countForProductStartedAt,
                countedByEmployee = _employeeId,
                countedQuantity = scanInfo.productQuantity,
                isItemIdKeyed = scanInfo.isIdentifierKeyed,
                isQuantityKeyed = scanInfo.isQuantityKeyed,
                productId = scanInfo.productId,
                serialNumber = scanInfo.serialNumber
            )
        }

        inventoryRepository.uploadProductCountsForCountRequest(
            requests,
            force,
            campusId,
            countRequestId
        ).flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Success -> {
                    soundService.playPositiveFeedbackSound()
                    _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                        hasCompletedCount = true,
                        productIdsWithVariance = null
                    )
                }

                is Resource.Loading -> {
                    _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                        isLoading = it.isLoading
                    )
                }

                is Resource.Error -> {
                    soundService.playNegativeFeedbackSound()
                    vibratorService.heavyClick()
                    _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                        errorMessage = it.message!!.message,
                        productIdsWithVariance = it.data
                    )
                }
            }
        }
    }

    private suspend fun getUserData(context: Context) {
        getEmployeeLoginDetailsUseCase().flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Error -> {
                    _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                        errorMessage = context.getString(R.string.login_user_data_not_found_in_db_error)
                    )
                }

                is Resource.Loading -> {
                    _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
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

    override fun onKeyboardToggled(isToggled: Boolean) {
        _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
            isKeyboardToggled = isToggled
        )

        if (!isToggled) {
            _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
                updatingQuantity = false,
                updatingSerialNumber = false
            )
        }
    }

    override fun onConfirmKeyboard(text: String) {

        var updatedInput = text

        if (_cycleCountScanUpcsState.value.updatingQuantity) {
            updatedInput = text.removeNonNumericCharacters()
        }
        _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
            isKeyboardToggled = false
        )

        handleTextInput(isKeyed = true, updatedInput)
    }

    private suspend fun displayFullScreenError() {
        _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
            displayFullScreenError = true
        )
        delay(2000)
        _cycleCountScanUpcsState.value = cycleCountScanUpcsState.value.copy(
            displayFullScreenError = false
        )
    }
}