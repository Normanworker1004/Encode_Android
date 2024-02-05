package com.sweetwater.encore.recounts.data.dto

data class RecountsDisplayStats(
    val locationsWithVariances: Int,
    val totalVariances: Int,
    val totalVarianceInDollars: Double
)