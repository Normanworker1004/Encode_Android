package com.sweetwater.encore.take_a_photo.screens

import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sweetwater.encore.R
import com.sweetwater.encore.core_components.CustomErrorSnackBarView
import com.sweetwater.encore.core_components.CameraView
import com.sweetwater.encore.core_components.takePicture
import com.sweetwater.encore.take_a_photo.state.TakeAPhotoCaptureState
import com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoCaptureViewModel

@Preview
@Composable
fun TakeAPhotoCaptureScreenPreview() {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.encore_bg),
            contentDescription = stringResource(id = R.string.pickmod_scanner_background_encore_image_content_description)
        )

        TakeAPhotoCaptureContent(
            modifier = Modifier,
            tag = "123456",
            takeAPhotoCaptureState = TakeAPhotoCaptureState.initialState(),
            clearCapturedImage = {},
            handleCaptureError = {},
            handleImageCaptured = {},
            onKeyboardTextChanged = {},
            uploadToGDS = {},
            showCameraFeatures = {}
        )
    }
}

@Composable
fun TakeAPhotoCaptureScreen(
    modifier: Modifier = Modifier,
    viewModel: TakeAPhotoCaptureViewModel = viewModel(),
    onReturnToScanUPC: () -> Unit,
    onWorkflowComplete: () -> Unit
) {
    val takeAPhotoCaptureState = viewModel.takeAPhotoCaptureState.value

    if(takeAPhotoCaptureState.complete) {
        onWorkflowComplete()
    }

    LaunchedEffect(key1 = true) {
        viewModel.onNavigatedTo()
    }

    BackHandler() {
        if (takeAPhotoCaptureState.isCaptured) {
            viewModel.clearCapturedImage()
        } else {
            viewModel.clearPhotoDescription()
            onReturnToScanUPC()
        }
    }

    TakeAPhotoCaptureContent(
        modifier = modifier,
        takeAPhotoCaptureState = takeAPhotoCaptureState,
        tag = viewModel.takeAPhotoCaptureState.value.tagText,
        handleImageCaptured = {
            viewModel.handleImageCaptured(it)
            viewModel.clearError()
        },
        handleCaptureError = {
            viewModel.handleCaptureError(it.localizedMessage)
        },
        clearCapturedImage = {
            viewModel.clearCapturedImage()
        },
        onKeyboardTextChanged = {
            viewModel.onInputTextChanged(it)
        },
        uploadToGDS = {
            viewModel.uploadToGDS()
        },
        showCameraFeatures = {
            viewModel.showCameraFeatures()
        }
    )
}

@Composable
fun TakeAPhotoCaptureContent(
    modifier: Modifier = Modifier,
    tag: String,
    takeAPhotoCaptureState: TakeAPhotoCaptureState,
    handleImageCaptured: (uri: Uri) -> Unit,
    handleCaptureError: (newError: ImageCaptureException) -> Unit,
    clearCapturedImage: () -> Unit,
    uploadToGDS: () -> Unit,
    showCameraFeatures: () -> Unit,
    onKeyboardTextChanged: (text: String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (takeAPhotoCaptureState.error.isNotEmpty()) {
            CustomErrorSnackBarView(
                errorMessage = takeAPhotoCaptureState.error,
            )
        }

        Text(
            "Tag: " + tag,
            fontSize = 25.sp,
            color = Color.White,
            maxLines = 1,
            textAlign = TextAlign.Start,
            modifier = Modifier.width(300.dp)
        )

        TextField(modifier = Modifier
            .width(300.dp),
            value = takeAPhotoCaptureState.descriptionText,
            onValueChange = {
                onKeyboardTextChanged(it)
            },
            placeholder = {
                Text(stringResource(R.string.take_a_photo_description))
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF000000),
                backgroundColor = Color(0xFFFFFFFF),
                cursorColor = Color(0xFF4B67F4),
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                placeholderColor = Color.Gray
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
        )

        val context = LocalContext.current
        val cameraController: LifecycleCameraController = remember { LifecycleCameraController(context) }
        val imageCapture: ImageCapture = remember {
            ImageCapture.Builder().build()
        }

        if (takeAPhotoCaptureState.isCaptured) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest
                        .Builder(LocalContext.current)
                        .data(data = takeAPhotoCaptureState.capturedImage)
                        .build()
                ),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        clearCapturedImage()
                    }
                    .padding(10.dp)
                    .size(300.dp, 400.dp),
            )
        } else {
            if (takeAPhotoCaptureState.showCameraFeatures) {
                CameraView(
                    context = context,
                    cameraController = cameraController,
                    lifecycleOwner = LocalLifecycleOwner.current
                )
            } else {
                Spacer(modifier = Modifier
                    .size(300.dp, 400.dp)
                )
            }
        }

        if (!takeAPhotoCaptureState.uploading) {
            OutlinedButton(
                onClick = {
                    if (!takeAPhotoCaptureState.showCameraFeatures) {
                        showCameraFeatures()
                    } else {
                        if (takeAPhotoCaptureState.isCaptured) {
                            uploadToGDS()

                        } else {
                            imageCapture.takePicture(
                                context,
                                CameraSelector.LENS_FACING_BACK,
                                cameraController,
                                handleImageCaptured,
                                handleCaptureError
                            )
                        }
                    }
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.White
                ),
                border = BorderStroke(
                    width = 2.dp,
                    color = Color.White
                ),
            ) {
                Spacer(Modifier.width(10.dp))
                if (!takeAPhotoCaptureState.showCameraFeatures) {
                    Text(stringResource(R.string.take_a_photo_capture_show_camera))
                } else {
                    if (takeAPhotoCaptureState.isCaptured) {
                        Text(stringResource(R.string.take_a_photo_capture_submit))
                    } else {
                        Text(stringResource(R.string.take_a_photo_capture_image_top_bar_menu_label))
                    }
                }

                Spacer(Modifier.width(10.dp))
            }
        } else {
            CircularProgressIndicator(color = Color.White)
        }
    }
}