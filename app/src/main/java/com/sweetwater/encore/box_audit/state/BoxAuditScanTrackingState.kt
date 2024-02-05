package com.sweetwater.encore.box_audit.state

import com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse

data class BoxAuditScanTrackingState(
    val selectedPackArea: String = "",
    val packAreaOptions: List<String> = emptyList(),
    val boxAuditResponse: ScanTrackingResponse? = null,
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val displayFullScreenError: Boolean = false,
) {

    companion object {
        fun initialState() = BoxAuditScanTrackingState(
            selectedPackArea = "Conveyable",
            packAreaOptions = listOf("Conveyable", "NonCon", "Guitars")
        )
    }

}