package com.sweetwater.encore.cycle_counts.dto

data class ProductScanInfo(
    val productId: Int,
    val name: String,
    val imageUrl: String,
    val productManufacturer: String,
    val shortDescription: String,
    val isQuantityKeyed: Boolean,
    val isIdentifierKeyed: Boolean,
    var productQuantity: Int,
    var serialNumber: String,
    val isSerialNumberRequired: Boolean = false,
    val isVarianceDetected: Boolean = false,
    val productIdentifiers: List<String>,
    val countForProductStartedAt: String
) {
    companion object {
        fun initialState() = ProductScanInfo(
            productId = 0,
            name = "",
            imageUrl = "",
            productManufacturer = "",
            shortDescription = "",
            serialNumber = "",
            isIdentifierKeyed = false,
            isQuantityKeyed = false,
            productQuantity = 0,
            productIdentifiers = emptyList(),
            countForProductStartedAt = ""
        )
    }
}