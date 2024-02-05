package com.sweetwater.encore.external_api.inventory.dto

data class CycleCountDisplayStats(
    val locationsCountedToday: Int,
    val itemsCountedToday: Int,
    val zoneCountedPercentForQuarter: Double
)