package com.sweetwater.encore.authorization.data

import com.sweetwater.encore.authorization.data.enums.AppAuthStatusState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppLoginStatusStorage @Inject constructor() {

    private var _appLoginStatusState = MutableStateFlow(AppAuthStatusState.LOGIN_UNDETERMINED)
    val appLoginStatusState = _appLoginStatusState.asStateFlow()

    fun onLoggedIn() {
        _appLoginStatusState.value = AppAuthStatusState.LOGGED_IN
    }

    fun onLoggedOut() {
        _appLoginStatusState.value = AppAuthStatusState.NOT_LOGGED_IN
    }

    fun onResetState() {
        _appLoginStatusState.value = AppAuthStatusState.LOGIN_UNDETERMINED
    }

}