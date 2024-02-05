package com.sweetwater.encore.external_api.boxaudit.repository

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.sweetwater.encore.BuildConfig
import com.sweetwater.encore.R
import com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse
import com.sweetwater.encore.external_api.boxaudit.remote.BoxAuditAPI
import com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository
import com.sweetwater.encore.helpers.enums.BoxAuditPath
import com.sweetwater.encore.helpers.functions.HelperFunctions
import com.sweetwater.encore.utilities.ApiErrorResponse
import com.sweetwater.encore.utilities.ErrorMessage
import com.sweetwater.encore.utilities.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class BoxAuditRepository @Inject constructor(
    private val boxAuditAPI: BoxAuditAPI, private val context: Context
): IBoxAuditRepository {
    override suspend fun getBoxAuditDetails(
        barcode: String,
        selectedQuestions: String,
        campusId: String
    ): Flow<Resource<ScanTrackingResponse>> = flow {
        emit(Resource.Loading(true))

        try {
            var generatedUrl = HelperFunctions.getUrlForCampus(
                fwaUrl = BuildConfig.BOX_AUDIT_API_FWA_BASE_URL,
                phxUrl = BuildConfig.BOX_AUDIT_API_PHX_BASE_URL,
                endpointUrl = BoxAuditPath.GetBoxAudit.path,
                campusId = campusId
            )
            if (generatedUrl.isEmpty()) {
                return@flow
            }

            generatedUrl = generatedUrl.replace(
                oldValue = ":shippingLabelBarcode", newValue = barcode
            ).replace(oldValue = ":questionScope", newValue = selectedQuestions)

            var boxAudit = boxAuditAPI.getBoxAudit(
                boxAuditUrl = generatedUrl
            )

            emit(Resource.Success(data = boxAudit))
            emit(Resource.Loading(isLoading = false))
        } catch (e: Exception) {
            Log.e("BoxAuditRepository", "GetBoxAudit : ", e)

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
}