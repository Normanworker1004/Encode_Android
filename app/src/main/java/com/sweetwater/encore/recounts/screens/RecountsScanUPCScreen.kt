package com.sweetwater.encore.recounts.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sweetwater.encore.R
import com.sweetwater.encore.core_components.BasicTextLabel
import com.sweetwater.encore.core_components.CustomErrorSnackBarView
import com.sweetwater.encore.core_components.FullScreenErrorScreen
import com.sweetwater.encore.core_components.KeyboardDialog
import com.sweetwater.encore.core_components.KeyboardIcon
import com.sweetwater.encore.core_components.ProductTile
import com.sweetwater.encore.recounts.data.dto.RecountProductDto
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto
import com.sweetwater.encore.recounts.state.RecountsScanUPCState
import com.sweetwater.encore.recounts.viewmodels.RecountsScanUPCViewModel

@Preview
@Composable
fun RecountsScanUPCPreview() {
    RecountsScanUPCContent(modifier = Modifier,
        onBackEvent = {},
        onProductClicked = {},
        onKeyboardToggled = {},
        onKeyboardConfirm = {},
        onErrorEvent = {},
        onRecountComplete = {},
        state = RecountsScanUPCState(
            recountRequest = RecountRequestDto(
                recountRequestId = 0,
                priority = 0,
                requestedByEmployee = 0,
                requestedDate = "",
                requestedStatus = "",
                completedAt = "",
                product = RecountProductDto(
                    description = "Dynamic Vocal Mic",
                    imageURL = "http://thebomb.com",
                    manufacturer = "Shure",
                    name = "SM58",
                    productBoxes = emptyList(),
                    id = 13963,
                    productIdentifiers = emptyList(),
                    serialNumber = null
                ),
            ), locationName = "M1-01-01-A-01", recountLocations = emptyList()
        )
    )
}

@Composable
fun RecountsScanUPCScreen(
    modifier: Modifier = Modifier,
    viewModel: RecountsScanUPCViewModel,
    onReturnToScanLocation: () -> Unit,
    onRecountComplete: (locationName: String, force: Boolean) -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.onNavigatedTo()
    }

    RecountsScanUPCContent(modifier = modifier,
        state = viewModel.recountsScanUPCState.value,
        onProductClicked = { viewModel.onProductClicked() },
        onKeyboardConfirm = { viewModel.onKeyboardConfirm(it) },
        onKeyboardToggled = { viewModel.onKeyboardToggled(it) },
        onBackEvent = onReturnToScanLocation,
        onErrorEvent = { viewModel.clearErrorMessage() },
        onRecountComplete = { onRecountComplete(viewModel.locationName, viewModel.shouldForce) })
}

@Composable
fun RecountsScanUPCContent(
    modifier: Modifier,
    state: RecountsScanUPCState,
    onBackEvent: () -> Unit,
    onProductClicked: () -> Unit,
    onKeyboardConfirm: (String) -> Unit,
    onKeyboardToggled: (Boolean) -> Unit,
    onErrorEvent: () -> Unit,
    onRecountComplete: () -> Unit
) {
    if (state.isLoading) {
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

    if (state.hasCompletedRecount) {
        onRecountComplete()
    }

    BackHandler() {
        onBackEvent()
    }

    AnimatedVisibility(
        state.displayFullScreenError, enter = fadeIn(), exit = fadeOut()
    ) {
        FullScreenErrorScreen(
            errorMessage = ""
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (state.errorMessage.isNotEmpty()) {
            CustomErrorSnackBarView(errorMessage = state.errorMessage,
                actionText = stringResource(R.string.cycle_count_got_it_action_text),
                hasAction = true,
                actionTextAction = { onErrorEvent() })
        }

        if (state.promptForSerialNumber) {
            CustomErrorSnackBarView(
                errorMessage = stringResource(R.string.cycle_count_scan_upcs_enter_serial_label),
                backgroundColor = Color.Yellow
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        if (state.locationName.isNotEmpty()) {
            BasicTextLabel(
                text = state.locationName, fontSize = 28, fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (state.recountRequest?.product != null) {
            ProductTile(modifier = modifier,
                name = state.recountRequest.product.name,
                productManufacturer = state.recountRequest.product.manufacturer,
                shortDescription = state.recountRequest.product.description,
                imageUrl = state.recountRequest.product.imageURL,
                serialNumber = state.inputSerialNumber,
                isSerialNumberRequired = state.expectedSerialNumber.isNotEmpty() && state.countedQuantity > 0,
                productQuantity = state.countedQuantity,
                productBoxesCount = state.recountRequest.product.productBoxes.size,
                isVarianceDetected = state.isVarianceDetected,
                onProductItemClicked = { _, _, _ ->
                    if (state.expectedSerialNumber.isEmpty() || state.promptForSerialNumber) {
                        onProductClicked()
                    }
                })
        }

        Box(modifier = modifier.fillMaxSize()) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.90f)
            ) {
                KeyboardDialog(
                    show = state.isKeyboardToggled,
                    dialogTitle = if (state.updatingQuantity) stringResource(R.string.recounts_enter_recount_quantity_label)
                        else if (state.promptForSerialNumber) stringResource(R.string.recounts_serial_number_prompt)
                        else stringResource(
                            R.string.recounts_enter_product_upc_dialog_title
                        ),

                    inputHintText = if (state.updatingQuantity) stringResource(R.string.recounts_enter_quantity_input_hint_text)
                        else if (state.promptForSerialNumber) stringResource(R.string.recounts_serial_number_hint)
                        else stringResource(
                            R.string.recounts_scan_upcs_input_hint_text
                        ),
                    onDismiss = {
                        onKeyboardToggled(false)
                    },
                    onConfirm = {
                        onKeyboardConfirm(it)
                    },
                    keyboardType = if (state.updatingQuantity) KeyboardType.Number else KeyboardType.Email
                )
            }

            KeyboardIcon(
                modifier = Modifier.align(Alignment.BottomEnd),
                onKeyboardToggled = onKeyboardToggled
            )
        }
    }
}