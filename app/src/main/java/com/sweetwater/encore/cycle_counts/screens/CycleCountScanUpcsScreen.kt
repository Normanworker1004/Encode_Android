package com.sweetwater.encore.cycle_counts.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sweetwater.encore.R
import com.sweetwater.encore.cycle_counts.dto.ProductScanInfo
import com.sweetwater.encore.cycle_counts.state.CycleCountScanUpcsState
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanUpcsViewModel
import com.sweetwater.encore.core_components.KeyboardDialog
import com.sweetwater.encore.core_components.CustomErrorSnackBarView
import com.sweetwater.encore.core_components.DoneButton
import com.sweetwater.encore.core_components.FullScreenErrorScreen
import com.sweetwater.encore.core_components.KeyboardIcon
import com.sweetwater.encore.core_components.ProductTile

@Preview
@Composable
fun CycleCountScanUpcsContentPreview() {
    val scannedProductListPreview = SnapshotStateList<ProductScanInfo>()
    scannedProductListPreview.add(
        ProductScanInfo(
            productId = 13963,
            name = "SM58",
            imageUrl = "",
            productManufacturer = "Manufacturer",
            shortDescription = "Short Description",
            isSerialNumberRequired = true,
            serialNumber = "Serial Number",
            isIdentifierKeyed = false,
            isQuantityKeyed = false,
            productQuantity = 1,
            productIdentifiers = emptyList(),
            countForProductStartedAt = ""
        )
    )
    CycleCountScanUpcsContent(cycleCountScanUpcsState = CycleCountScanUpcsState(
        scannedProductList = scannedProductListPreview
    ),
        locationName = "My Location Dude",
        onBackEvent = {},
        onDoneButtonClicked = {},
        onErrorEvent = {},
        onConfirmKeyboard = {},
        onKeyboardToggled = {},
        onProductClicked = { _, _, _ -> },
        onComplete = {}
        )
}

@Composable
fun CycleCountScanUpcsScreen(
    modifier: Modifier = Modifier,
    viewModel: CycleCountScanUpcsViewModel,
    onDoneButtonClicked: () -> Unit,
    onBackEvent: () -> Unit,
    onComplete: (varianceReported: Boolean, locationName: String) -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.onNavigatedTo()
    }

    CycleCountScanUpcsContent(modifier = modifier,
        cycleCountScanUpcsState = viewModel.cycleCountScanUpcsState.value,
        locationName = viewModel.locationName,
        onConfirmKeyboard = {
            viewModel.onConfirmKeyboard(it)
        },
        onKeyboardToggled = {
            viewModel.onKeyboardToggled(it)
        },
        onDoneButtonClicked = {
            viewModel.onDoneButtonClicked()
            onDoneButtonClicked()
        },
        onErrorEvent = {
            viewModel.clearErrorMessage()
        },
        onBackEvent = {
            onBackEvent()
        },
        onProductClicked = { name, serialNumber, requiresSerialNumber ->
            viewModel.onProductClicked(name, serialNumber, requiresSerialNumber)
        },
        onComplete = {
            onComplete(viewModel.shouldForce, viewModel.locationName)
        }
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CycleCountScanUpcsContent(
    modifier: Modifier = Modifier,
    cycleCountScanUpcsState: CycleCountScanUpcsState,
    locationName: String,
    onConfirmKeyboard: (String) -> Unit,
    onKeyboardToggled: (Boolean) -> Unit,
    onDoneButtonClicked: () -> Unit,
    onErrorEvent: () -> Unit,
    onBackEvent: () -> Unit,
    onProductClicked: (name: String, serialNumber: String, requiresSerialNumber: Boolean) -> Unit,
    onComplete: () -> Unit
) {
    BackHandler {
        onBackEvent()
    }

    if (cycleCountScanUpcsState.hasCompletedCount) {
        onComplete()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AnimatedVisibility(
            cycleCountScanUpcsState.displayFullScreenError,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            FullScreenErrorScreen(
                errorMessage = ""
            )
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.90f)
        ) {

            KeyboardDialog(
                show = cycleCountScanUpcsState.isKeyboardToggled,
                dialogTitle = if (cycleCountScanUpcsState.updatingQuantity)
                    stringResource(id = R.string.cycle_count_enter_quantity_dialog_title)
                else stringResource(R.string.cycle_count_enter_product_upc_dialog_title),
                inputHintText = if (cycleCountScanUpcsState.updatingQuantity)
                    stringResource(id = R.string.cycle_count_enter_quantity_input_hint_text)
                else stringResource(R.string.cycle_count_scan_upcs_input_hint_text),
                keyboardType = if (cycleCountScanUpcsState.updatingQuantity) KeyboardType.Number else KeyboardType.Email,
                onDismiss = {
                    onKeyboardToggled(false)
                },
                onConfirm = {
                    onConfirmKeyboard(it)
                },
            )

            if (cycleCountScanUpcsState.isLoading) {
                CircularProgressIndicator(
                    modifier = modifier
                        .padding(top = 18.dp)
                        .align(Alignment.Center),
                    color = Color.White,
                    strokeWidth = 4.dp
                )
            }

            Column(
                modifier = modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (cycleCountScanUpcsState.errorMessage.isNotEmpty()) {
                    CustomErrorSnackBarView(errorMessage = cycleCountScanUpcsState.errorMessage,
                        actionText = stringResource(R.string.cycle_count_got_it_action_text),
                        hasAction = true,
                        actionTextAction = { onErrorEvent() })
                }

                if (cycleCountScanUpcsState.serialNumberPrompt) {
                    CustomErrorSnackBarView(
                        errorMessage = stringResource(R.string.cycle_count_scan_upcs_enter_serial_label),
                        backgroundColor = Color.Yellow
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    locationName,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        shadow = Shadow(
                            color = Color.Black, offset = Offset(2.0f, 2.0f), blurRadius = 3f
                        )
                    ),
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn {
                    items(items = cycleCountScanUpcsState.scannedProductList) { scannedProduct ->
                        ProductTile(name = scannedProduct.name,
                            imageUrl = scannedProduct.imageUrl,
                            productManufacturer = scannedProduct.productManufacturer,
                            shortDescription = scannedProduct.shortDescription,
                            isSerialNumberRequired = scannedProduct.isSerialNumberRequired,
                            serialNumber = scannedProduct.serialNumber,
                            productQuantity = scannedProduct.productQuantity,
                            isVarianceDetected = scannedProduct.isVarianceDetected,
                            onProductItemClicked = { name, serialNumber, requiresSerialNumber ->
                                onProductClicked(name, serialNumber ?: "", requiresSerialNumber)
                            })
                    }
                }
            }
        }

        DoneButton(
            modifier = Modifier.align(Alignment.BottomCenter),
            onDoneButtonClicked = onDoneButtonClicked
        )
        KeyboardIcon(
            modifier = Modifier.align(Alignment.BottomEnd), onKeyboardToggled = onKeyboardToggled
        )
    }
}