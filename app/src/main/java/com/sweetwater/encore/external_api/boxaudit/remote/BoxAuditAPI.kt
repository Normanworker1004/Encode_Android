package com.sweetwater.encore.external_api.boxaudit.remote

import com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface BoxAuditAPI {
    @GET
    suspend fun getBoxAudit(@Url boxAuditUrl: String): ScanTrackingResponse
}