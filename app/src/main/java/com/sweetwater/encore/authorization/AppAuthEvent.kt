package com.sweetwater.encore.authorization

import com.sweetwater.encore.authorization.data.enums.SignInMode
import com.sweetwater.encore.authorization.data.model.login.request.LoginRequest
import com.sweetwater.encore.authorization.data.model.logout.request.LogoutRequest

sealed class AppAuthEvent {
    class SignIn(
        val loginRequest: LoginRequest,
        val signInMode: SignInMode,
        val onSignInSuccess: () -> Unit
    ) : AppAuthEvent()

    class SignOut(
        val logoutRequest: LogoutRequest,
        val onSignOutSuccess: () -> Unit
    ) : AppAuthEvent()

    object FetchUserInfo : AppAuthEvent()
    object ClearErrors : AppAuthEvent()
}