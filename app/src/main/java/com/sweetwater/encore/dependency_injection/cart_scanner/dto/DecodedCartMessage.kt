package com.sweetwater.encore.dependency_injection.cart_scanner.dto

data class DecodedCartMessage(
    val instructions: CartScannerScreenInstructions? = null,
    val isUnregistering: Boolean = false,
    val isRegistering: Boolean = false,
    val error: CartError? = null
)