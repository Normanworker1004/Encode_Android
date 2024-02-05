package com.sweetwater.encore.authorization.data.model.login.response

data class UserInfo(
    val campusId: Int,
    val employeeId: Int,
    val employeeNumber: Int,
    val icon: String,
    val id: Int,
    val name: String,
    val personalLocationId: Int,
    val personalLocationName: String,
    val role: Int
) {
    companion object {
        fun initialState(): UserInfo {
            return UserInfo(
                campusId = -1,
                employeeNumber = -1,
                employeeId = -1,
                icon = "",
                id = -1,
                name = "",
                personalLocationId = -1,
                personalLocationName = "",
                role = -1
            )
        }
    }
}