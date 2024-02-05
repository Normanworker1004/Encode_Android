package com.sweetwater.encore.external_api.gds.remote

import com.sweetwater.encore.external_api.gds.dto.TakeAPhotoResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface GDSAPI {
    @POST
    suspend fun uploadTakeAPhotoEntry(@Url takeAPhotoUploadUrl: String, @Body takeAPhotoUploadBody: RequestBody): TakeAPhotoResponse
}