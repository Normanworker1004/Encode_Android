package com.sweetwater.encore.authorization.data.mappers

import com.sweetwater.encore.UserInfoMessage
import com.sweetwater.encore.authorization.data.model.login.request.LoginRequest
import com.sweetwater.encore.authorization.data.model.login.response.UserInfo
import com.sweetwater.encore.authorization.data.model.logout.request.LogoutRequest
import com.sweetwater.encore.authorization.data.model.logout.response.LogoutResponse
import com.sweetwater.encore.external_api.dcservice.dto.request.LoginRequestDto
import com.sweetwater.encore.external_api.dcservice.dto.request.LogoutRequestDto
import com.sweetwater.encore.external_api.dcservice.dto.response.LogoutResponseDto
import com.sweetwater.encore.external_api.dcservice.dto.response.UserInfoDto

/* Login Mapper Extension functions */

fun LoginRequest.toLoginRequestDto(): LoginRequestDto {
    return LoginRequestDto(
        apnsToken = apnsToken,
        deviceIP = deviceIP,
        deviceIdentifier = deviceIdentifier,
        employeeNumber = employeeNumber
    )
}

fun LogoutRequest.toLogoutRequestDto(): LogoutRequestDto {
    return LogoutRequestDto(
        employeeNumber = employeeNumber
    )
}

fun LogoutResponseDto.toLogoutResponse(): LogoutResponse {
    return LogoutResponse(
        ok = ok
    )
}

fun UserInfoMessage.toUserInfoDto(): UserInfoDto {
    return UserInfoDto(
        campusId = campusId,
        employeeId = employeeId,
        employeeNumber = employeeNumber,
        icon = icon,
        id = id,
        name = name,
        personalLocationId = personalLocationId,
        personalLocationName = personalLocationName,
        role = role,
    )
}

fun UserInfoDto.toUserInfo(): UserInfo {
    return UserInfo(
        campusId = campusId,
        employeeId = employeeId,
        employeeNumber = employeeNumber,
        icon = icon,
        id = id,
        name = name,
        personalLocationId = personalLocationId,
        personalLocationName = personalLocationName,
        role = role,
    )
}