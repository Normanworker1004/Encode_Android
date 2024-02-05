package com.sweetwater.encore.cart_scanner.state

data class ScanCartQrCodeState(
    val error: String = "",
    var isRegistered: Boolean = false,
)
