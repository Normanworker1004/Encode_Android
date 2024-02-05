package com.sweetwater.encore.cart_scanner.viewmodels

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.R
import com.sweetwater.encore.cart_scanner.state.CartScannerState
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner
import com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError
import com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService
import com.sweetwater.encore.dependency_injection.sound.ISoundService
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService
import com.sweetwater.encore.utilities.IKeyboardInputViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartScannerViewModel @Inject constructor(
    private val context: Context,
    private val cartScannerService: ICartScannerService,
    private val barcodeScanner: IBarcodeScanner,
    private val connectivityService: IConnectivityService,
    private val soundService: ISoundService,
    private val vibratorService: IVibratorService,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel(), IKeyboardInputViewModel {
    private val _cartScannerState = mutableStateOf(
        CartScannerState()
    )
    val cartScannerState: State<CartScannerState> = _cartScannerState

    init {
        if (cartScannerService.currentInstructions != null) {
            _cartScannerState.value = cartScannerState.value.copy(
                instructions = cartScannerService.currentInstructions!!
            )
        }

        cartScannerService.onInstructions = { instructions ->
            _cartScannerState.value = cartScannerState.value.copy(
                instructions = instructions
            )

            if (instructions.title == "Pick Complete") {
                soundService.playPositiveFeedbackSound()
            }
        }

        cartScannerService.onUnregistered = {
            _cartScannerState.value = cartScannerState.value.copy(
                isUnregistered = true
            )
        }

        cartScannerService.onError = { cartError ->
            vibratorService.singleClick()
            soundService.playNegativeFeedbackSound()
            _cartScannerState.value = cartScannerState.value.copy(
                cartError = cartError
            )
        }
    }

    override fun onKeyboardToggled(isToggled: Boolean) {
        _cartScannerState.value = cartScannerState.value.copy(
            isKeyboardToggled = isToggled,
        )
    }

    override fun onConfirmKeyboard(text: String) {
        _cartScannerState.value = cartScannerState.value.copy(
            isKeyboardToggled = false,
        )

        handleBarcodeScan(text)
    }

    fun onNavigatedTo() {
        barcodeScanner.onBarcodeScanned = { barcode ->
            handleBarcodeScan(barcode);
        }
    }

    fun onBack() {
        viewModelScope.launch(ioDispatcher) {
            _cartScannerState.value = cartScannerState.value.copy(
                isUnregistered = false
            )
            cartScannerService.unregisterCart()
        }
    }

    fun clearError() {
        _cartScannerState.value = cartScannerState.value.copy(
            cartError = null
        )
    }

    private fun handleBarcodeScan(scannedBarcode: String) {
        if (connectivityService.isOnline()) {
            viewModelScope.launch(ioDispatcher) {
                cartScannerService.sendMessageToCart(scannedBarcode)
            }
        } else {
            vibratorService.singleClick()
            soundService.playNegativeFeedbackSound()
            _cartScannerState.value = cartScannerState.value.copy(
                cartError = CartError(
                    title = context.getString(R.string.pickmod_scanner_reconnecting_please_wait_error),
                    message = context.getString(R.string.pickmod_scanner_cart_scanner_no_internet_message)
                ),
            )
        }
    }
}