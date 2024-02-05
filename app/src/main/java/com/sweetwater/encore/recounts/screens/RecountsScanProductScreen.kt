package com.sweetwater.encore.recounts.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sweetwater.encore.R
import com.sweetwater.encore.core_components.BasicTextLabel
import com.sweetwater.encore.core_components.CustomErrorSnackBarView
import com.sweetwater.encore.core_components.ProductTile
import com.sweetwater.encore.recounts.data.dto.RecountProductDto
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto
import com.sweetwater.encore.recounts.state.RecountsScanProductState
import com.sweetwater.encore.recounts.viewmodels.RecountsScanProductViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun ScanProductScreenPreview(
) {
    RecountScanProductContent(
        modifier = Modifier,
        state = RecountsScanProductState(
            requests = listOf(
                RecountRequestDto(
                    recountRequestId = 1,
                    priority = 2,
                    requestedByEmployee = 1,
                    requestedDate = "",
                    requestedStatus = "",
                    completedAt = "",
                    product = RecountProductDto(
                        id = 13963,
                        description = "Dynamic Vocal Microphone",
                        imageURL = "https://media.sweetwater.com/images/dynamic/SM58/original-600.jpg",
                        manufacturer = "Shure",
                        name = "SM58",
                        productBoxes = emptyList(),
                        productIdentifiers = listOf("SM58"),
                        serialNumber = null
                    ),
                ),
                RecountRequestDto(
                    recountRequestId = 1,
                    priority = 1,
                    requestedByEmployee = 1,
                    requestedDate = "",
                    requestedStatus = "",
                    completedAt = "",
                    product = RecountProductDto(
                        id = 13963,
                        description = "Three letters of the alphabet after 'S' to make sure sort work",
                        imageURL = "https://media.sweetwater.com/images/dynamic/TUV/original-600.jpg",
                        manufacturer = "",
                        name = "TUV",
                        productBoxes = emptyList(),
                        productIdentifiers = listOf("SM58"),
                        serialNumber = null
                    ),
                ),
                RecountRequestDto(
                    recountRequestId = 1,
                    priority = 1,
                    requestedByEmployee = 1,
                    requestedDate = "",
                    requestedStatus = "",
                    completedAt = "",
                    product = RecountProductDto(
                        id = 13963,
                        description = "Now I know my ABC's",
                        imageURL = "https://media.sweetwater.com/images/dynamic/XYZ/original-600.jpg",
                        manufacturer = "",
                        name = "XYZ",
                        productBoxes = emptyList(),
                        productIdentifiers = listOf("SM58"),
                        serialNumber = null
                    ),
                ),
            ),
            locations = emptyList()
        ),
        onReturnToChooseZone = {},
        onClearError = {},
        onProductClicked = {},
        zoneName = "Conveyable"
    )
}

@Composable
fun RecountsScanProductScreen(
    modifier: Modifier = Modifier,
    onReturnToChooseZone: () -> Unit,
    onProductClicked: () -> Unit,
    viewModel: RecountsScanProductViewModel,
) {
    LaunchedEffect(key1 = true) {
        viewModel.onLaunch()
    }

    BackHandler {
        viewModel.clearError()
        onReturnToChooseZone()
    }

    val coroutineScope = rememberCoroutineScope()

    RecountScanProductContent(
        modifier = modifier,
        state = viewModel.recountsScanProductState.value,
        zoneName = viewModel.zoneName,
        onReturnToChooseZone = { onReturnToChooseZone() },
        onClearError = { viewModel.clearError() },
        onProductClicked = {
            coroutineScope.launch {
                viewModel.setSelectedRequestAndLocations(it)
                onProductClicked()
            }
        }
    )
}

@Composable
fun RecountScanProductContent(
    modifier: Modifier,
    state: RecountsScanProductState,
    zoneName: String,
    onReturnToChooseZone: () -> Unit,
    onClearError: () -> Unit,
    onProductClicked: (recountRequest: RecountRequestDto) -> Unit
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

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        BasicTextLabel(
            text = zoneName,
            fontSize = 28,
            fontWeight = FontWeight.Bold,
        )

        if (state.error.isNotEmpty()) {
            CustomErrorSnackBarView(
                errorMessage = state.error
            )

            LaunchedEffect(key1 = true) {
                delay(1500)
                onClearError()
                onReturnToChooseZone()
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        if (!state.isLoading && state.requests.isEmpty()) {
            BasicTextLabel(text = stringResource(R.string.recounts_no_products_remaining_label))
        }
        LazyColumn {
            items(
                state.requests.sortedWith(
                    compareBy(
                        { request -> request.priority },
                        { request -> request.product.name })
                )
            )
            { request ->
                ProductTile(
                    modifier = modifier,
                    imageUrl = request.product.imageURL,
                    name = request.product.name,
                    productManufacturer = request.product.manufacturer,
                    shortDescription = request.product.description,
                    serialNumber = request.product.serialNumber,
                    priority = request.priority,
                    onProductItemClicked = { name, serialNumber, _ ->
                        val recountRequest =
                            state.requests.find { request -> name == request.product.name && serialNumber == request.product.serialNumber }
                        onProductClicked(recountRequest!!)
                    },
                )
            }
        }
    }
}