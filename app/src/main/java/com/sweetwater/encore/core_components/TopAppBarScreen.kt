package com.sweetwater.encore.core_components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sweetwater.encore.BuildConfig
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.data.model.login.response.UserInfo
import com.sweetwater.encore.authorization.state.AppAuthState
import com.sweetwater.encore.navigation.Dashboard
import com.sweetwater.encore.navigation.NavigationRoute
import com.sweetwater.encore.ui.theme.AppTheme

/* Basic top bar preview for limited testing*/
@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBarScreen(
        modifier = Modifier.fillMaxHeight(1f),
        currentScreen = Dashboard,
        appAuthState = AppAuthState(
            isLoggedIn = true,
            userData = UserInfo(
                campusId = 2,
                employeeId = 5111,
                employeeNumber = 5111,
                id = 5111,
                icon = "Users Icon",
                name = "",
                personalLocationId = 1,
                personalLocationName = "Users Location",
                role = 2
            ),
            error = "",
            appVersionName = "1.1"
        ),
        onToggleSideMenu = {},
        onBackButtonPressed = {},
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TopAppBarScreen(
    modifier: Modifier = Modifier,
    currentScreen: NavigationRoute,
    appAuthState: AppAuthState,
    onToggleSideMenu: () -> Unit,
    onBackButtonPressed: () -> Unit,
) {
    val userData = appAuthState.userData
    val profileImageUrl = userData.icon

    val titleResourceId = currentScreen.titleResourceId
    val title = if (titleResourceId != null) stringResource(titleResourceId) else ""

    if (!currentScreen.showNavBar) return

    Row(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
            .background(Color.Black),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            verticalAlignment = CenterVertically
        ) {
            if (currentScreen.showBackButton) {
                IconButton(onClick = { onBackButtonPressed() }) {
                    Icon(
                        modifier = Modifier
                            .align(CenterVertically),
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.core_components_menu_content_description),
                        tint = Color.White.copy(alpha = 1f),
                    )
                }
            }

            BasicTextLabel(
                modifier = Modifier
                    .padding(horizontal = if (currentScreen.showBackButton) 0.dp else 16.dp)
                    .align(CenterVertically),
                text = title)
        }

        Card(
            modifier = Modifier
                .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                .clip(CircleShape)
                .clip(CircleShape)
                .border(
                    2.dp,
                    if (BuildConfig.DEBUG) Color.Red else Color.Gray,
                    CircleShape
                )
                .size(AppTheme.dimens.profileIcon_1)
                .background(Color.White)
                .align(CenterVertically)
        ) {

            AsyncProfileImage(
                modifier = Modifier.padding(2.dp),
                imageData = profileImageUrl
            ) {
                onToggleSideMenu()
            }
        }
    }
}