package com.sweetwater.encore.dependency_injection.cart_scanner

import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions

interface ICartScannerService {
    val currentInstructions: CartScannerScreenInstructions??
    val cartIdentifier: String

    var onInstructions: (instructions: CartScannerScreenInstructions) -> Unit
    var onUnregistered: () -> Unit
    var onRegistered: () -> Unit
    var onError: (error: CartError) -> Unit

    suspend fun sendMessageToCart(message: String)

    suspend fun registerCart(cartIdentifier: String)

    suspend fun unregisterCart()
}