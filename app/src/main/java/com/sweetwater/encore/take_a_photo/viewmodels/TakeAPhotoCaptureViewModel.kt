package com.sweetwater.encore.take_a_photo.viewmodels

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner
import com.sweetwater.encore.dependency_injection.sound.ISoundService
import com.sweetwater.encore.external_api.gds.repository.GDSRepository
import com.sweetwater.encore.take_a_photo.state.TakeAPhotoCaptureState
import com.sweetwater.encore.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TakeAPhotoCaptureViewModel @Inject constructor(
    private val context: Context,
    private val gdsRepository: GDSRepository,
    private val getEmployeeLoginDetailsUseCase: GetEmployeeLoginDetailsUseCase,
    private val soundService: ISoundService,
    private val barcodeScanner: IBarcodeScanner,
    private val ioDispatcher: CoroutineDispatcher,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _takeAPhotoCaptureState = mutableStateOf(
        TakeAPhotoCaptureState.initialState()
    )

    private var _employeeId = 0
    val employeeId: Int get() = _employeeId

    private var _employeeName = ""
    val employeeName: String get() = _employeeName

    val takeAPhotoCaptureState: State<TakeAPhotoCaptureState> = _takeAPhotoCaptureState

    init {
        _takeAPhotoCaptureState.value = takeAPhotoCaptureState.value.copy(
            tagText = savedStateHandle["tagText"]!!
        )
    }

    fun onNavigatedTo() {
        barcodeScanner.onBarcodeScanned = { text ->
            barcodeScanned(contents = text)
        }
    }

    fun showCameraFeatures() {
        _takeAPhotoCaptureState.value = takeAPhotoCaptureState.value.copy(
            showCameraFeatures = true
        )
    }

    fun onInputTextChanged(text: String) {
        _takeAPhotoCaptureState.value = takeAPhotoCaptureState.value.copy(
            descriptionText = text
        )
    }

    private fun barcodeScanned(contents: String) {
        _takeAPhotoCaptureState.value = takeAPhotoCaptureState.value.copy(
            descriptionText = contents
        )
    }

    fun handleImageCaptured(uri: Uri) {
        _takeAPhotoCaptureState.value = takeAPhotoCaptureState.value.copy(
            capturedImage = uri,
            isCaptured = true
        )

        viewModelScope.launch {
            getUserData()
        }
    }

    fun handleCaptureError(newError: String) {
        _takeAPhotoCaptureState.value = takeAPhotoCaptureState.value.copy(
            error = newError

        )

        soundService.playNegativeFeedbackSound()
    }

    fun clearCapturedImage() {
        _takeAPhotoCaptureState.value = takeAPhotoCaptureState.value.copy(
            capturedImage = null,
            isCaptured = false,
            uploading = false,
            isLoading = false
        )
    }

    fun clearPhotoDescription() {
        _takeAPhotoCaptureState.value = takeAPhotoCaptureState.value.copy(
            descriptionText = ""
        )
    }

    fun clearError() {
        _takeAPhotoCaptureState.value = takeAPhotoCaptureState.value.copy(
            error = ""
        )
    }

    fun uploadToGDS() {
        _takeAPhotoCaptureState.value = takeAPhotoCaptureState.value.copy(
            uploading = true
        )

        viewModelScope.launch {
            uploadDataToGDS()
        }
    }

    private suspend fun getUserData() {
        getEmployeeLoginDetailsUseCase().flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Error -> {
                    _takeAPhotoCaptureState.value = _takeAPhotoCaptureState.value.copy(
                        error = context.getString(R.string.login_user_data_not_found_in_db_error),
                        uploading = false
                    )
                    soundService.playNegativeFeedbackSound()
                }

                is Resource.Loading -> {
                    _takeAPhotoCaptureState.value = _takeAPhotoCaptureState.value.copy(
                        uploading = it.isLoading
                    )
                }

                is Resource.Success -> {
                    _employeeId = it.data!!.employeeId
                    _employeeName = it.data.name

                    clearError()

                    _takeAPhotoCaptureState.value = _takeAPhotoCaptureState.value.copy(
                        uploading = false
                    )
                }
            }
        }
    }

    private suspend fun uploadDataToGDS() {
        gdsRepository.uploadTakeAPhotoEntry(
            tag = _takeAPhotoCaptureState.value.tagText,
            image = takeAPhotoCaptureState.value.capturedImage!!,
            description = takeAPhotoCaptureState.value.descriptionText,
            employeeId = employeeId.toString(),
            employeeName = employeeName
        ).flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Success -> {
                    clearCapturedImage()
                    clearPhotoDescription()
                    soundService.playPositiveFeedbackSound()

                    _takeAPhotoCaptureState.value = takeAPhotoCaptureState.value.copy(
                        isLoading = false,
                        uploading = false,
                        complete = true
                    )
                }

                is Resource.Loading -> {
                    _takeAPhotoCaptureState.value = takeAPhotoCaptureState.value.copy(
                        isLoading = false
                    )
                }

                is Resource.Error -> {
                    handleCaptureError("Error uploading to GDS ${it.message}")
                    _takeAPhotoCaptureState.value = takeAPhotoCaptureState.value.copy(
                        isLoading = false,
                        uploading = false
                    )

                    soundService.playNegativeFeedbackSound()
                }
            }
        }
    }
}