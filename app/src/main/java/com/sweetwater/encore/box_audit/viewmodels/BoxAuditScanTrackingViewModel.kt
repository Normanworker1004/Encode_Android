package com.sweetwater.encore.box_audit.viewmodels

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase
import com.sweetwater.encore.box_audit.BoxAuditUIEvent
import com.sweetwater.encore.box_audit.state.BoxAuditScanTrackingState
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner
import com.sweetwater.encore.dependency_injection.sound.ISoundService
import com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository
import com.sweetwater.encore.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoxAuditScanTrackingViewModel @Inject constructor(
    private val getEmployeeLoginDetailsUseCase: GetEmployeeLoginDetailsUseCase,
    private val boxAuditRepository: IBoxAuditRepository,
    private val barcodeScanner: IBarcodeScanner,
    private val soundService: ISoundService,
    private val ioDispatcher: CoroutineDispatcher,
    context: Context,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    private var _boxAuditScanTrackingState = mutableStateOf(
        BoxAuditScanTrackingState.initialState()
    )
    val boxAuditScanTrackingState: State<BoxAuditScanTrackingState> = _boxAuditScanTrackingState

    private var _campusId = ""
    val campusId: String get() = _campusId

    init {
        viewModelScope.launch {
            getUserData(context)
        }
    }
    fun onNavigatedTo() {
        barcodeScanner.onBarcodeScanned = { text ->
           viewModelScope.launch {
               handleBarcodeScanned(text)
           }
        }
    }

    fun onEvent(event: BoxAuditUIEvent) {
        when(event) {
            is BoxAuditUIEvent.OnPackAreaSelected -> {
                _boxAuditScanTrackingState.value = boxAuditScanTrackingState.value.copy(
                    selectedPackArea = event.packArea
                )
            }

            is BoxAuditUIEvent.ClearError -> {
                _boxAuditScanTrackingState.value = boxAuditScanTrackingState.value.copy(
                    errorMessage = ""
                )
            }
        }
    }

    private suspend fun handleBarcodeScanned(text: String) {
        boxAuditRepository.getBoxAuditDetails(text, boxAuditScanTrackingState.value.selectedPackArea.toLowerCase(), campusId).collectLatest {
            when (it) {
                is Resource.Success -> {
                    _boxAuditScanTrackingState.value = boxAuditScanTrackingState.value.copy(
                        boxAuditResponse = it.data
                    )
                    Log.d("ScanTrackingViewModel", "got data -> " + it.data)
                }
                is Resource.Loading -> {
                    _boxAuditScanTrackingState.value = boxAuditScanTrackingState.value.copy(
                        isLoading = it.isLoading
                    )
                }
                is Resource.Error -> {
                    soundService.playNegativeFeedbackSound()
                    viewModelScope.launch {
                        _boxAuditScanTrackingState.value = boxAuditScanTrackingState.value.copy(
                            errorMessage = it.message!!.message,
                        )
                        displayFullScreenError()
                    }
                }
            }
        }
    }
    private suspend fun getUserData(context: Context) {
        getEmployeeLoginDetailsUseCase().flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Error -> {
                    _boxAuditScanTrackingState.value = boxAuditScanTrackingState.value.copy(
                        errorMessage = context.getString(R.string.login_user_data_not_found_in_db_error)
                    )
                }

                is Resource.Loading -> {
                    _boxAuditScanTrackingState.value = boxAuditScanTrackingState.value.copy(
                        isLoading = it.isLoading
                    )
                }

                is Resource.Success -> {
                    _campusId = it.data!!.campusId.toString()
                }
            }
        }
    }

    private suspend fun displayFullScreenError() {
        _boxAuditScanTrackingState.value = boxAuditScanTrackingState.value.copy(
            displayFullScreenError = true
        )
        delay(2000)
        _boxAuditScanTrackingState.value = boxAuditScanTrackingState.value.copy(
            displayFullScreenError = false
        )
    }
}