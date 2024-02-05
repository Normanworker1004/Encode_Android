package com.sweetwater.encore.external_api.inventory.dto

data class CycleCountZone(
    val zoneName: String,
    val zoneId: Int,
    val percentCounted: Double,
    val countPriority: Int
)
