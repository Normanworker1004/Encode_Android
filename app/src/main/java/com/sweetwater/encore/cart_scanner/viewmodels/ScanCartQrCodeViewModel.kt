package com.sweetwater.encore.cart_scanner.viewmodels

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.R
import com.sweetwater.encore.cart_scanner.state.ScanCartQrCodeState
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner
import com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService
import com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService
import com.sweetwater.encore.dependency_injection.sound.ISoundService
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val UUID_LENGTH = 36;

@HiltViewModel
class ScanCartQrCodeViewModel @Inject constructor(
    private val context: Context,
    private val cartScannerService: ICartScannerService,
    private val barcodeScanner: IBarcodeScanner,
    private val connectivityService: IConnectivityService,
    private val soundService: ISoundService,
    private val vibratorService: IVibratorService,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {


    private val _scanCartQrCodeState = mutableStateOf(
        ScanCartQrCodeState()
    )
    val scanCartQrCodeState: State<ScanCartQrCodeState> = _scanCartQrCodeState

    init {
        cartScannerService.onRegistered = {
            _scanCartQrCodeState.value = scanCartQrCodeState.value.copy(
                isRegistered = true
            )
        }
    }

    fun onNavigatedTo() {
        barcodeScanner.onBarcodeScanned = { barcode ->
            handleScanCartQrCodeScan(barcode)
        }
    }

    fun onBack() {
        viewModelScope.launch(ioDispatcher) {
            cartScannerService.unregisterCart()
        }
    }

    fun clearError() {
        _scanCartQrCodeState.value = scanCartQrCodeState.value.copy(
            error = ""
        )
    }

    private fun handleScanCartQrCodeScan(cartIdentifier: String) {
        if (cartIdentifier.length != UUID_LENGTH) {
            vibratorService.singleClick()
            soundService.playNegativeFeedbackSound()
            _scanCartQrCodeState.value = scanCartQrCodeState.value.copy(
                error = "${context.getString(R.string.pickmod_scanner_invalid_cart_qr_code_inline_error)}: $cartIdentifier",
            )

            return
        }

        if (connectivityService.isOnline()) {
            viewModelScope.launch(ioDispatcher) {
                cartScannerService.registerCart(cartIdentifier)
            }
        } else {
            vibratorService.singleClick()
            soundService.playNegativeFeedbackSound()
            _scanCartQrCodeState.value = scanCartQrCodeState.value.copy(
                error = context.getString(R.string.pickmod_scanner_reconnecting_please_wait_error)
            )
        }
    }
}
