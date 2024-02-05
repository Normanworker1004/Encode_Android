@file:OptIn(ExperimentalAnimationApi::class)

package com.sweetwater.encore.cycle_counts.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sweetwater.encore.R
import com.sweetwater.encore.cycle_counts.state.CycleCountScanLocationState
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanLocationViewModel
import com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse
import com.sweetwater.encore.external_api.inventory.dto.response.CycleCountLocation
import com.sweetwater.encore.core_components.KeyboardDialog
import com.sweetwater.encore.core_components.CustomErrorSnackBarView
import com.sweetwater.encore.core_components.FullScreenErrorScreen
import com.sweetwater.encore.core_components.KeyboardIcon
import kotlinx.coroutines.delay

@Preview
@Composable
fun CycleCountScanLocationContentPreview() {
    CycleCountScanLocationContent(
        modifier = Modifier,
        state = CycleCountScanLocationState(
            assignedLocations = remember { mutableStateListOf(
                AssignedLocationResponse(
                    id = 1,
                    cycleCountQuarterId = 1,
                    location = CycleCountLocation(
                        id = 1,
                        name = "M1-01-01-A-01"
                    ),
                    currentEmployeeId = 10136
                )
            ) }
        ),
        onBackEvent = {},
        onKeyboardToggle = {},
        onKeyboardConfirm = {},
        onErrorClear = {},
        onLocationMatch = { _, _ ->}
    )
}

@Composable
fun CycleCountScanLocationScreen(
    modifier: Modifier = Modifier,
    viewModel: CycleCountScanLocationViewModel,
    onBackEvent: () -> Unit,
    onNavigateToCycleCountScanUpcs: (String, Int) -> Unit,
) {
    LaunchedEffect(key1 = true) {
        viewModel.onNavigatedTo()
    }

    CycleCountScanLocationContent(
        modifier = modifier,
        state = viewModel.cycleCountScanLocationState.value,
        onBackEvent = {
            onBackEvent()
        },
        onErrorClear = {
            viewModel.clearError()
        },
        onKeyboardConfirm = {
            viewModel.onConfirmKeyboard(it)
        },
        onKeyboardToggle = {
            viewModel.onKeyboardToggled(it)
        },
        onLocationMatch = { locationName, countRequestId ->
            viewModel.clearLocationMatchFlag()
            onNavigateToCycleCountScanUpcs(locationName, countRequestId)
        }
    )
}

@Composable
fun CycleCountScanLocationContent(
    modifier: Modifier,
    state: CycleCountScanLocationState,
    onBackEvent: () -> Unit,
    onErrorClear: () -> Unit,
    onKeyboardConfirm: (input: String) -> Unit,
    onKeyboardToggle: (isToggled: Boolean) -> Unit,
    onLocationMatch: (String, Int) -> Unit
) {
    BackHandler {
        onBackEvent()
    }

    Box(modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(alignment = Center),
                color = Color.White,
                strokeWidth = 4.dp
            )
        }

        if (state.error.isNotEmpty()) {
            CustomErrorSnackBarView(
                errorMessage = state.error,
                hasAction = false
            )

            LaunchedEffect(key1 = true) {
                delay(2500)
                onErrorClear()
            }
        }

        KeyboardDialog(
            show = state.keyboardToggled,
            dialogTitle = stringResource(R.string.cycle_count_enter_barcode_dialog_title),
            inputHintText = stringResource(R.string.cycle_count_barcode_input_hint_text),
            onDismiss = {
                onKeyboardToggle(false)
            },
            onConfirm = {
                onKeyboardConfirm(it)
            }
        )

        AnimatedVisibility(
            state.locationMatched == false,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            FullScreenErrorScreen(
                errorMessage = ""
            )
        }

        if (state.locationMatched == true) {
            onLocationMatch(
                state.assignedLocations[0]?.location?.name ?: "",
                state.assignedLocations[0]?.id ?: 0,
            )
        }

        Column(
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                state.assignedLocations.getOrNull(0)?.location?.name ?: "",
                maxLines = 1,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = Color.White,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(2.0f, 4.0f),
                        blurRadius = 3f
                    )
                )
            )
        }

        KeyboardIcon(
            modifier = Modifier.align(Alignment.BottomEnd),
            onKeyboardToggled = onKeyboardToggle
        )
    }
}