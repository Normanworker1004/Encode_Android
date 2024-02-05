package com.sweetwater.encore.core_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun BasicTextPreview() {
    BasicTextLabel(
        text = "Some basic example of text"
    )
}

@Composable
fun BasicTextLabel(
    modifier: Modifier = Modifier,
    fontSize: Int = 24,
    textColor: Color = Color.White,
    text: String,
    textAlign: TextAlign = TextAlign.Center,
    maxLines: Int = 3,
    fontWeight: FontWeight = FontWeight.Normal,
    shadow: Shadow = Shadow(
        color = Color.Black,
        offset = Offset(2.0f, 2.0f),
        blurRadius = 3f
    ),
    onLabelTapped: () -> Unit = { }
) {
    Text(
        modifier = modifier
            .padding(4.dp)
            .clickable(onClick = onLabelTapped),
        text = text,
        textAlign = textAlign,
        maxLines = maxLines,
        style = TextStyle(
            color = textColor.copy(
                alpha = 1f
            ),
            fontWeight = fontWeight,
            fontSize = fontSize.sp,
            shadow = shadow
        )
    )
}