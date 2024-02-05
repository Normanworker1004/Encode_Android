package com.sweetwater.encore.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.sweetwater.encore.authorization.data.enums.AppAuthStatusState
import com.sweetwater.encore.authorization.data.AppLoginStatusStorage


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeMediator(
    authLoginStatusStorage: AppLoginStatusStorage,
    onLoggedIn: () -> Unit,
    onLoggedOut: () -> Unit,
    onLoginUndetermined: () -> Unit
) {
    val authState by authLoginStatusStorage.appLoginStatusState.collectAsState()

    LaunchedEffect(key1 = authState)
    {
        when (authState) {
            AppAuthStatusState.LOGGED_IN -> {
                onLoggedIn()
            }

            AppAuthStatusState.NOT_LOGGED_IN -> {
                onLoggedOut()
            }

            AppAuthStatusState.LOGIN_UNDETERMINED -> {
                onLoginUndetermined()
            }
        }
    }
}