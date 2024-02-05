package com.sweetwater.encore.external_api.inventory.repository.interfaces

import com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance
import com.sweetwater.encore.external_api.inventory.dto.requests.UploadProductCountsRequest
import com.sweetwater.encore.external_api.inventory.dto.requests.UploadRecountRequest
import com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse
import com.sweetwater.encore.external_api.inventory.dto.response.DetailsForCurrentQuarterResponse
import com.sweetwater.encore.external_api.inventory.dto.response.LocationResponse
import com.sweetwater.encore.external_api.inventory.dto.response.ProductRecountLocationResponse
import com.sweetwater.encore.recounts.data.dto.RecountLocationDto
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto
import com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats
import com.sweetwater.encore.recounts.data.dto.RecountsZone
import com.sweetwater.encore.utilities.Resource
import kotlinx.coroutines.flow.Flow

interface IInventoryRepository {
    suspend fun getCountDetailsForQuarter(
        campusId: String,
        employeeId: Int
    ): Flow<Resource<DetailsForCurrentQuarterResponse>>

    suspend fun assignCountRequestsForZone(
        campusId: String,
        employeeId: Int,
        zoneId: Int
    ): Flow<Resource<List<AssignedLocationResponse>>>

    suspend fun uploadProductCountsForCountRequest(
        requests: List<UploadProductCountsRequest>,
        force: Boolean,
        campusId: String,
        countRequestId: Int
    ): Flow<Resource<ProductIdsWithVariance?>>

    suspend fun getRecountsSummary(
        campusId: String
    ): Flow<Resource<List<RecountsZone>>>

    suspend fun getRecountsDailyStatistics(
        campusId: String,
        employeeId: Int
    ): Flow<Resource<RecountsDisplayStats>>

    suspend fun getRecountRequestsForZone(
        zoneId: Int,
        campusId: String
    ): Flow<Resource<List<RecountRequestDto>>>

    suspend fun getRecountLocationsForRequest(
        recountRequestId: Int,
        campusId: String
    ): Flow<Resource<List<RecountLocationDto>>>

    suspend fun uploadProductRecountsForRecountRequest(
        campusId: String,
        recountRequestId: Int,
        recountLocationId: Int,
        uploadRecountRequest: UploadRecountRequest,
        force: Boolean
    ): Flow<Resource<ProductIdsWithVariance?>>

    suspend fun getLocationByName(
        locationName: String,
        campusId: String,
    ): Flow<Resource<LocationResponse>>

    suspend fun addLocationToRecount(
        locationId: Int,
        recountPriority: Int,
        recountRequestId: Int,
        campusId: String
    ): Flow<Resource<List<ProductRecountLocationResponse>>>
}