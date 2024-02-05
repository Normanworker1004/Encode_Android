package com.sweetwater.encore.core_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.data.enums.SignInMode
import com.sweetwater.encore.authorization.data.model.login.request.LoginRequest
import com.sweetwater.encore.authorization.AppAuthEvent
import com.sweetwater.encore.authorization.LoginUIEvent
import com.sweetwater.encore.authorization.state.LoginUIState
import com.sweetwater.encore.ui.theme.AppTheme


@Preview
@Composable
fun NumberPadPreview() {
    NumberPad(
        loginUIState = LoginUIState(),
        loginUIEvent = {},
        appAuthEvent = {}
    )
}

// Number pad representing numbers from 0 to 9, a backspace button and a submit button

@Composable
fun NumberPad(
    loginUIState: LoginUIState,
    loginUIEvent: (LoginUIEvent) -> Unit,
    appAuthEvent: (AppAuthEvent) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        LazyVerticalGrid(
            modifier = Modifier
                .padding(AppTheme.dimens.profileIcon_3)
                .fillMaxSize(),
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(4.dp)
        ) {

            items(
                count = loginUIState.numPadCount
            ) { gridIndex ->

                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                        .clip(
                            shape = CircleShape,
                        )
                        .background(
                            color = Color.LightGray.copy(
                                alpha = .6f
                            )
                        )
                        .clickable(
                            onClick = {
                                numPadActionHandler(
                                    gridIndex = gridIndex,
                                    loginUIEvent = loginUIEvent,
                                    loginUIState = loginUIState,
                                    appAuthEvent = appAuthEvent
                                )
                            }
                        )
                        .aspectRatio(1f),
                    contentAlignment = Alignment.Center
                ) {

                    NumButton(
                        numberGridPositionIndex = gridIndex
                    )

                }
            }
        }
    }

}

fun numPadActionHandler(
    gridIndex: Int,
    loginUIEvent: (LoginUIEvent) -> Unit,
    loginUIState: LoginUIState,
    appAuthEvent: (AppAuthEvent) -> Unit
) {

    var buttonText = ""

    if (gridIndex == 10) {
        buttonText = "0"
    } else {
        if (gridIndex != 9 && gridIndex != 11) {
            buttonText = (gridIndex + 1).toString()
        }
    }

    when (gridIndex) {
        9 -> {
            loginUIEvent(LoginUIEvent.RemoveEmployeeIds)
            loginUIEvent(LoginUIEvent.AddDash)
        }

        10 -> {
            loginUIEvent(LoginUIEvent.EnteredEmployeeID(employeeId = buttonText))
        }

        11 -> {

            appAuthEvent(
                AppAuthEvent.SignIn(
                    LoginRequest(
                        employeeNumber = if (loginUIState.employeeId.isNotEmpty()) loginUIState.employeeId.toInt() else 0,
                        apnsToken = "",
                        deviceIdentifier = "",
                        deviceIP = "",
                    ),
                    signInMode = SignInMode.MANUAL_SIGN_IN,
                    onSignInSuccess = {
                        loginUIEvent(LoginUIEvent.ResetData)
                    }
                )
            )
        }

        else -> {
            loginUIEvent(LoginUIEvent.EnteredEmployeeID(employeeId = buttonText))
            appAuthEvent(AppAuthEvent.ClearErrors)
        }

    }
}

@Composable
fun NumButton(
    numberGridPositionIndex: Int
) {

    val buttonText: String

    when (numberGridPositionIndex) {

        9 -> {
            buttonText = stringResource(id = R.string.login_x_button)
            NumPadText(
                text = buttonText,
                textColor = Color(0xFFFF6557),
                textSize = AppTheme.typo.textSize_18.value.toInt()
            )
        }

        10 -> {
            buttonText = stringResource(id = R.string.login_zero_button)
            NumPadText(
                text = buttonText,
                textSize = AppTheme.typo.textSize_18.value.toInt()
            )
        }

        11 -> {
            buttonText = stringResource(R.string.core_components_check_mark_button_value)
            NumPadText(
                text = buttonText,
                textColor = Color.Green.copy(
                    alpha = 0.7f
                ),
                textSize = AppTheme.typo.textSize_18.value.toInt()
            )
        }

        else -> {

            buttonText = (numberGridPositionIndex + 1).toString()
            NumPadText(
                text = buttonText,
                textSize = AppTheme.typo.textSize_18.value.toInt()
            )

        }

    }
}
