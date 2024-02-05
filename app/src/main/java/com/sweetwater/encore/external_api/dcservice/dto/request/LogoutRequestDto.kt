package com.sweetwater.encore.external_api.dcservice.dto.request

import com.google.gson.annotations.SerializedName

data class LogoutRequestDto(

    @SerializedName("userId")
    val employeeNumber: Int
)