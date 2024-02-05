package com.sweetwater.encore.recounts.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sweetwater.encore.R
import com.sweetwater.encore.core_components.BasicTextLabel
import com.sweetwater.encore.core_components.CustomErrorSnackBarView
import com.sweetwater.encore.core_components.FullScreenErrorScreen
import com.sweetwater.encore.core_components.KeyboardDialog
import com.sweetwater.encore.core_components.KeyboardIcon
import com.sweetwater.encore.core_components.PriorityIndicator
import com.sweetwater.encore.core_components.ProductTile
import com.sweetwater.encore.recounts.data.dto.LocationDto
import com.sweetwater.encore.recounts.data.dto.RecountLocationDto
import com.sweetwater.encore.recounts.state.RecountsScanLocationState
import com.sweetwater.encore.recounts.viewmodels.RecountsScanLocationViewModel
import com.sweetwater.encore.ui.theme.AppTheme
import kotlinx.coroutines.launch

@Preview
@Composable
fun RecountsScanLocationScreenPreview() {
    RecountsScanLocationContent(modifier = Modifier,
        recountsScanLocationState = RecountsScanLocationState(
            error = "", recountLocations = listOf(
                RecountLocationDto(
                    recountLocationId = 0,
                    priority = 2,
                    location = LocationDto(
                        id = 11,
                        name = "M1-01-01-A-01",
                    ),
                ),
                RecountLocationDto(
                    recountLocationId = 0,
                    priority = 2,
                    location = LocationDto(
                        id = 11,
                        name = "M1-01-01-A-02",
                    ),
                ),
                RecountLocationDto(
                    recountLocationId = 0,
                    priority = 1,
                    location = LocationDto(
                        id = 11,
                        name = "M2-05-15-C-01",
                    ),
                ),
            )
        ),
        onReturnToScanProductScreen = {},
        onLocationSelected = {},
        onKeyboardToggled = {},
        onConfirmKeyboard = {},
        onClearError = {},
        onConfirmAddingLocation = {},
        onDismissAddingLocation = {})
}

