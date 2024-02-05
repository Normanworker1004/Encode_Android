package com.sweetwater.encore.utilities

import com.google.gson.annotations.SerializedName

data class ApiErrorResponse(
    @SerializedName("message")
    val message: String,

    @SerializedName("error")
    val error: String,

    @SerializedName("statusCode")
    val statusCode: Int
)