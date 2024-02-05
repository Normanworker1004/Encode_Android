@file:OptIn(ExperimentalAnimationApi::class)

package com.sweetwater.encore.cart_scanner.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sweetwater.encore.R
import com.sweetwater.encore.cart_scanner.state.ScanCartQrCodeState
import com.sweetwater.encore.cart_scanner.viewmodels.ScanCartQrCodeViewModel
import com.sweetwater.encore.core_components.CustomErrorSnackBarView
import kotlinx.coroutines.delay

@Preview
@Composable
fun ScanCartQrCodePreview() {
    ScanCartQrCodeContent(
        scanCartQrCodeState = ScanCartQrCodeState(),
        onClearError = {},
    )
}

@Composable
fun ScanCartQrCodeScreen(
    modifier: Modifier = Modifier,
    viewModel: ScanCartQrCodeViewModel = viewModel(),
    onBack: () -> Unit,
    onCartRegistered: () -> Unit,
) {
    val scanCartQrCodeState = viewModel.scanCartQrCodeState.value;

    LaunchedEffect(key1 = scanCartQrCodeState) {
        if (scanCartQrCodeState.isRegistered) {
            onCartRegistered()
        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.onNavigatedTo()
    }

    BackHandler() {
        viewModel.onBack()
        onBack()
    }

    ScanCartQrCodeContent(
        modifier = modifier,
        scanCartQrCodeState = scanCartQrCodeState,
        onClearError = {
            viewModel.clearError()
        }
    )
}

@Composable
fun ScanCartQrCodeContent(
    modifier: Modifier = Modifier,
    scanCartQrCodeState: ScanCartQrCodeState,
    onClearError: () -> Unit,
) {
    Box(modifier = modifier.fillMaxSize()) {
        if (scanCartQrCodeState.error.isNotEmpty()) {
            CustomErrorSnackBarView(errorMessage = scanCartQrCodeState.error)

            LaunchedEffect(true) {
                delay(2500)
                onClearError()
            }
        }

        Image(
            modifier = modifier.align(Center),
            painter = painterResource(id = R.drawable.scan_qr_icon),
            contentDescription = stringResource(id = R.string.pickmod_scanner_scan_cart_qr_code_content_description)
        )
    }
}


