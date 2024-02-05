package com.sweetwater.encore.external_api.inventory.repository

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.sweetwater.encore.BuildConfig
import com.sweetwater.encore.R
import com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance
import com.sweetwater.encore.external_api.inventory.dto.requests.RecountLocationRequest
import com.sweetwater.encore.external_api.inventory.dto.requests.UploadProductCountsRequest
import com.sweetwater.encore.external_api.inventory.dto.requests.UploadRecountRequest
import com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse
import com.sweetwater.encore.external_api.inventory.dto.response.DetailsForCurrentQuarterResponse
import com.sweetwater.encore.external_api.inventory.dto.response.LocationResponse
import com.sweetwater.encore.external_api.inventory.dto.response.ProductRecountLocationResponse
import com.sweetwater.encore.external_api.inventory.remote.InventoryAPI
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository
import com.sweetwater.encore.helpers.enums.InventoryPath
import com.sweetwater.encore.helpers.functions.HelperFunctions.Companion.getUrlForCampus
import com.sweetwater.encore.recounts.data.dto.RecountLocationDto
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto
import com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats
import com.sweetwater.encore.recounts.data.dto.RecountsZone
import com.sweetwater.encore.utilities.ApiErrorResponse
import com.sweetwater.encore.utilities.ErrorMessage
import com.sweetwater.encore.utilities.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class InventoryRepository @Inject constructor(
    private val inventoryAPI: InventoryAPI, private val context: Context
) : IInventoryRepository {
    override suspend fun getCountDetailsForQuarter(
        campusId: String, employeeId: Int
    ): Flow<Resource<DetailsForCurrentQuarterResponse>> = flow {
        emit(Resource.Loading(true))

        try {
            var generatedUrl = getUrlForCampus(
                fwaUrl = BuildConfig.INVENTORY_API_FWA_BASE_URL,
                phxUrl = BuildConfig.INVENTORY_API_PHX_BASE_URL,
                endpointUrl = InventoryPath.GetCurrentQuarterDetail.path,
                campusId = campusId
            )
            if (generatedUrl.isEmpty()) {
                return@flow
            }

            generatedUrl = generatedUrl.replace(
                oldValue = ":employeeId", newValue = employeeId.toString()
            )

            var detailsForCurrentQuarter = inventoryAPI.getDetailsForCurrentQuarter(
                chooseZoneUrl = generatedUrl
            )

            emit(Resource.Success(data = detailsForCurrentQuarter))
            emit(Resource.Loading(isLoading = false))
        } catch (e: Exception) {
            Log.e("InventoryRepository", "GetCountDetailsForQuarter : ", e)

            val apiErrorString = getApiErrorString(e)
            val apiErrorBody = getApiErrorResponse(apiErrorString)
            val errorMessage = getErrorMessage(e, apiErrorBody)

            emit(
                Resource.Error(
                    message = errorMessage
                )
            )
            emit(Resource.Loading(false))
            return@flow
        }
    }

    override suspend fun assignCountRequestsForZone(
        campusId: String, employeeId: Int, zoneId: Int
    ): Flow<Resource<List<AssignedLocationResponse>>> = flow {
        emit(Resource.Loading(true))
        try {
            var generatedUrl = getUrlForCampus(
                fwaUrl = BuildConfig.INVENTORY_API_FWA_BASE_URL,
                phxUrl = BuildConfig.INVENTORY_API_PHX_BASE_URL,
                endpointUrl = InventoryPath.AssignCountRequests.path,
                campusId = campusId
            )
            if (generatedUrl.isEmpty()) {
                return@flow
            }

            generatedUrl =
                generatedUrl.replace(oldValue = ":employeeId", newValue = employeeId.toString())
                    .replace(oldValue = ":zoneId", newValue = zoneId.toString())

            val assignedLocations = inventoryAPI.assignCountRequestsForZone(
                generatedUrl
            )

            emit(Resource.Success(data = assignedLocations))
            emit(Resource.Loading(isLoading = false))
        } catch (e: Exception) {
            Log.e("InventoryRepository", "AssignCountRequestsForZone : ", e)

            val apiErrorString = getApiErrorString(e)
            val apiErrorBody = getApiErrorResponse(apiErrorString)
            val errorMessage = getErrorMessage(e, apiErrorBody)

            emit(
                Resource.Error(
                    message = errorMessage
                )
            )
            emit(Resource.Loading(false))
            return@flow
        }
    }

    override suspend fun uploadProductCountsForCountRequest(
        requests: List<UploadProductCountsRequest>,
        force: Boolean,
        campusId: String,
        countRequestId: Int
    ): Flow<Resource<ProductIdsWithVariance?>> = flow {
        emit(Resource.Loading(true))
        try {
            var generatedUrl = getUrlForCampus(
                fwaUrl = BuildConfig.INVENTORY_API_FWA_BASE_URL,
                phxUrl = BuildConfig.INVENTORY_API_PHX_BASE_URL,
                endpointUrl = InventoryPath.UploadCount.path,
                campusId = campusId
            )
            if (generatedUrl.isEmpty()) {
                return@flow
            }

            generatedUrl = generatedUrl.replace(oldValue = ":force", newValue = force.toString())
                .replace(oldValue = ":countRequestId", newValue = countRequestId.toString())

            inventoryAPI.uploadProductCountsForCountRequest(
                generatedUrl, requests
            )

            emit(Resource.Success(data = null))
            emit(Resource.Loading(isLoading = false))
        } catch (e: Exception) {
            Log.e("InventoryRepository", "UploadProductCountsForCountRequest : ", e)

            val apiErrorString = getApiErrorString(e)
            val apiErrorBody = getApiErrorResponse(apiErrorString)
            val errorMessage = getErrorMessage(e, apiErrorBody)

            if (apiErrorString?.contains("variancedProductIds") == true) {
                val gson = Gson()
                val productIdsWithVariance: ProductIdsWithVariance? = if (apiErrorString != null) {
                    gson.fromJson(
                        apiErrorString,
                        ProductIdsWithVariance::class.java
                    )
                } else {
                    null
                }

                emit(
                    Resource.Error(
                        message = errorMessage,
                        data = productIdsWithVariance
                    )
                )
                emit(Resource.Loading(false))
                return@flow
            } else {
                emit(
                    Resource.Error(
                        message = errorMessage
                    )
                )
                emit(Resource.Loading(false))
                return@flow
            }
        }
    }

    override suspend fun getRecountsSummary(
        campusId: String
    ): Flow<Resource<List<RecountsZone>>> = flow {
        emit(Resource.Loading(true))

        try {
            var generatedUrl = getUrlForCampus(
                fwaUrl = BuildConfig.INVENTORY_API_FWA_BASE_URL,
                phxUrl = BuildConfig.INVENTORY_API_PHX_BASE_URL,
                endpointUrl = InventoryPath.GetRecountSummary.path,
                campusId = campusId
            )
            if (generatedUrl.isEmpty()) {
                return@flow
            }

            val chooseZoneResponse: List<RecountsZone> = inventoryAPI.getRecountsSummary(
                recountsSummaryUrl = generatedUrl
            )

            emit(Resource.Success(data = chooseZoneResponse))
            emit(Resource.Loading(false))
        } catch (e: Exception) {
            Log.e("InventoryRepository", "Get Recounts Summary Error : ", e)

            val apiErrorString = getApiErrorString(e)
            val apiErrorBody = getApiErrorResponse(apiErrorString)
            val errorMessage = getErrorMessage(e, apiErrorBody)

            emit(
                Resource.Error(
                    message = errorMessage
                )
            )
            emit(Resource.Loading(false))
            return@flow
        }
    }

    override suspend fun getRecountsDailyStatistics(
        campusId: String, employeeId: Int
    ): Flow<Resource<RecountsDisplayStats>> = flow {
        emit(Resource.Loading(true))

        try {
            var generatedUrl = getUrlForCampus(
                fwaUrl = BuildConfig.INVENTORY_API_FWA_BASE_URL,
                phxUrl = BuildConfig.INVENTORY_API_PHX_BASE_URL,
                endpointUrl = InventoryPath.GetDailyRecountStatistics.path,
                campusId = campusId
            )
            if (generatedUrl.isEmpty()) {
                return@flow
            }

            generatedUrl = generatedUrl.replace(
                oldValue = ":employeeId", newValue = employeeId.toString()
            )

            val response = inventoryAPI.getRecountsDailyStatistics(generatedUrl)
            emit(Resource.Loading(false))
            emit(Resource.Success(data = response))
            return@flow
        } catch (e: Exception) {
            Log.e("InventoryRepository", "Get Recounts Daily Statistics Error : ", e)

            val apiErrorString = getApiErrorString(e)
            val apiErrorBody = getApiErrorResponse(apiErrorString)
            val errorMessage = getErrorMessage(e, apiErrorBody)

            emit(
                Resource.Error(
                    message = errorMessage
                )
            )
            emit(Resource.Loading(false))
            return@flow
        }
    }

    override suspend fun getRecountRequestsForZone(
        zoneId: Int, campusId: String
    ): Flow<Resource<List<RecountRequestDto>>> = flow {
        emit(Resource.Loading(true))

        try {
            var generatedUrl = getUrlForCampus(
                fwaUrl = BuildConfig.INVENTORY_API_FWA_BASE_URL,
                phxUrl = BuildConfig.INVENTORY_API_PHX_BASE_URL,
                endpointUrl = InventoryPath.GetRecountRequestsForZone.path,
                campusId = campusId
            )
            if (generatedUrl.isEmpty()) {
                return@flow
            }

            generatedUrl = generatedUrl.replace(
                oldValue = ":zoneId", newValue = zoneId.toString()
            )

            val response = inventoryAPI.getRecountRequestsForZone(generatedUrl)
            emit(Resource.Success(data = response))
            emit(Resource.Loading(false))
        } catch (e: HttpException) {
            Log.e("InventoryRepository", "Get Recount Requests For Zone Error : ", e)

            val apiErrorString = getApiErrorString(e)
            val apiErrorBody = getApiErrorResponse(apiErrorString)
            val errorMessage = getErrorMessage(e, apiErrorBody)

            emit(
                Resource.Error(
                    message = errorMessage
                )
            )
            emit(Resource.Loading(false))
        }
    }

    override suspend fun getRecountLocationsForRequest(
        recountRequestId: Int,
        campusId: String
    ): Flow<Resource<List<RecountLocationDto>>> = flow {
        emit(Resource.Loading(true))

        try {
            var generatedUrl = getUrlForCampus(
                fwaUrl = BuildConfig.INVENTORY_API_FWA_BASE_URL,
                phxUrl = BuildConfig.INVENTORY_API_PHX_BASE_URL,
                endpointUrl = InventoryPath.GetRecountLocationsForRequest.path,
                campusId = campusId
            )
            if (generatedUrl.isEmpty()) {
                return@flow
            }

            generatedUrl = generatedUrl.replace(
                oldValue = ":recountRequestId", newValue = recountRequestId.toString()
            )

            val response = inventoryAPI.getRecountLocationsForRequest(generatedUrl)
            emit(Resource.Loading(false))
            emit(Resource.Success(data = response))
        } catch (e: HttpException) {
            Log.e("InventoryRepository", "Get Recount Locations For Request Error : ", e)

            val apiErrorString = getApiErrorString(e)
            val apiErrorBody = getApiErrorResponse(apiErrorString)
            val errorMessage = getErrorMessage(e, apiErrorBody)

            emit(
                Resource.Error(
                    message = errorMessage
                )
            )
            emit(Resource.Loading(false))
        }
    }

    override suspend fun uploadProductRecountsForRecountRequest(
        campusId: String,
        recountRequestId: Int,
        recountLocationId: Int,
        uploadRecountRequest: UploadRecountRequest,
        force: Boolean
    ): Flow<Resource<ProductIdsWithVariance?>> = flow {
        emit(Resource.Loading(true))

        try {
            var generatedUrl = getUrlForCampus(
                BuildConfig.INVENTORY_API_FWA_BASE_URL,
                BuildConfig.INVENTORY_API_PHX_BASE_URL,
                InventoryPath.UploadRecount.path,
                campusId
            )
            if (generatedUrl.isEmpty()) {
                return@flow
            }

            generatedUrl = generatedUrl.replace(
                oldValue = ":force", newValue = force.toString()
            ).replace(
                oldValue = ":recountRequestId", newValue = recountRequestId.toString(),
            ).replace(
                oldValue = ":recountLocationId", newValue = recountLocationId.toString()
            )

            inventoryAPI.uploadProductRecountsForRecountRequest(
                generatedUrl,
                uploadRecountRequest
            )

            emit(Resource.Success(data = null))
            emit(Resource.Loading(isLoading = false))
        } catch (e: Exception) {
            if (e is KotlinNullPointerException) { //Retrofit does not know what to do with a 204 no content, so it throws an error.
                emit(Resource.Success(data = null))
                emit(Resource.Loading(isLoading = false))
                return@flow
            }

            Log.e("InventoryRepository", "UploadProductCountsForCountRequest : ", e)

            val apiErrorString = getApiErrorString(e)
            val apiErrorBody = getApiErrorResponse(apiErrorString)
            val errorMessage = getErrorMessage(e, apiErrorBody)

            if (apiErrorString?.contains("variancedProductIds") == true) {
                val gson = Gson()
                val productIdsWithVariance: ProductIdsWithVariance? = if (apiErrorString != null) {
                    gson.fromJson(
                        apiErrorString,
                        ProductIdsWithVariance::class.java
                    )
                } else {
                    null
                }

                emit(
                    Resource.Error(
                        message = errorMessage,
                        data = productIdsWithVariance
                    )
                )
                emit(Resource.Loading(false))
                return@flow
            } else {
                emit(
                    Resource.Error(
                        message = errorMessage
                    )
                )
                emit(Resource.Loading(false))
                return@flow
            }
        }
    }

    override suspend fun getLocationByName(
        locationName: String,
        campusId: String
    ): Flow<Resource<LocationResponse>> = flow {
        emit(Resource.Loading(true))

        try {
            var generatedUrl = getUrlForCampus(
                fwaUrl = BuildConfig.INVENTORY_API_FWA_BASE_URL,
                phxUrl = BuildConfig.INVENTORY_API_PHX_BASE_URL,
                endpointUrl = InventoryPath.GetLocationByName.path,
                campusId = campusId
            )
            if (generatedUrl.isEmpty()) {
                return@flow
            }

            generatedUrl = generatedUrl.replace(
                oldValue = ":name", newValue = locationName
            )

            val response = inventoryAPI.getLocationByName(generatedUrl)
            emit(Resource.Loading(false))
            emit(Resource.Success(data = response))
            return@flow
        } catch (e: HttpException) {
            emit(Resource.Loading(false))
            Log.e("InventoryRepository", "Get Location By Name Error : ", e)

            val apiErrorString = getApiErrorString(e)
            val apiErrorBody = getApiErrorResponse(apiErrorString)
            val errorMessage = getErrorMessage(e, apiErrorBody)

            emit(
                Resource.Error(
                    message = errorMessage
                )
            )
            emit(Resource.Loading(false))
            return@flow
        }
    }

    override suspend fun addLocationToRecount(
        locationId: Int,
        recountPriority: Int,
        recountRequestId: Int,
        campusId: String
    ): Flow<Resource<List<ProductRecountLocationResponse>>> = flow {
        emit(Resource.Loading(true))

        try {
            var generatedUrl = getUrlForCampus(
                fwaUrl = BuildConfig.INVENTORY_API_FWA_BASE_URL,
                phxUrl = BuildConfig.INVENTORY_API_PHX_BASE_URL,
                endpointUrl = InventoryPath.AddLocationToRecount.path,
                campusId = campusId
            )
            if (generatedUrl.isEmpty()) {
                return@flow
            }

            generatedUrl = generatedUrl.replace(
                oldValue = ":recountRequestId", newValue = recountRequestId.toString()
            )

            val response = inventoryAPI.addLocationToRecount(
                generatedUrl,
                listOf(
                    RecountLocationRequest(
                        locationId = locationId,
                        recountPriority = recountPriority
                    )
                )
            )
            emit(Resource.Loading(false))
            emit(Resource.Success(data = response))
            return@flow
        } catch (e: HttpException) {
            emit(Resource.Loading(false))
            Log.e("InventoryRepository", "Add Location to Recount Error : ", e)

            val apiErrorString = getApiErrorString(e)
            val apiErrorBody = getApiErrorResponse(apiErrorString)
            val errorMessage = getErrorMessage(e, apiErrorBody)

            emit(
                Resource.Error(
                    message = errorMessage
                )
            )
            emit(Resource.Loading(false))
            return@flow
        }
    }

    private fun getErrorMessage(
        e: Exception,
        apiErrorResponse: ApiErrorResponse?
    ): ErrorMessage.CustomErrorMessage {
        val customMessage = if (e.message.isNullOrEmpty()) {
            context.getString(R.string.cycle_count_something_wrong_try_again_error)
        } else {
            e.message
        }

        val errorMessage = when (e) {
            is HttpException -> {
                ErrorMessage.CustomErrorMessage(
                    errorCode = e.code(),
                    customMessage = "${context.getString(R.string.cycle_count_error_code_inline_label)} ${e.code()} , ${apiErrorResponse?.message ?: customMessage}"
                )
            }

            else -> {
                ErrorMessage.CustomErrorMessage(
                    customMessage = "$customMessage"
                )
            }
        }

        return errorMessage
    }

    private fun getApiErrorString(e: Exception): String? {
        val getApiErrorString: String? = when (e) {
            is HttpException -> {
                e.response()?.errorBody()?.string()
            }

            else -> {
                null
            }
        }

        return getApiErrorString
    }

    private fun getApiErrorResponse(apiErrorString: String?): ApiErrorResponse? {
        val gson = Gson()
        val apiErrorResponse: ApiErrorResponse? = if (apiErrorString != null) {
            gson.fromJson(
                apiErrorString,
                ApiErrorResponse::class.java
            )
        } else {
            null
        }

        return apiErrorResponse
    }
}