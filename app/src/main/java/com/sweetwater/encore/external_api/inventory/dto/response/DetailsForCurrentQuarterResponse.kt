package com.sweetwater.encore.external_api.inventory.dto.response

import com.google.gson.annotations.SerializedName
import com.sweetwater.encore.external_api.inventory.dto.CycleCountDisplayStats
import com.sweetwater.encore.external_api.inventory.dto.CycleCountZone

data class DetailsForCurrentQuarterResponse (
    @SerializedName("displayStats")
    val displayStats: CycleCountDisplayStats,

    @SerializedName("zones")
    val zones: List<CycleCountZone>
)