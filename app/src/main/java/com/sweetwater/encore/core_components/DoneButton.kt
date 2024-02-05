package com.sweetwater.encore.core_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sweetwater.encore.R

@Preview
@Composable
fun DoneButtonPreview() {}

@Composable
fun DoneButton(modifier: Modifier = Modifier, onDoneButtonClicked: () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {

        Button(
            modifier = modifier
                .align(alignment = Alignment.BottomCenter)
                .width(120.dp),
            onClick = {
                onDoneButtonClicked()
            },
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp
            ),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(
                width = 1.dp,
                color = Color.Gray
            ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black.copy(
                    alpha = 0.5f
                ),
                contentColor = Color.White
            ),
        ) {
            Text(
                text = stringResource(R.string.cycle_count_done_action_text),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp
                )
            )
        }
    }
}