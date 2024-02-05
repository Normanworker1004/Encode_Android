package com.sweetwater.encore.dependency_injection.barcode_scanner

interface IBarcodeScanner {
    var onBarcodeScanned: (barcode: String) -> Unit
}