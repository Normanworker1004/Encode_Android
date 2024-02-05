package com.sweetwater.encore.authorization.state

import com.sweetwater.encore.authorization.data.model.login.response.UserInfo

data class AppAuthState(

    val isLoggedIn: Boolean = false,
    val isLoggedOut: Boolean = false,

    val isLoading: Boolean = false,
    val isAutoLoginValidated : Boolean = false,
    val isManualLoginValidated : Boolean = false,
    val userData: UserInfo,

    val appVersionName: String,
    val error: String

) {

    companion object {

        fun initialState() = AppAuthState(
            userData = UserInfo(
                campusId = 2,
                employeeId = 5111,
                employeeNumber = 5111,
                id = 5111,
                icon = "Users Icon",
                name = "User Prev",
                personalLocationId = 1,
                personalLocationName = "Users Preview Location - 1",
                role = 2
            ),
            appVersionName = "1.1",
            error = ""
        )

    }

}
