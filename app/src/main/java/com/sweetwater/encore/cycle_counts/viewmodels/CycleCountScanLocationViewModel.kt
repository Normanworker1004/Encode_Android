package com.sweetwater.encore.cycle_counts.viewmodels

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase
import com.sweetwater.encore.cycle_counts.state.CycleCountScanLocationState
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner
import com.sweetwater.encore.dependency_injection.sound.ISoundService
import com.sweetwater.encore.external_api.inventory.dto.response.CycleCountLocation
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository
import com.sweetwater.encore.utilities.IKeyboardInputViewModel
import com.sweetwater.encore.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CycleCountScanLocationViewModel @Inject constructor(
    private val getEmployeeLoginDetailsUseCase: GetEmployeeLoginDetailsUseCase,
    private val inventoryRepository: IInventoryRepository,
    private val barcodeScanner: IBarcodeScanner,
    private val soundService: ISoundService,
    private val ioDispatcher: CoroutineDispatcher,
    context: Context,
    savedStateHandle: SavedStateHandle
) : ViewModel(), IKeyboardInputViewModel {
    private val _cycleCountScanLocationState = mutableStateOf(
        CycleCountScanLocationState.initialState()
    )
    val cycleCountScanLocationState: State<CycleCountScanLocationState> =
        _cycleCountScanLocationState

    private var _employeeId = 0
    val employeeId: Int get() = _employeeId

    private var _campusId = ""
    val campusId: String get() = _campusId

    init {
        val zoneId: Int? = savedStateHandle["zoneId"]
        viewModelScope.launch {
            getUserData(context)
            assignCountRequestsForZone(campusId, employeeId, zoneId!!)
        }
    }

    fun onNavigatedTo() {
        barcodeScanner.onBarcodeScanned = {
            val currentLocation =
                _cycleCountScanLocationState.value.assignedLocations.getOrNull(0)?.location
            if (currentLocation != null) {
                compareInputToLocation(it, currentLocation)
            }
        }
    }

    fun clearError() {
        _cycleCountScanLocationState.value = cycleCountScanLocationState.value.copy(
            error = ""
        )
    }

    fun clearLocationMatchFlag() {
        _cycleCountScanLocationState.value = cycleCountScanLocationState.value.copy(
            locationMatched = null
        )
    }

    private fun compareInputToLocation(input: String, location: CycleCountLocation) {
        if (input == location.name) {
            _cycleCountScanLocationState.value = cycleCountScanLocationState.value.copy(
                locationMatched = true
            )
        } else {
            soundService.playNegativeFeedbackSound()
            viewModelScope.launch {
                _cycleCountScanLocationState.value = cycleCountScanLocationState.value.copy(
                    locationMatched = false
                )
                delay(2000)
                clearLocationMatchFlag()
            }
        }
    }

    private suspend fun assignCountRequestsForZone(campusId: String, employeeId: Int, zoneId: Int) {
        inventoryRepository.assignCountRequestsForZone(campusId, employeeId, zoneId)
            .flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Loading -> {
                    _cycleCountScanLocationState.value = cycleCountScanLocationState.value.copy(
                        isLoading = it.isLoading
                    )
                }

                is Resource.Success -> {
                    _cycleCountScanLocationState.value = cycleCountScanLocationState.value.copy(
                        assignedLocations = it.data!!.sortedBy { location -> location.location.name }
                            .toMutableStateList()
                    )
                }

                is Resource.Error -> {
                    _cycleCountScanLocationState.value = cycleCountScanLocationState.value.copy(
                        error = it.message!!.message
                    )
                }
            }
        }
    }

    private suspend fun getUserData(context: Context) {
        getEmployeeLoginDetailsUseCase().flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Error -> {
                    _cycleCountScanLocationState.value = cycleCountScanLocationState.value.copy(
                        error = context.getString(R.string.login_user_data_not_found_in_db_error)
                    )
                }

                is Resource.Loading -> {
                    _cycleCountScanLocationState.value = cycleCountScanLocationState.value.copy(
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
        _cycleCountScanLocationState.value = cycleCountScanLocationState.value.copy(
            keyboardToggled = isToggled,
        )
    }

    override fun onConfirmKeyboard(text: String) {
        _cycleCountScanLocationState.value = cycleCountScanLocationState.value.copy(
            keyboardToggled = false
        )
        val currentLocation =
            _cycleCountScanLocationState.value.assignedLocations.getOrNull(0)?.location
        if (currentLocation != null) {
            compareInputToLocation(text, currentLocation)
        }
    }
}