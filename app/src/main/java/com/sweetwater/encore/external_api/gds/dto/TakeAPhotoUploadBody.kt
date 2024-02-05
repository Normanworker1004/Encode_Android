package com.sweetwater.encore.external_api.gds.dto

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class TakeAPhotoUploadBody(
    private val employeeId: String,
    private val employeeName: String,
    private val image: File,
    private val tag: String,
    private val description: String
) {
    fun build(): RequestBody {
        return MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("creator_id", employeeId)
            .addFormDataPart("creator_app", "Encore")
            .addFormDataPart(
                "document",
                "${tag}.png",
                RequestBody.create("image/*".toMediaTypeOrNull(), image)
            )
            .addFormDataPart("type", "Picture")
            .addFormDataPart("creator_username", employeeName)
            .addFormDataPart("tags", tag)
            .addFormDataPart("description", description)
            .build()
    }
}