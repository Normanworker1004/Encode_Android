package com.sweetwater.encore.external_api.products.dto

data class ProductBoxDto(
    val cubicInches: Double,
    val dimensionalWeight: Double,
    val height: Double,
    val id: Int,
    val length: Double,
    val normallyShipAlone: Boolean,
    val note: String,
    val weight: Double,
    val width: Double
)