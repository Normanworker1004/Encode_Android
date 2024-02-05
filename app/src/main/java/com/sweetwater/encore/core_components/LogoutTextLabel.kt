package com.sweetwater.encore.core_components

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun LogoutTextLabel() {
    BasicTextLabel(
        text = "Some basic example of text"
    )
}

@Composable
fun LogoutTextLabel(
    modifier: Modifier = Modifier,
    fontSize: Int = 24,
    text: String,
    onLabelTapped: () -> Unit = { }
) {
    Text(
        modifier = modifier.clickable(onClick = onLabelTapped),
        text = text,
        textAlign = TextAlign.Center,
        style = TextStyle(
            color = Color.White.copy(
                alpha = 0.8f
            ),
            fontWeight = FontWeight.ExtraBold,
            fontSize = fontSize.sp
        )
    )
}