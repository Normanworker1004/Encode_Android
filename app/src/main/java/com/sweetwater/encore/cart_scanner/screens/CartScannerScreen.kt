@file:OptIn(ExperimentalAnimationApi::class)

package com.sweetwater.encore.cart_scanner.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.sweetwater.encore.R
import com.sweetwater.encore.cart_scanner.state.CartScannerState
import com.sweetwater.encore.cart_scanner.viewmodels.CartScannerViewModel
import com.sweetwater.encore.core_components.KeyboardDialog
import com.sweetwater.encore.core_components.MessageBox
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions

@Preview
@Composable
fun CartScannerScreenPreview() {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.encore_bg),
            contentDescription = stringResource(id = R.string.pickmod_scanner_background_encore_image_content_description)
        )
        CartScannerContent(
            cartScannerState = CartScannerState(
                instructions = CartScannerScreenInstructions(
                    "Title",
                    "Subtitle 1",
                    "Subtitle 2",
                    "https://www.example.com/image.jpg",
                ), previewImage = painterResource(id = R.drawable.qr_code_ryan)
            ),
            onKeyboardToggled = {},
            onConfirmKeyboard = {},
            onClearError = {},
            onUnregistered = {}
        )
    }
}

@Composable
fun CartScannerScreen(
    modifier: Modifier = Modifier,
    viewModel: CartScannerViewModel = viewModel(),
    onBack: () -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.onNavigatedTo()
    }

    BackHandler() {
        viewModel.onBack()
        onBack()
    }

    CartScannerContent(
        modifier = modifier,
        cartScannerState = viewModel.cartScannerState.value,
        onKeyboardToggled = {
            viewModel.onKeyboardToggled(it)
        },
        onConfirmKeyboard = {
            viewModel.onConfirmKeyboard(it)
        },
        onClearError = {
            viewModel.clearError()
        },
        onUnregistered = {
            viewModel.onBack()
            onBack()
        }
    )
}

@Composable
fun CartScannerContent(
    modifier: Modifier = Modifier,
    cartScannerState: CartScannerState,
    onKeyboardToggled: (isToggled: Boolean) -> Unit,
    onConfirmKeyboard: (text: String) -> Unit,
    onClearError: () -> Unit,
    onUnregistered: () -> Unit,
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = 15.dp),
            verticalArrangement = Arrangement.Center
        ) {
            if (cartScannerState.cartError != null) {
                MessageBox(
                    title = cartScannerState.cartError.title,
                    message = cartScannerState.cartError.message
                ) {
                    onClearError()
                }
            }

            if (cartScannerState.isUnregistered) {
                onUnregistered()
            }

            KeyboardDialog(show = cartScannerState.isKeyboardToggled,
                dialogTitle = stringResource(R.string.pickmod_scanner_enter_barcode_dialog_title),
                inputHintText = stringResource(R.string.pickmod_scanner_barcode_input_hint_text),
                keyboardType = cartScannerState.instructions.keyboardType,
                onDismiss = {
                    onKeyboardToggled(false)
                },
                onConfirm = {
                    onConfirmKeyboard(it)
                },
            )
            if (cartScannerState.instructions.title.isNotEmpty()) {
                Text(
                    modifier = modifier
                        .padding(15.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    text = cartScannerState.instructions.title,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 32.sp,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black, offset = Offset(2f, 4f), blurRadius = 3f
                        )
                    )
                )
            }
            if (cartScannerState.instructions.subtitle1.isNotEmpty()) {
                Text(
                    modifier = modifier
                        .padding(15.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    text = cartScannerState.instructions.subtitle1,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 16.sp,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black, offset = Offset(2f, 4f), blurRadius = 3f
                        )
                    )
                )
            }
            if (cartScannerState.instructions.subtitle2.isNotEmpty()) {
                Text(
                    modifier = modifier
                        .padding(15.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    text = cartScannerState.instructions.subtitle2,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 48.sp,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black, offset = Offset(2f, 4f), blurRadius = 3f
                        )
                    )
                )
            }
            if (cartScannerState.instructions.imageURL.isNotEmpty()) {
                AsyncImage(
                    modifier = modifier
                        .heightIn(0.dp, 150.dp)
                        .widthIn(0.dp, 150.dp)
                        .padding(0.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    model = cartScannerState.instructions.imageURL,
                    contentDescription = stringResource(id = R.string.pickmod_scanner_profile_image_content_description),
                    contentScale = ContentScale.Fit,
                    placeholder = cartScannerState.previewImage
                )
            }
        }
        if (cartScannerState.instructions.isKeyboardIconVisible) {
            Image(
                modifier = modifier
                    .padding(12.dp)
                    .align(Alignment.BottomEnd)
                    .clickable {
                        onKeyboardToggled(true)
                    },
                painter = painterResource(id = R.drawable.keyboard1x),
                contentDescription = stringResource(id = R.string.pickmod_scanner_keyboard_toggle_content_description)
            )
        }
    }
}