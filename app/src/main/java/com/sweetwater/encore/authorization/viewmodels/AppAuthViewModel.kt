package com.sweetwater.encore.authorization.viewmodels

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.BuildConfig
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.AppAuthEvent
import com.sweetwater.encore.authorization.data.AppLoginStatusStorage
import com.sweetwater.encore.authorization.data.enums.SignInMode
import com.sweetwater.encore.authorization.data.model.login.request.LoginRequest
import com.sweetwater.encore.authorization.data.model.login.response.UserInfo
import com.sweetwater.encore.authorization.data.model.logout.request.LogoutRequest
import com.sweetwater.encore.authorization.state.AppAuthState
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase
import com.sweetwater.encore.authorization.usecases.LoginEmployeeUseCase
import com.sweetwater.encore.authorization.usecases.LogoutEmployeeUseCase
import com.sweetwater.encore.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppAuthViewModel @Inject constructor(
    private val loginEmployeeUseCase: LoginEmployeeUseCase,
    private val getEmployeeLoginDetailsUseCase: GetEmployeeLoginDetailsUseCase,
    private val logoutEmployeeUseCase: LogoutEmployeeUseCase,
    private val appAuthStatusStorage: AppLoginStatusStorage,
    private val ioDispatcher: CoroutineDispatcher,
    private val context: Context,
) : ViewModel() {

    private val _appAuthState = mutableStateOf(
        AppAuthState(
            appVersionName = "",
            error = "",
            userData = UserInfo.initialState()
        )
    )

    val appAuthState: State<AppAuthState> = _appAuthState
    private val _versionName = "v${BuildConfig.VERSION_NAME}"

    init {
        _appAuthState.value = appAuthState.value.copy(
            appVersionName = _versionName
        )
        fetchAppInfo()
    }

    fun onEvent(event: AppAuthEvent) {
        when (event) {
            is AppAuthEvent.FetchUserInfo -> {
                fetchAppInfo()
            }

            is AppAuthEvent.SignIn -> {
                val loginRequest = event.loginRequest

                signIn(
                    loginRequest = loginRequest,
                    signInMode = event.signInMode,
                    onSignInSuccess = {
                        event.onSignInSuccess()
                    })

            }

            is AppAuthEvent.SignOut -> {
                signOut(
                    logoutRequest = event.logoutRequest,
                    onSignOutSuccess = {
                        event.onSignOutSuccess()
                    })
            }

            is AppAuthEvent.ClearErrors -> {
                _appAuthState.value = appAuthState.value.copy(
                    error = ""
                )
            }

        }

    }

    private fun signIn(
        loginRequest: LoginRequest,
        signInMode: SignInMode,
        onSignInSuccess: () -> Unit
    ) {
        try {
            val employeeNumber = loginRequest.employeeNumber.toString()
            val employeeNumLength = employeeNumber.length

            when (signInMode) {
                SignInMode.AUTO_SIGN_IN -> {
                    if (employeeNumLength == 4 && !employeeNumber.startsWith("1")) {
                        _appAuthState.value = appAuthState.value.copy(
                            isAutoLoginValidated = true
                        )
                    } else if (employeeNumLength in 5..5) {
                        _appAuthState.value = appAuthState.value.copy(
                            isAutoLoginValidated = true
                        )
                    } else {
                        _appAuthState.value = appAuthState.value.copy(
                            isAutoLoginValidated = false
                        )
                    }

                    val isAutoLoginValidated = appAuthState.value.isAutoLoginValidated
                    if (isAutoLoginValidated) {
                        signInEmployee(
                            loginRequest = loginRequest,
                            onSignInSuccess = {
                                onSignInSuccess()
                            })
                    } else {
                        // Handle any other case if needed.
                        _appAuthState.value = appAuthState.value.copy(
                            error = ""
                        )
                    }

                }

                SignInMode.MANUAL_SIGN_IN -> {
                    _appAuthState.value = appAuthState.value.copy(
                        isAutoLoginValidated = false,
                        isManualLoginValidated = true,
                    )

                    signInEmployee(loginRequest = loginRequest, onSignInSuccess = {
                        onSignInSuccess()
                    })
                }
            }
        } catch (e: Exception) {
            Log.e("AppViewModel", "signIn: error: ", e)
        }
    }

    private fun signInEmployee(loginRequest: LoginRequest, onSignInSuccess: () -> Unit) {
        viewModelScope.launch {
            loginEmployeeUseCase(loginRequest).flowOn(ioDispatcher).collectLatest {
                when (it) {
                    is Resource.Error -> {
                        _appAuthState.value = appAuthState.value.copy(
                            error = it.message!!.message
                        )
                    }

                    is Resource.Loading -> {
                        _appAuthState.value = appAuthState.value.copy(
                            isLoading = it.isLoading
                        )
                    }

                    is Resource.Success -> {

                        _appAuthState.value = appAuthState.value.copy(
                            isLoggedIn = true,
                            isLoggedOut = false,
                            userData = it.data!!,
                            error = ""
                        )
                        onSignInSuccess()
                        appAuthStatusStorage.onLoggedIn()

                    }
                }
            }
        }
    }

    private fun fetchAppInfo() {
        try {
            viewModelScope.launch {
                getEmployeeLoginDetailsUseCase().flowOn(ioDispatcher).collectLatest {
                    when (it) {
                        is Resource.Error -> {
                            _appAuthState.value = appAuthState.value.copy(
                                isLoggedIn = false,
                                isLoggedOut = true,
                                userData = UserInfo.initialState(),
                                error = ""
                            )

                            appAuthStatusStorage.onLoggedOut()
                        }

                        is Resource.Loading -> {
                            _appAuthState.value = appAuthState.value.copy(
                                isLoading = it.isLoading
                            )
                        }

                        is Resource.Success -> {
                            _appAuthState.value = appAuthState.value.copy(
                                isLoggedIn = true,
                                isLoggedOut = false,
                                userData = it.data!!,
                                error = ""
                            )

                            appAuthStatusStorage.onLoggedIn()
                        }
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("AppViewModel", "Fetch User : Error: ", e)
        }
    }

    private fun signOut(logoutRequest: LogoutRequest, onSignOutSuccess: () -> Unit) {
        try {
            viewModelScope.launch {
                logoutEmployeeUseCase(logoutRequest).flowOn(ioDispatcher).collectLatest {
                    when (it) {
                        is Resource.Error -> {
                            _appAuthState.value = appAuthState.value.copy(
                                error = context.getString(R.string.logout_unable_sign_out_employee_error)
                            )
                        }

                        is Resource.Loading -> {
                            _appAuthState.value = appAuthState.value.copy(
                                isLoading = it.isLoading
                            )
                        }

                        is Resource.Success -> {

                            _appAuthState.value = appAuthState.value.copy(
                                isLoggedIn = false,
                                isLoggedOut = true,
                                userData = UserInfo.initialState()
                            )

                            onSignOutSuccess()
                            appAuthStatusStorage.onLoggedOut()
                        }
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("AppViewModel", "signOut: error: ", e)
        }
    }
}