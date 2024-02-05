package com.sweetwater.encore.recounts.state

import com.sweetwater.encore.recounts.data.dto.RecountLocationDto
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto

data class RecountsScanProductState(
    val requests: List<RecountRequestDto>,
    val locations: List<RecountLocationDto>,
    val error: String = "",
    val isLoading: Boolean = false,
) {
    companion object {
        fun initialState() = RecountsScanProductState(
            requests = emptyList(),
            locations = emptyList()
        )
    }
}