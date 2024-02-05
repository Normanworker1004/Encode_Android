package com.sweetwater.encore.external_api.inventory.remote

import com.sweetwater.encore.external_api.inventory.dto.requests.RecountLocationRequest
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
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Url

interface InventoryAPI {
    @GET
    suspend fun getDetailsForCurrentQuarter(@Url chooseZoneUrl: String): DetailsForCurrentQuarterResponse

    @POST
    suspend fun assignCountRequestsForZone(@Url assignCountRequestUrl: String): List<AssignedLocationResponse>

    @POST
    suspend fun uploadProductCountsForCountRequest(
        @Url uploadProductCountsRequestUrl: String,
        @Body uploadProductCountsRequestBody: List<UploadProductCountsRequest>
    )

    @GET
    suspend fun getRecountsSummary(@Url recountsSummaryUrl: String): List<RecountsZone>

    @GET
    suspend fun getRecountsDailyStatistics(@Url dailyStatisticsUrl: String): RecountsDisplayStats

    @GET
    suspend fun getRecountRequestsForZone(@Url recountRequestsForZoneUrl: String): List<RecountRequestDto>

    @GET
    suspend fun getRecountLocationsForRequest(@Url recountLocationsForRequestUrl: String): List<RecountLocationDto>
    
    @GET
    suspend fun getLocationByName(@Url locationByNameUrl: String): LocationResponse

    @POST
    suspend fun addLocationToRecount(
        @Url addLocationToRecountUrl: String,
        @Body recountLocations: List<RecountLocationRequest>
    ): List<ProductRecountLocationResponse>

    @PUT
    suspend fun uploadProductRecountsForRecountRequest(
        @Url uploadRecountUrl: String,
        @Body recountRequests: UploadRecountRequest
    )
}