package com.sweetwater.encore.cycle_counts.state

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse

data class CycleCountScanLocationState(
    val isLoading: Boolean = false,
    val assignedLocations: SnapshotStateList<AssignedLocationResponse>,
    val error: String = "",
    val locationMatched: Boolean? = null,
    val keyboardToggled: Boolean = false,
) {

    companion object {
        fun initialState() = CycleCountScanLocationState(
            assignedLocations = SnapshotStateList(),
        )
    }
}