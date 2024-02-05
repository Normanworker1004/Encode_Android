package com.sweetwater.encore.authorization.data.model.login.request

data class LoginRequest(
    val apnsToken: String,
    val deviceIP: String,
    val deviceIdentifier: String,
    val employeeNumber: Int
)