package com.sweetwater.encore.take_a_photo.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner
import com.sweetwater.encore.utilities.IKeyboardInputViewModel
import com.sweetwater.encore.take_a_photo.state.TakeAPhotoScanUPCState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TakeAPhotoScanUPCViewModel @Inject constructor(
    private val barcodeScanner: IBarcodeScanner,
) : ViewModel(), IKeyboardInputViewModel {
    private val _takeAPhotoScanUPCState = mutableStateOf(
        TakeAPhotoScanUPCState.initialState()
    )

    val takeAPhotoScanUPCState: State<TakeAPhotoScanUPCState> = _takeAPhotoScanUPCState

    init {
        _takeAPhotoScanUPCState.value = TakeAPhotoScanUPCState.initialState()
    }

    override fun onKeyboardToggled(isToggled: Boolean) {
        _takeAPhotoScanUPCState.value = takeAPhotoScanUPCState.value.copy(
            isKeyboardToggled = isToggled,
        )
    }

    override fun onConfirmKeyboard(text: String) {
        _takeAPhotoScanUPCState.value = takeAPhotoScanUPCState.value.copy(
            isKeyboardToggled = false,
        )

        handleBarcodeScan(text)
    }

    fun clearTag() {
        _takeAPhotoScanUPCState.value = takeAPhotoScanUPCState.value.copy(
            tag = ""
        )
    }

    fun onNavigatedTo() {
        barcodeScanner.onBarcodeScanned = { barcode ->
            handleBarcodeScan(barcode);
        }
    }

    fun clearError() {
        _takeAPhotoScanUPCState.value = takeAPhotoScanUPCState.value.copy(
            error = ""
        )
    }

    private fun handleBarcodeScan(scannedBarcode: String) {
        _takeAPhotoScanUPCState.value = takeAPhotoScanUPCState.value.copy(
            isKeyboardToggled = false,
            tag = scannedBarcode
        )
    }
}