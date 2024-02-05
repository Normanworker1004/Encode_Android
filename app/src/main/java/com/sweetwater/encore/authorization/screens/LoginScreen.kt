package com.sweetwater.encore.authorization.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.data.enums.SignInMode
import com.sweetwater.encore.authorization.data.model.login.request.LoginRequest
import com.sweetwater.encore.authorization.AppAuthEvent
import com.sweetwater.encore.authorization.state.AppAuthState
import com.sweetwater.encore.authorization.LoginUIEvent
import com.sweetwater.encore.authorization.state.LoginUIState
import com.sweetwater.encore.core_components.BasicTextLabel
import com.sweetwater.encore.core_components.NumberPad
import com.sweetwater.encore.ui.theme.AppTheme
import kotlinx.coroutines.delay

@ExperimentalAnimationApi
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginUIEvent: (LoginUIEvent) -> Unit,
    loginUIState: LoginUIState,
    appAuthEvent: (AppAuthEvent) -> Unit,
    appAuthState: AppAuthState,
    onLogin: () -> Unit,
    onExitApp: () -> Unit
) {

    LaunchedEffect(appAuthState) {
        if (appAuthState.isLoggedIn) {
            onLogin()
        }
    }

    BackHandler(enabled = true) {
        onExitApp()
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {

        Image(
            modifier = modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.encore_bg),
            contentDescription = stringResource(id = R.string.login_background_encore_image_content_description),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = modifier
                .fillMaxSize()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(AppTheme.dimens.gridItem_2_75),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = stringResource(id = R.string.login_log_in_label),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = AppTheme.typo.textSize_11,
                        fontWeight = FontWeight.Bold
                    )
                )

            }

            Spacer(modifier = Modifier.height(AppTheme.dimens.gridItem_1))

            // Employee Label Text
            Text(
                text = stringResource(id = R.string.login_enter_employee_number_label),
                style = TextStyle(
                    color = Color.White,
                    fontSize = AppTheme.typo.textSize_16,
                    fontWeight = FontWeight.Bold
                )
            )

            // OTP style fields
            Spacer(modifier = Modifier.height(AppTheme.dimens.gridItem_1))

            LaunchedEffect(key1 = loginUIState.employeeId) {

                // fire a sign in event everytime the employeeNumber changes its value
                // but after a delay of 1 sec so that you don't make multiple requests on every number tap

                delay(1000)

                if (loginUIState.employeeId.isNotEmpty()) {
                    appAuthEvent(
                        AppAuthEvent.SignIn(
                            LoginRequest(
                                employeeNumber = if (loginUIState.employeeId.isNotEmpty()) loginUIState.employeeId.toInt() else 0,
                                apnsToken = "",
                                deviceIdentifier = "",
                                deviceIP = "",
                            ),
                            signInMode = SignInMode.AUTO_SIGN_IN,
                            onSignInSuccess = {
                                loginUIEvent(LoginUIEvent.ResetData)
                            }
                        )
                    )
                }

            }

            OtpViewWithNumPad(
                modifier = modifier,
                loginUIState = loginUIState,
                loginUIEvent = loginUIEvent,
                appAuthEvent = appAuthEvent
            )

            Spacer(modifier = Modifier.height(AppTheme.dimens.gridItem_1))

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.dimens.gridItem_2_75)
                .align(Alignment.BottomEnd),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(AppTheme.dimens.gridItem_2_75),
                text = appAuthState.appVersionName,
                fontSize = AppTheme.typo.textSize_10,
                color = Color.White
            )
        }

        if ((appAuthState.error.isNotEmpty()) && (appAuthState.error != "null")) {

            LaunchedEffect(key1 = true) {

                // Delay for 2.5 seconds and clear error after to mimic the behavior of Snackbar
                delay(2500)
                appAuthEvent(AppAuthEvent.ClearErrors)

            }

            AnimatedContent(
                modifier = Modifier.align(Alignment.BottomCenter),
                targetState = appAuthState.error.isNotEmpty(),
                transitionSpec = {
                    slideInVertically(
                        animationSpec = tween(1500, easing = LinearOutSlowInEasing)
                    ) with slideOutHorizontally()
                }, label = ""
            ) {
                Box(
                    modifier = modifier
                        .padding(AppTheme.dimens.gridItem_1)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            Color.Red.copy(
                                alpha = 0.8f
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    BasicTextLabel(
                        modifier = Modifier
                            .padding(AppTheme.dimens.gridItem_1)
                            .align(Alignment.Center),
                        fontSize = AppTheme.typo.textSize_10.value.toInt(),
                        textColor = Color.White.copy(
                            alpha = 0.8f
                        ),
                        fontWeight = FontWeight.Normal,
                        text = appAuthState.error
                    )
                }
            }

        }

    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun OtpViewWithNumPad(
    modifier: Modifier = Modifier,
    loginUIState: LoginUIState,
    loginUIEvent: (LoginUIEvent) -> Unit,
    appAuthEvent: (AppAuthEvent) -> Unit
) {

    val dashedLineCount = loginUIState.maxDashCount

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(AppTheme.dimens.gridItem_2_75),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Employee ID Text Field
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            items(dashedLineCount) {
                Text(
                    modifier = Modifier
                        .padding(
                            end = AppTheme.dimens.gridItem_1,
                            top = AppTheme.dimens.gridItem_0_75,
                            bottom = AppTheme.dimens.gridItem_0_75,
                            start = AppTheme.dimens.gridItem_1
                        ),
                    text = if (dashedLineCount > it) "-" else "",
                    fontSize = AppTheme.typo.textSize_extra_large,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.White
                )
            }

            items(
                loginUIState.employeeId.toCharArray().size
            ) {

                Text(
                    modifier = Modifier.padding(
                        start = 8.dp,
                        end = 8.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    ),
                    text = loginUIState.employeeId[it].toString(),
                    fontSize = AppTheme.typo.textSize_18,
                    color = Color.White
                )

            }

        }

        Spacer(modifier = Modifier.height(AppTheme.dimens.gridItem_1))

        NumberPad(
            loginUIState = loginUIState,
            loginUIEvent = loginUIEvent,
            appAuthEvent = appAuthEvent
        )

    }

}