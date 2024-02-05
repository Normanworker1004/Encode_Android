package com.sweetwater.encore.external_api.products.dto

data class ProductInfo(
    val captureShippedSerialNumber: Boolean,
    val category: String,
    val categoryId: Int,
    val condition: String,
    val cost: String,
    val imageURL: String,
    val inStockExternal: Int,
    val isMeasured: Boolean,
    val locationId: Int,
    val manufacturer: String,
    val manufacturerId: Int,
    val name: String,
    val packingTreatment: Int,
    val partNumber: String,
    val pick: Boolean,
    val productBoxes: List<ProductBoxDto>,
    val productId: Int,
    val productIdentifiers: List<String>,
    val requiresSerialNumber: Boolean,
    val shortDescription: String,
    val weight: Double
)