package com.sweetwater.encore.recounts.state

import com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats
import com.sweetwater.encore.recounts.data.dto.RecountsZone

data class RecountsChooseZoneState(
    val isLoading: Boolean = false,
    val error: String = "",
    val displayStats: RecountsDisplayStats,
    val zones: List<RecountsZone>,
) {
    companion object {
        fun initialState() = RecountsChooseZoneState(
            zones = emptyList(),
            displayStats = RecountsDisplayStats(
                locationsWithVariances = 0,
                totalVarianceInDollars = 0.0,
                totalVariances = 0
            ),
        )
    }
}