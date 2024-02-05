package com.sweetwater.encore.authorization.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sweetwater.encore.authorization.LoginUIEvent
import com.sweetwater.encore.authorization.state.LoginUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _loginUIState = mutableStateOf(
        LoginUIState()
    )

    val loginState: State<LoginUIState> = _loginUIState

    fun onEvent(event: LoginUIEvent) {

        when (event) {

            is LoginUIEvent.EnteredEmployeeID -> {

                val eventValue = event.employeeId
                val employeeStateValue = _loginUIState.value.employeeId

                val currentEmployeeId: String

                if (employeeStateValue.length < 5) {

                    currentEmployeeId = employeeStateValue + eventValue
                    savedStateHandle.set("employeeId", currentEmployeeId)

                    _loginUIState.value = loginState.value.copy(
                        employeeId = currentEmployeeId
                    )

                }

                val maxDashCount =
                    _loginUIState.value.maxDashCountT - _loginUIState.value.employeeId.length
                savedStateHandle.set("maxDashCount", maxDashCount)

                _loginUIState.value = loginState.value.copy(
                    maxDashCount = maxDashCount
                )

            }

            is LoginUIEvent.AddDash -> {
                _loginUIState.value = loginState.value.copy(
                    maxDashCount = loginState.value.maxDashCountT - loginState.value.employeeId.length
                )
            }

            is LoginUIEvent.RemoveEmployeeIds -> {

                if (loginState.value.employeeId.isNotEmpty()) {
                    _loginUIState.value = loginState.value.copy(
                        employeeId = ""
                    )
                }
            }

            is LoginUIEvent.ResetData -> {
                _loginUIState.value = loginState.value.copy(
                    employeeId = "",
                    maxDashCount = 5,
                    isLoading = false,
                    error = ""
                )
            }

        }
    }

}