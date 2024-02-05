@file:OptIn(ExperimentalAnimationApi::class)

package com.sweetwater.encore.dashboard.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sweetwater.encore.authorization.state.AppAuthState
import com.sweetwater.encore.core_components.BasicTextLabel
import com.sweetwater.encore.core_components.CustomErrorSnackBarView
import com.sweetwater.encore.dashboard.DashboardUIEvent
import com.sweetwater.encore.dashboard.SoundEvent
import com.sweetwater.encore.dashboard.data.WorkflowIcon
import com.sweetwater.encore.dashboard.state.DashboardState
import com.sweetwater.encore.ui.theme.AppTheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun DashboardUIPreview() {
    DashboardUI(
        dashboardUiState = DashboardState.initialState(),
        dashboardUIEvent = {},
        appAuthState = AppAuthState.initialState(),
        onLoggedOut = {},
        onClickedProductRecounts = {},
        onClickedPickModScanner = {},
        onClickedTakeAPhoto = {},
        onClickedCycleCounts = {},
        onClickedBoxAudit = {}
    )
}

@ExperimentalAnimationApi
@Composable
fun DashboardUI(
    dashboardUiState: DashboardState,
    dashboardUIEvent: (DashboardUIEvent) -> Unit,
    appAuthState: AppAuthState,
    onClickedProductRecounts: () -> Unit,
    onClickedPickModScanner: () -> Unit,
    onClickedTakeAPhoto: () -> Unit,
    onClickedCycleCounts: () -> Unit,
    onClickedBoxAudit: () -> Unit,
    onLoggedOut: () -> Unit
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        visible = true
    }

    LaunchedEffect(appAuthState) {
        dashboardUIEvent(DashboardUIEvent.FetchUserInfo)
        dashboardUIEvent(DashboardUIEvent.NavigateToMainScreen)

        if (appAuthState.isLoggedOut) {
            onLoggedOut()
        }
    }

    BackHandler(
        enabled = dashboardUiState.isSideMenuToggled,
        onBack = {
            dashboardUIEvent(DashboardUIEvent.ToggleSideMenu)
        }
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = LinearOutSlowInEasing
                    )
                ) + slideInHorizontally(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing,
                    ),
                    initialOffsetX = { fullWidth ->
                        fullWidth
                    }
                ),
                exit = slideOutHorizontally(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    ),
                    targetOffsetX = { it },
                ) + fadeOut(
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = LinearOutSlowInEasing
                    )
                ),
                label = ""
            ) {
                LandingScreen(
                    dashboardUiState = dashboardUiState,
                    dashboardUIEvent = dashboardUIEvent,
                    appAuthState = appAuthState,
                    onClickedProductRecounts = onClickedProductRecounts,
                    onClickedPickModScanner = onClickedPickModScanner,
                    onClickedTakeAPhoto = onClickedTakeAPhoto,
                    onClickedCycleCounts = onClickedCycleCounts,
                    onClickedBoxAudit = onClickedBoxAudit
                )
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LandingScreen(
    dashboardUiState: DashboardState,
    dashboardUIEvent: (DashboardUIEvent) -> Unit,
    appAuthState: AppAuthState,
    onClickedProductRecounts: () -> Unit,
    onClickedPickModScanner: () -> Unit,
    onClickedTakeAPhoto: () -> Unit,
    onClickedCycleCounts: () -> Unit,
    onClickedBoxAudit: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            WorkflowIcons(
                dashboardState = dashboardUiState,
                dashboardUIEvent = dashboardUIEvent,
                onClickedProductRecounts = onClickedProductRecounts,
                onClickedPickModScanner = onClickedPickModScanner,
                onClickedTakeAPhoto = onClickedTakeAPhoto,
                onClickedCycleCounts = onClickedCycleCounts,
                onClickedBoxAudit = onClickedBoxAudit
            )

        }

        if (appAuthState.error.isNotEmpty()) {
            // Logout Error Handling is any
            AnimatedContent(
                modifier = Modifier.align(Alignment.BottomCenter),
                targetState = appAuthState.error,
                transitionSpec = {
                    slideInVertically(
                        animationSpec = tween(1500, easing = LinearOutSlowInEasing)
                    ) with slideOutHorizontally()
                }, label = ""
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.DarkGray),
                    contentAlignment = Alignment.Center
                ) {
                    BasicTextLabel(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                            .align(Alignment.Center),
                        fontSize = 18,
                        textColor = Color.Red,
                        fontWeight = FontWeight.Medium,
                        text = appAuthState.error
                    )
                }
            }
        }
    }

}

@Composable
fun WorkflowIcons(
    modifier: Modifier = Modifier,
    dashboardState: DashboardState,
    dashboardUIEvent: (DashboardUIEvent) -> Unit,
    onClickedProductRecounts: () -> Unit,
    onClickedPickModScanner: () -> Unit,
    onClickedTakeAPhoto: () -> Unit,
    onClickedCycleCounts: () -> Unit,
    onClickedBoxAudit: () -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(dashboardState.workflowIcons.size) { index ->
                WorkflowIconItem(
                    workflowIcon = dashboardState.workflowIcons[index],
                    onItemClick = {

                        val service = it.title

                        if (service.equals("Product Recounts", ignoreCase = true)) {
                            onClickedProductRecounts()
                        }
                        if (service.equals("Cycle Count", ignoreCase = true)) {
                            onClickedCycleCounts()
                        }
                        if (service.equals("Pickmod Scanner", ignoreCase = true)) {
                            onClickedPickModScanner()
                        }
                        if (service.equals("Take a Photo", ignoreCase = true)) {
                            onClickedTakeAPhoto()
                        }
                        if (service.equals("Box Audit", ignoreCase = true)) {
                            onClickedBoxAudit()
                        }
                    }
                )
            }
        }

        if (dashboardState.error.isNotEmpty()) {
            CustomErrorSnackBarView(errorMessage = dashboardState.error)

            LaunchedEffect(true) {
                dashboardUIEvent(DashboardUIEvent.PlaySoundEvent(SoundEvent.PlayNegativeFeedbackSound))
                delay(2500)
                dashboardUIEvent(DashboardUIEvent.ClearError)
            }
        }
    }

}

@Composable
fun WorkflowIconItem(
    modifier: Modifier = Modifier,
    workflowIcon: WorkflowIcon,
    onItemClick: (workflowIcon: WorkflowIcon) -> Unit = {}
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f)
            .padding(8.dp)
            .clickable { onItemClick(workflowIcon) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(modifier = Modifier.padding(8.dp), shape = CircleShape, elevation = 8.dp) {
            Image(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
                    .size(AppTheme.dimens.gridCircle_2),
                painter = painterResource(id = workflowIcon.iconId),
                contentDescription = workflowIcon.title
            )
        }

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = workflowIcon.title,
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = Color.White.copy(
                    alpha = 0.8f
                ),
                fontWeight = FontWeight.Normal,
                fontSize = AppTheme.typo.textSize_12,
                shadow = Shadow(
                    color = Color.Black, offset = Offset(2.0f, 2.0f), blurRadius = 3f
                )
            )
        )
    }
}