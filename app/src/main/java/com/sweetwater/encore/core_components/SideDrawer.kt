package com.sweetwater.encore.core_components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sweetwater.encore.BuildConfig
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.data.model.login.response.UserInfo
import com.sweetwater.encore.authorization.state.AppAuthState
import com.sweetwater.encore.helpers.enums.CampusId
import com.sweetwater.encore.ui.theme.AppTheme

@Preview(name = "Side Nav Drawer")
@Composable
fun SideDrawerPreview() {

    val demoUser = UserInfo(
        campusId = 2,
        employeeId = 5111,
        employeeNumber = 5111,
        id = 5111,
        icon = "Users Icon",
        name = "Mike Anderson Johnson",
        personalLocationId = 1,
        personalLocationName = "Users Location",
        role = 2
    )

    SideDrawer(
        isOpen = true,
        onToggleSideMenu = { /*TODO*/ },
        onDismissSideMenu = {},
        appAuthState = AppAuthState(
            isLoggedIn = true,
            userData = demoUser,
            error = "",
            appVersionName = "1.1"
        ),
        onLogoutAction = {}
    )
}

@Composable
fun SideDrawer(
    isOpen: Boolean,
    appAuthState: AppAuthState,
    onToggleSideMenu: () -> Unit,
    onDismissSideMenu: () -> Unit,
    onLogoutAction: () -> Unit
) {

    val profileImageUrl: String?

    val userData = appAuthState.userData

    val empName = userData.name
    val empNumber = userData.employeeNumber
    var empCampusId = userData.campusId.toString()

    if (empCampusId == CampusId.FWA.campusId) {
        empCampusId = CampusId.FWA.name
    } else if (empCampusId == CampusId.PHX.campusId) {
        empCampusId = CampusId.PHX.name
    }

    profileImageUrl = userData.icon
    val appVersion = appAuthState.appVersionName

    AnimatedVisibility(
        visible = isOpen,
        enter = fadeIn() + slideInHorizontally(
            animationSpec = tween(
                durationMillis = 500,
                easing = FastOutSlowInEasing
            ),
            initialOffsetX = { fullWidth ->
                fullWidth
            }
        ),
        exit = slideOutHorizontally(
            animationSpec = tween(
                durationMillis = 500,
                easing = FastOutSlowInEasing
            ),
            targetOffsetX = { it },
        ) + fadeOut()
    ) {

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(1f)
        ) {

            Row {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(
                            .2f
                        )
                        .fillMaxHeight()
                        .clickable(onClick = onDismissSideMenu)
                        .background(Color.Transparent)

                ) {
                    // A temperory transparent view to mimick the behaviour of clicking outside the side menu.
                    Box(modifier = Modifier.background(Color.Transparent))
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight()
                        .background(Color.DarkGray)
                ) {

                    Column(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(8.dp)
                    ) {

                        BasicTextLabel(
                            text = empName,
                            fontSize = AppTheme.typo.textSize_12.value.toInt(),
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            BasicTextLabel(
                                text = empNumber.toString(),
                                fontSize = AppTheme.typo.textSize_12.value.toInt()
                            )

                            Icon(
                                modifier = Modifier.padding(4.dp),
                                painter = painterResource(id = R.drawable.baseline_location_on_24),
                                contentDescription = stringResource(id = R.string.core_components_location_icon_content_description),
                                tint = Color(0xFFEA2424)
                            )

                            BasicTextLabel(
                                text = empCampusId,
                                fontSize = AppTheme.typo.textSize_12.value.toInt()
                            )

                        }

                        BasicTextLabel(
                            text = "Encore $appVersion",
                            fontSize = AppTheme.typo.textSize_12.value.toInt()
                        )

                        Spacer(
                            modifier = Modifier
                                .height(2.dp)
                                .background(Color.White)
                                .fillMaxWidth()
                        )

                    }

                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(CircleShape)
                            .border(
                                2.dp,
                                if (BuildConfig.DEBUG) Color.Red else Color.Gray,
                                CircleShape
                            )
                            .size(AppTheme.dimens.profileIcon_4)
                            .background(Color.White)
                            .align(Alignment.TopEnd)
                    ) {

                        if (profileImageUrl.isNotEmpty()) {
                            AsyncProfileImage(
                                imageData = profileImageUrl
                            ) {
                                onToggleSideMenu()
                            }
                        }
                    }


                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .align(Alignment.BottomCenter),
                        contentAlignment = Alignment.Center
                    ) {

                        Column {

                            Spacer(
                                modifier = Modifier
                                    .height(2.dp)
                                    .fillMaxWidth()
                            )

                            Spacer(
                                modifier = Modifier
                                    .height(2.dp)
                                    .background(Color.White)
                                    .fillMaxWidth()
                            )

                            LogoutTextLabel(
                                modifier = Modifier.padding(
                                    start = 4.dp,
                                    bottom = 12.dp,
                                    top = 12.dp
                                ),
                                fontSize = AppTheme.typo.textSize_14.value.toInt(),
                                text = stringResource(id = R.string.logout_log_out_label),
                                onLabelTapped = {
                                    onLogoutAction()
                                }
                            )
                        }
                    }

                }

            }

        }
    }
}