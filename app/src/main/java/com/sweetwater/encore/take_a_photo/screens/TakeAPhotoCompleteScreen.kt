package com.sweetwater.encore.take_a_photo.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.sweetwater.encore.R

@Preview
@Composable
fun TakeAPhotoCompleteScreenPreview() {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.encore_bg),
            contentDescription = stringResource(id = R.string.pickmod_scanner_background_encore_image_content_description)
        )

        TakeAPhotoCompleteContent(
            modifier = Modifier,
            onTakeAnotherPhoto = {}
        )
    }
}

@Composable
fun TakeAPhotoCompleteScreen(
    modifier: Modifier = Modifier,
    onReturnToDashboard: () -> Unit,
    onTakeAnotherPhoto: () -> Unit
) {
    BackHandler() {
        onReturnToDashboard()
    }

    TakeAPhotoCompleteContent(
        modifier = modifier,
        onTakeAnotherPhoto = {
            onTakeAnotherPhoto()
        }
    )
}

@Composable
fun TakeAPhotoCompleteContent(
    modifier: Modifier = Modifier,
    onTakeAnotherPhoto: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.height(220.dp))

            Text(
                stringResource(R.string.take_a_photo_uploaded_label),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = Color.White,
                maxLines = 5,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(40.dp)
            )

            Spacer(Modifier.height(220.dp))

            OutlinedButton(
                onClick = {
                    onTakeAnotherPhoto()
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

                Text(stringResource(R.string.take_a_photo_take_another))

                Spacer(Modifier.width(10.dp))
            }
        }
    }
}