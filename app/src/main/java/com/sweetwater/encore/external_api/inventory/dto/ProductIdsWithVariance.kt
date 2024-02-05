package com.sweetwater.encore.external_api.inventory.dto

import com.google.gson.annotations.SerializedName

data class ProductIdsWithVariance(
    @SerializedName("variancedProductIds")
    val productIdsWithVariance: List<Int>
)