package com.sweetwater.encore.external_api.gds.repository

import android.content.Context
import android.net.Uri
import com.sweetwater.encore.BuildConfig
import com.sweetwater.encore.R
import com.sweetwater.encore.external_api.gds.dto.TakeAPhotoResponse
import com.sweetwater.encore.external_api.gds.dto.TakeAPhotoUploadBody
import com.sweetwater.encore.external_api.gds.remote.GDSAPI
import com.sweetwater.encore.external_api.gds.repository.interfaces.IGDSRepository
import com.sweetwater.encore.utilities.ErrorMessage
import com.sweetwater.encore.utilities.Resource
import com.sweetwater.encore.helpers.enums.GDSPath
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.File
import javax.inject.Inject

class GDSRepository @Inject constructor(
    private val gdsAPI: GDSAPI, private val context: Context
) : IGDSRepository {
    override suspend fun uploadTakeAPhotoEntry(
        tag: String, image: Uri, description: String, employeeId: String, employeeName: String
    ) : Flow<Resource<TakeAPhotoResponse>> = flow {
        emit(Resource.Loading(true))

        try {
            val generatedUrl = "${BuildConfig.GDS_BASE_URL}${GDSPath.UploadTakeAPhoto.path}"

            val requestBody = TakeAPhotoUploadBody(
                employeeId = employeeId,
                employeeName = employeeName,
                image = File(image.path),
                description = description,
                tag = tag
            ).build()

            var response = gdsAPI.uploadTakeAPhotoEntry(
                takeAPhotoUploadUrl = generatedUrl,
                takeAPhotoUploadBody = requestBody
            )

            emit(Resource.Success(data = response))
            emit(Resource.Loading(isLoading = false))

        } catch (e: Exception){
            android.util.Log.e("GDS Repository", "TakeAPhoto : ", e)
            val errorMessage = getErrorMessage(e);
            android.util.Log.e("TakeAPhotoError", errorMessage.customMessage)
            android.util.Log.e("TakeAPhotoError", errorMessage.message)

            emit(
                Resource.Error(
                    message = errorMessage
                )
            )
            emit(Resource.Loading(false))
            return@flow
        }
    }

    private fun getErrorMessage(e: Exception): ErrorMessage.CustomErrorMessage {
        val customMessage = if (e.message.isNullOrEmpty()) {
            context.getString(R.string.cycle_count_something_wrong_try_again_error)
        } else {
            e.message
        }

        val errorMessage = when (e) {
            is HttpException -> {
                ErrorMessage.CustomErrorMessage(
                    errorCode = e.code(),
                    customMessage = "${context.getString(R.string.cycle_count_error_code_inline_label)} ${e.code()} , $customMessage"
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