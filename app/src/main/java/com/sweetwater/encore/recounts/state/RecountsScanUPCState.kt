package com.sweetwater.encore.recounts.state

import com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance
import com.sweetwater.encore.recounts.data.dto.RecountLocationDto
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto
import java.time.LocalDateTime

data class RecountsScanUPCState(
    val recountRequest: RecountRequestDto? = null,
    val recountLocations: List<RecountLocationDto>,
    val isVarianceDetected: Boolean = false,
    val locationName: String = "",
    var countedQuantity: Int = 0,
    val countStartAt: LocalDateTime? = null,
    val isKeyboardToggled: Boolean = false,
    val updatingQuantity: Boolean = false,
    val errorMessage: String = "",
    val isLoading: Boolean = false,
    val displayFullScreenError: Boolean = false,
    val productIdsWithVariance: ProductIdsWithVariance? = null,
    val hasCompletedRecount: Boolean = false,
    val promptForSerialNumber: Boolean = false,
    val expectedSerialNumber: String = "",
    val inputSerialNumber: String = ""
) {
    companion object {
        fun initialState() = RecountsScanUPCState(
            recountLocations = emptyList()
        )
    }
}