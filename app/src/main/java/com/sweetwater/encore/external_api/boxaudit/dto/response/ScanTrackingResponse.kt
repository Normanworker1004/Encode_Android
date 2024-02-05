package com.sweetwater.encore.external_api.boxaudit.dto.response

import com.google.gson.annotations.SerializedName
import com.sweetwater.encore.external_api.boxaudit.dto.BoxAuditPackedBox
import com.sweetwater.encore.external_api.boxaudit.dto.BoxAuditQuestion

data class ScanTrackingResponse (
    @SerializedName("packedBox")
    val packedBox: BoxAuditPackedBox,

    @SerializedName("questions")
    val questions: List<BoxAuditQuestion>
)