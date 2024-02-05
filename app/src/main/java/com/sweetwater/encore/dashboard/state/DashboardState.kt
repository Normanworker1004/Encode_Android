package com.sweetwater.encore.dashboard.state

import com.sweetwater.encore.authorization.data.model.login.response.UserInfo
import com.sweetwater.encore.dashboard.data.WorkflowIcon
import com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarState

data class DashboardState(

    val isLoading: Boolean = false,
    val userData: UserInfo,
    val error: String = "",


    val topAppBarState: TopAppBarState = TopAppBarState(
        profileIcon = "",
        topBarMenuLabel = "",
    ),

    val workflowIcons: List<WorkflowIcon> = emptyList(),

    val isSideMenuToggled: Boolean = false,

    val versionName: String = "",
) {

    companion object {

        fun initialState() = DashboardState(
            userData = UserInfo(
                campusId = 2,
                employeeId = 5111,
                employeeNumber = 5111,
                id = 5111,
                icon = "Users Icon",
                name = "",
                personalLocationId = 1,
                personalLocationName = "Users Location",
                role = 2
            ),
            topAppBarState = TopAppBarState(
                topBarMenuLabel = "Choose Location",
                profileIcon = "",
                topBarBackgroundColor = -1,
            ),
            versionName = "1.1"
        )

    }

}
