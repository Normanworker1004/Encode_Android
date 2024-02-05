package com.sweetwater.encore.cart_scanner.state

import androidx.compose.ui.graphics.painter.Painter
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions

data class CartScannerState(
    val isKeyboardToggled: Boolean = false,
    val cartError: CartError? = null,
    val instructions: CartScannerScreenInstructions = CartScannerScreenInstructions(),
    val previewImage: Painter? = null,
    var isUnregistered: Boolean = false,
) {
}
