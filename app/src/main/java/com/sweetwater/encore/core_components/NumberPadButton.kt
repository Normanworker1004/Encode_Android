package com.sweetwater.encore.core_components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun NumPadButtonPreview() {
    NumPadText(
        text = "1"
    )
}

// A single button in the number pad
@Composable
fun NumPadText(
    modifier: Modifier = Modifier,
    text: String,
    textSize: Int = 24,
    textColor: Color = Color.White,
) {
    Text(
        modifier = modifier
            .padding(8.dp),
        text = if (text.contains("x") || text.contains("✓")) text else text,
        color = textColor,
        fontSize = textSize.sp,
        fontWeight = FontWeight.Bold
    )
}