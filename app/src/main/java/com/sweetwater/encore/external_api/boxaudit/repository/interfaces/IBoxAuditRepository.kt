package com.sweetwater.encore.external_api.boxaudit.repository.interfaces

import com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse
import com.sweetwater.encore.utilities.Resource
import kotlinx.coroutines.flow.Flow

interface IBoxAuditRepository {

    suspend fun getBoxAuditDetails(
        barcode: String,
        selectedQuestions: String,
        campusId: String
    ): Flow<Resource<ScanTrackingResponse>>
}