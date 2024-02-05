package com.sweetwater.encore.recounts.viewmodels

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository
import com.sweetwater.encore.recounts.data.dto.LocationDto
import com.sweetwater.encore.recounts.data.dto.RecountLocationDto
import com.sweetwater.encore.recounts.data.mappers.toRecountLocationsDtoList
import com.sweetwater.encore.recounts.data.mappers.toRecountLocationsList
import com.sweetwater.encore.recounts.data.mappers.toRecountRequestDto
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository
import com.sweetwater.encore.recounts.state.RecountsScanLocationState
import com.sweetwater.encore.utilities.IKeyboardInputViewModel
import com.sweetwater.encore.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecountsScanLocationViewModel @Inject constructor(
    private val barcodeScanner: IBarcodeScanner,
    private val recountsDataRepository: IRecountsRepository,
    private val inventoryRepository: IInventoryRepository,
    private val getEmployeeLoginDetailsUseCase: GetEmployeeLoginDetailsUseCase,
    private val ioDispatcher: CoroutineDispatcher,
    private val context: Context
) : ViewModel(), IKeyboardInputViewModel {
    private var _recountsScanLocationState = mutableStateOf(
        RecountsScanLocationState.initialState()
    )
    val recountsScanLocationState: State<RecountsScanLocationState> = _recountsScanLocationState

    private var _campusId = ""
    val campusId: String get() = _campusId

    fun onNavigatedTo() {
        barcodeScanner.onBarcodeScanned = { text ->
            compareInputToLocations(text)
        }
        viewModelScope.launch {
            _recountsScanLocationState.value = recountsScanLocationState.value.copy(
                recountRequest = recountsDataRepository.getCurrentRequest().toRecountRequestDto(),
                recountLocations = recountsDataRepository.getCurrentLocations()
                    .toRecountLocationsDtoList()
            )
            getUserData(context)
        }
    }

    fun clearError() {
        _recountsScanLocationState.value = recountsScanLocationState.value.copy(
            error = "",
        )
    }

    fun clearMatchedLocation() {
        _recountsScanLocationState.value = recountsScanLocationState.value.copy(
            matchedLocation = null
        )
    }

    fun clearAdditionalLocation() {
        _recountsScanLocationState.value = recountsScanLocationState.value.copy(
            additionalLocationName = "",
            addingLocation = false
        )
    }

    suspend fun validateLocationAndAddToRecount() {
        _recountsScanLocationState.value = recountsScanLocationState.value.copy(
            addingLocation = false
        )
        val locationName = _recountsScanLocationState.value.additionalLocationName
        inventoryRepository.getLocationByName(locationName, _campusId).flowOn(ioDispatcher)
            .collectLatest {
                when (it) {
                    is Resource.Error -> {
                        _recountsScanLocationState.value = recountsScanLocationState.value.copy(
                            error = it.message!!.message,
                            isLoading = false,
                            additionalLocationName = ""
                        )
                    }

                    is Resource.Loading -> {
                        _recountsScanLocationState.value = recountsScanLocationState.value.copy(
                            isLoading = it.isLoading
                        )
                    }

                is Resource.Success -> {
                    val location = it.data
                    val currentRecountRequestId =
                        _recountsScanLocationState.value.recountRequest!!.recountRequestId
                    addLocationToRecount(
                        location!!.id,
                        location.name,
                        1,
                        currentRecountRequestId,
                        _campusId
                    )
                }
            }
        }
    }

    override fun onKeyboardToggled(isToggled: Boolean) {
        _recountsScanLocationState.value = recountsScanLocationState.value.copy(
            isKeyboardToggled = isToggled,
        )
    }

    override fun onConfirmKeyboard(text: String) {
        _recountsScanLocationState.value = recountsScanLocationState.value.copy(
            isKeyboardToggled = false,
        )
        compareInputToLocations(text)
    }

    private fun compareInputToLocations(text: String) {
        if (recountsScanLocationState.value.recountLocations.find { recountLocation -> recountLocation.location.name == text } != null) {
            _recountsScanLocationState.value = recountsScanLocationState.value.copy(
                matchedLocation = text
            )
        } else {
            _recountsScanLocationState.value = recountsScanLocationState.value.copy(
                addingLocation = true,
                additionalLocationName = text
            )
        }
    }

    private suspend fun getUserData(context: Context) {
        getEmployeeLoginDetailsUseCase().flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Error -> {
                    _recountsScanLocationState.value = recountsScanLocationState.value.copy(
                        error = context.getString(R.string.login_user_data_not_found_in_db_error)
                    )
                }

                is Resource.Loading -> {
                    _recountsScanLocationState.value = recountsScanLocationState.value.copy(
                        isLoading = it.isLoading
                    )
                }

                is Resource.Success -> {
                    _campusId = it.data!!.campusId.toString()
                }
            }
        }
    }

    private suspend fun addLocationToRecount(
        locationId: Int,
        locationName: String,
        recountPriority: Int,
        recountRequestId: Int,
        campusId: String
    ) {
        inventoryRepository.addLocationToRecount(
            locationId,
            recountPriority,
            recountRequestId,
            campusId
        ).flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Error -> {
                    _recountsScanLocationState.value = recountsScanLocationState.value.copy(
                        error = it.message!!.message,
                        isLoading = false
                    )
                }

                is Resource.Loading -> {
                    _recountsScanLocationState.value = recountsScanLocationState.value.copy(
                        isLoading = true
                    )
                }

                is Resource.Success -> {
                    val createdRecountLocation = it.data!!
                    val updatedLocationsList =
                        _recountsScanLocationState.value.recountLocations.toMutableList()
                    updatedLocationsList.add(
                        RecountLocationDto(
                            recountLocationId = createdRecountLocation[0].id,
                            priority = createdRecountLocation[0].recountPriority,
                            location = LocationDto(
                                id = createdRecountLocation[0].locationId,
                                name = locationName
                            ),
                            note = createdRecountLocation[0].note,
                            countedByEmployee = createdRecountLocation[0].countedByEmployee,
                            expectedQuantity = createdRecountLocation[0].expectedQuantity,
                            countedQuantity = createdRecountLocation[0].countedQuantity,
                            countStartAt = createdRecountLocation[0].countStartAt,
                            countCompletedAt = createdRecountLocation[0].countCompletedAt
                        )
                    )
                    _recountsScanLocationState.value = recountsScanLocationState.value.copy(
                        recountLocations = updatedLocationsList
                    )
                    recountsDataRepository.setCurrentLocations(_recountsScanLocationState.value.recountLocations.toRecountLocationsList())
                    _recountsScanLocationState.value = recountsScanLocationState.value.copy(
                        matchedLocation = locationName
                    )
                }
            }
        }
    }
}