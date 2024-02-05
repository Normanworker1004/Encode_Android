package com.sweetwater.encore.authorization.state

data class LoginUIState(
    val isLoading: Boolean = false,
    var employeeId: String = "",
    val error: String = "",
    val numPadCount: Int = 12,
    val maxDashCount: Int = 5,
    val maxDashCountT: Int = 5
)