@Composable
fun RecountsScanLocationScreen(
    modifier: Modifier = Modifier,
    viewModel: RecountsScanLocationViewModel,
    onReturnToScanProductScreen: () -> Unit,
    onLocationSelected: (String) -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.onNavigatedTo()
    }

    val coroutineScope = rememberCoroutineScope()

    RecountsScanLocationContent(
        modifier = modifier,
        recountsScanLocationState = viewModel.recountsScanLocationState.value,
        onReturnToScanProductScreen = onReturnToScanProductScreen,
        onLocationSelected = { locationName ->
            viewModel.clearMatchedLocation()
            onLocationSelected(locationName)
        },
        onKeyboardToggled = { isToggled -> viewModel.onKeyboardToggled(isToggled) },
        onConfirmKeyboard = { text -> viewModel.onConfirmKeyboard(text) },
        onClearError = { viewModel.clearError() },
        onDismissAddingLocation = { viewModel.clearAdditionalLocation() },
        onConfirmAddingLocation = {
            coroutineScope.launch {
                viewModel.validateLocationAndAddToRecount()
            }
        },
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RecountsScanLocationContent(
    modifier: Modifier = Modifier,
    recountsScanLocationState: RecountsScanLocationState,
    onReturnToScanProductScreen: () -> Unit,
    onLocationSelected: (String) -> Unit,
    onConfirmKeyboard: (String) -> Unit,
    onKeyboardToggled: (Boolean) -> Unit,
    onClearError: () -> Unit,
    onDismissAddingLocation: () -> Unit,
    onConfirmAddingLocation: () -> Unit
) {
    BackHandler {
        onReturnToScanProductScreen()
    }

    if (recountsScanLocationState.matchedLocation != null) {
        onLocationSelected(recountsScanLocationState.matchedLocation)
    }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (recountsScanLocationState.error.isNotEmpty()) {
                CustomErrorSnackBarView(
                    errorMessage = recountsScanLocationState.error,
                    hasAction = true,
                    actionText = stringResource(id = R.string.recounts_ok_action_text)
                ) {
                    onClearError()
                }
            }
            if (recountsScanLocationState.isLoading) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = modifier
                            .padding(top = 18.dp)
                            .align(Alignment.Center),
                        color = Color.White,
                        strokeWidth = 4.dp,
                    )
                }
            }
            if (recountsScanLocationState.recountRequest?.product != null) {
                ProductTile(
                    name = recountsScanLocationState.recountRequest.product.name,
                    imageUrl = recountsScanLocationState.recountRequest.product.imageURL,
                    productManufacturer = recountsScanLocationState.recountRequest.product.manufacturer,
                    shortDescription = recountsScanLocationState.recountRequest.product.description,
                    serialNumber = recountsScanLocationState.recountRequest.product.serialNumber,
                    hasBackground = false,
                    hasBorderStroke = false,
                    onProductItemClicked = { _, _, _ -> }
                )
            }
            LazyColumn {
                val sortedRecountLocations =
                    recountsScanLocationState.recountLocations.sortedBy { it.location.name }
                        .sortedByDescending { it.priority }
                if (sortedRecountLocations.isNotEmpty()) {
                    items(sortedRecountLocations) { recountLocation ->
                        LocationItem(modifier, recountLocation)
                    }
                }
            }
        }

        if (recountsScanLocationState.addingLocation) {
            AlertDialog(
                title = {
                    BasicTextLabel(
                        text = recountsScanLocationState.additionalLocationName,
                        fontWeight = FontWeight.Bold,
                        fontSize = AppTheme.typo.textSize_18.value.toInt(),
                        textAlign = TextAlign.Start,
                        textColor = Color.Black,
                        shadow = Shadow.None,
                    )
                },
                text = {
                    BasicTextLabel(
                        text = stringResource(id = R.string.recounts_want_to_count_additional_product_at_location_label),
                        textAlign = TextAlign.Start,
                        fontSize = AppTheme.typo.textSize_12.value.toInt(),
                        textColor = Color(0xFF757575),
                        shadow = Shadow.None,
                    )

                },
                onDismissRequest = {
                    onDismissAddingLocation()
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            onConfirmAddingLocation()
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.recounts_confirm_action_text),
                            fontSize = AppTheme.typo.textSize_10,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF6750A4),
                        )
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            onDismissAddingLocation()
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.recounts_cancel_action_text),
                            fontSize = AppTheme.typo.textSize_10,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF6750A4),
                        )
                    }
                }
            )
        }

        KeyboardDialog(
            show = recountsScanLocationState.isKeyboardToggled,
            dialogTitle = stringResource(R.string.recounts_enter_barcode_dialog_title),
            inputHintText = stringResource(R.string.recounts_barcode_input_hint_text),
            onDismiss = {
                onKeyboardToggled(false)
            },
            onConfirm = {
                onConfirmKeyboard(it)
            },
        )

        KeyboardIcon(
            modifier = Modifier.align(Alignment.BottomEnd),
            onKeyboardToggled = { onKeyboardToggled(true) })

        AnimatedVisibility(
            recountsScanLocationState.displayFullscreenError, enter = fadeIn(), exit = fadeOut()
        ) {
            FullScreenErrorScreen(
                errorMessage = ""
            )
        }
    }
}

@Composable
fun LocationItem(
    modifier: Modifier, recountLocationDto: RecountLocationDto
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(6.dp))
            .border(
                border = BorderStroke(width = 1.dp, color = Color.Gray),
                shape = RoundedCornerShape(6.dp)
            )
            .background(
                color = Color.Black.copy(alpha = .5f), shape = RoundedCornerShape(6.dp)
            )
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PriorityIndicator(modifier, size = 32, recountLocationDto.priority)
            Spacer(modifier = Modifier.size(32.dp))
            Text(
                recountLocationDto.location.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                )
            )
        }
    }
}