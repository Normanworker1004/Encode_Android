package com.sweetwater.encore.authorization

sealed class LoginUIEvent {
    data class EnteredEmployeeID(val employeeId: String) : LoginUIEvent()
    object AddDash : LoginUIEvent()
    object RemoveEmployeeIds : LoginUIEvent()
    object ResetData : LoginUIEvent()
}
