package com.sweetwater.encore.external_api.dcservice.dto.request

data class LoginRequestDto(
    val apnsToken: String,
    val deviceIP: String,
    val deviceIdentifier: String,
    val employeeNumber: Int
)