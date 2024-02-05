package com.sweetwater.encore.dependency_injection.cart_scanner.dto

import androidx.compose.ui.text.input.KeyboardType

data class CartScannerScreenInstructions(
    val title: String = "",
    val subtitle1: String = "",
    val subtitle2: String = "",
    val imageURL: String = "",
    val isKeyboardIconVisible: Boolean = true,
    val keyboardType: KeyboardType = KeyboardType.Text
)