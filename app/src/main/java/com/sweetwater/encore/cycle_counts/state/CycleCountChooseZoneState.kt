package com.sweetwater.encore.cycle_counts.state

import com.sweetwater.encore.external_api.inventory.dto.CycleCountDisplayStats
import com.sweetwater.encore.external_api.inventory.dto.response.DetailsForCurrentQuarterResponse

data class CycleCountChooseZoneState(
    val detailsForCurrentQuarter: DetailsForCurrentQuarterResponse,
    val isLoading: Boolean = false,
    val error: String = ""
) {
    companion object {
        fun initialState() = CycleCountChooseZoneState(
            detailsForCurrentQuarter = DetailsForCurrentQuarterResponse(
                displayStats = CycleCountDisplayStats(
                    itemsCountedToday = 0,
                    locationsCountedToday = 0,
                    zoneCountedPercentForQuarter = 0.0
                ),
                zones = emptyList()
            ),
            isLoading = false,
            error = ""
        )
    }
}
