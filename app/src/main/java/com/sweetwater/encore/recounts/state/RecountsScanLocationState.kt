package com.sweetwater.encore.recounts.state

import com.sweetwater.encore.recounts.data.dto.RecountLocationDto
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto

data class RecountsScanLocationState(
    val recountRequest: RecountRequestDto? = null,
    val recountLocations: List<RecountLocationDto>,
    val matchedLocation: String? = null,
    val error: String = "",
    val displayFullscreenError: Boolean = false,
    val showDialog: Boolean = false,
    val isKeyboardToggled: Boolean = false,
    val additionalLocationName: String = "",
    val addingLocation: Boolean = false,
    val addLocationError: String = "",
    val isLoading: Boolean = false,
) {
    companion object {
        fun initialState() = RecountsScanLocationState(
            recountLocations = emptyList(),
        )
    }
}