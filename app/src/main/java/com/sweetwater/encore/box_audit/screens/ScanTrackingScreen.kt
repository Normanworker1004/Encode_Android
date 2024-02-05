package com.sweetwater.encore.box_audit.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sweetwater.encore.R
import com.sweetwater.encore.box_audit.BoxAuditUIEvent
import com.sweetwater.encore.box_audit.state.BoxAuditScanTrackingState
import com.sweetwater.encore.box_audit.viewmodels.BoxAuditScanTrackingViewModel
import com.sweetwater.encore.core_components.CustomErrorSnackBarView
import com.sweetwater.encore.ui.theme.AppTheme
import kotlinx.coroutines.delay

@Composable
fun BoxAuditScanTrackingScreen(
    modifier: Modifier = Modifier,
    onBackEvent: () -> Unit,
    viewModel: BoxAuditScanTrackingViewModel
) {

    BackHandler {
        onBackEvent()
    }

    LaunchedEffect(key1 = true) {
        viewModel.onNavigatedTo()
    }

    BoxAuditScanTrackingContent(modifier = modifier, state = viewModel.boxAuditScanTrackingState.value) {
        viewModel.onEvent(it)
    }
}

@Composable
fun BoxAuditScanTrackingContent(
    modifier: Modifier = Modifier,
    state: BoxAuditScanTrackingState,
    boxAuditUIEvent: (BoxAuditUIEvent) -> Unit,
) {

    Box(modifier = modifier.fillMaxSize()) {
        if (state.errorMessage.isNotEmpty()) {
            CustomErrorSnackBarView(errorMessage = state.errorMessage)

            LaunchedEffect(true) {
                delay(4500)
                boxAuditUIEvent(BoxAuditUIEvent.ClearError)
            }
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = modifier
                    .padding(top = 18.dp)
                    .align(Alignment.Center),
                color = Color.White,
                strokeWidth = 4.dp,
            )
        }

        Column(
            modifier = modifier.fillMaxSize().padding(bottom = 100.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = modifier.size(350.dp),
                painter = painterResource(id = R.drawable.scan_tracking_image),
                contentDescription = stringResource(id = R.string.box_audit_scan_tracking_image_description),
            )

            Spacer(modifier = Modifier.height(AppTheme.dimens.gridItem_1))

            val configuration = LocalConfiguration.current
            val tabWidth = (configuration.screenWidthDp - 32.dp.value)/3
            CustomTab(
                items = state.packAreaOptions,
                selectedItemIndex = state.packAreaOptions.indexOf(state.selectedPackArea),
                onClick = { boxAuditUIEvent(BoxAuditUIEvent.OnPackAreaSelected(state.packAreaOptions[it])) },
                tabWidth = tabWidth.dp
            )
        }
    }
}

@Composable
private fun MyTabIndicator(
    indicatorWidth: Dp,
    indicatorOffset: Dp,
    indicatorColor: Color,
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(
                width = indicatorWidth,
            )
            .offset(
                x = indicatorOffset,
            )
            .background(
                color = indicatorColor,
            ),
    )
}

@Composable
private fun MyTabItem(
    isSelected: Boolean,
    onClick: () -> Unit,
    tabWidth: Dp,
    text: String,
) {
    val tabTextColor: Color by animateColorAsState(
        targetValue = if (isSelected) {
            White
        } else {
            LightGray
        },
        animationSpec = tween(easing = LinearEasing), label = "",
    )
    Text(
        modifier = Modifier
            .fillMaxHeight()
            .clickable {
                onClick()
            }.border(1.dp, Color.DarkGray, RectangleShape)
            .width(tabWidth)
            .padding(
                vertical = 8.dp,
                horizontal = 12.dp,
            ),
        text = text,
        color = tabTextColor,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun CustomTab(
    selectedItemIndex: Int,
    items: List<String>,
    modifier: Modifier = Modifier,
    tabWidth: Dp = 100.dp,
    onClick: (index: Int) -> Unit,
) {

    val indicatorOffset: Dp by animateDpAsState(
        targetValue = tabWidth * selectedItemIndex,
        animationSpec = tween(easing = LinearEasing), label = "",
    )

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .border(1.dp, Color.DarkGray, RoundedCornerShape(6.dp))
            .background(Color.Black)
            .height(intrinsicSize = IntrinsicSize.Min),
    ) {
        MyTabIndicator(
            indicatorWidth = tabWidth,
            indicatorOffset = indicatorOffset,
            indicatorColor = Color.DarkGray,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clip(CircleShape),
        ) {
            items.mapIndexed { index, text ->
                val isSelected = index == selectedItemIndex
                MyTabItem(
                    isSelected = isSelected,
                    onClick = {
                        onClick(index)
                    },
                    tabWidth = tabWidth,
                    text = text,
                )

            }
        }
    }
}
