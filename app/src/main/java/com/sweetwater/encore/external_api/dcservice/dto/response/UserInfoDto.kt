package com.sweetwater.encore.external_api.dcservice.dto.response

data class UserInfoDto(
    val campusId: Int,
    val employeeId: Int,
    val employeeNumber: Int,
    val icon: String,
    val id: Int,
    val name: String,
    val personalLocationId: Int,
    val personalLocationName: String,
    val role: Int
)