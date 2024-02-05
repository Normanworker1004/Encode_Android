package com.sweetwater.encore.external_api.dcservice.remote

import com.sweetwater.encore.external_api.dcservice.dto.request.LoginRequestDto
import com.sweetwater.encore.external_api.dcservice.dto.request.LogoutRequestDto
import com.sweetwater.encore.external_api.dcservice.dto.response.LogoutResponseDto
import com.sweetwater.encore.external_api.dcservice.dto.response.UserInfoDto
import retrofit2.http.Body
import retrofit2.http.POST

interface DcServiceAPI {
    @POST("dcLoginUser")
    suspend fun loginUser(@Body loginRequest: LoginRequestDto): UserInfoDto

    @POST("dcLogoutUser")
    suspend fun logoutUser(@Body logoutRequest: LogoutRequestDto): LogoutResponseDto
}