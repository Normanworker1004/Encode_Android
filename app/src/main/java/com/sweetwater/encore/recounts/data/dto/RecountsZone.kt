package com.sweetwater.encore.recounts.data.dto

data class RecountsZone(
    val zoneId: Int,
    val zoneName: String,
    val highPriorityLocationsCount: Int,
    val lowPriorityLocationsCount: Int
)