package com.sweetwater.encore.take_a_photo.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sweetwater.encore.R
import com.sweetwater.encore.core_components.KeyboardDialog
import com.sweetwater.encore.core_components.CustomErrorSnackBarView
import com.sweetwater.encore.take_a_photo.state.TakeAPhotoScanUPCState
import com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoScanUPCViewModel

@Preview
@Composable
fun TakeAPhotoScanUPCScreenPreview() {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.encore_bg),
            contentDescription = stringResource(id = R.string.pickmod_scanner_background_encore_image_content_description)
        )

        TakeAPhotoScanUPCContent(
            modifier = Modifier,
            takeAPhotoScanUPCState = TakeAPhotoScanUPCState.initialState(),
            onKeyboardToggled = {},
            onConfirmKeyboard = {}
        )
    }
}

@Composable
fun TakeAPhotoScanUPCScreen(
    modifier: Modifier = Modifier,
    viewModel: TakeAPhotoScanUPCViewModel = viewModel(),
    onReturnToDashboard: () -> Unit,
    onUPCScanned: (tagText: String) -> Unit
) {
    val takeAPhotoScanUPCState = viewModel.takeAPhotoScanUPCState.value

    if(takeAPhotoScanUPCState.tag != "") {
        onUPCScanned(takeAPhotoScanUPCState.tag)
        viewModel.clearTag()
    }

    LaunchedEffect(key1 = true) {
        viewModel.onNavigatedTo()
    }

    BackHandler() {
        viewModel.clearTag()
        onReturnToDashboard()
    }

    TakeAPhotoScanUPCContent(
        modifier = modifier,
        takeAPhotoScanUPCState = takeAPhotoScanUPCState,
        onKeyboardToggled = {
            viewModel.onKeyboardToggled(it)
        },
        onConfirmKeyboard = {
            viewModel.onConfirmKeyboard(it)
        }
    )
}

@Composable
fun TakeAPhotoScanUPCContent(
    modifier: Modifier = Modifier,
    takeAPhotoScanUPCState: TakeAPhotoScanUPCState,
    onKeyboardToggled: (isToggled: Boolean) -> Unit,
    onConfirmKeyboard: (text: String) -> Unit,
) {
    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = 15.dp),
            verticalArrangement = Arrangement.Center
        ) {
            if (takeAPhotoScanUPCState.error.isNotEmpty()) {
                CustomErrorSnackBarView(
                    errorMessage = takeAPhotoScanUPCState.error,
                )
            }

            Text(
                stringResource(R.string.take_a_photo_prompt),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = Color.White,
                maxLines = 5,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(40.dp)
            )

            KeyboardDialog(
                show = takeAPhotoScanUPCState.isKeyboardToggled,
                dialogTitle = stringResource(R.string.take_a_photo_enter_product_upc_no_serial),
                inputHintText = stringResource(R.string.take_a_photo_scan_upc_hint),
                onDismiss = {
                    onKeyboardToggled(false)
                },
                onConfirm = {
                    onConfirmKeyboard(it)
                },
            )
        }

        Image(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp)
                .clickable {
                    onKeyboardToggled(true)
                },
            painter = painterResource(id = R.drawable.keyboard1x),
            contentDescription = stringResource(id = R.string.pickmod_scanner_keyboard_toggle_content_description)
        )
    }
}