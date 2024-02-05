package com.sweetwater.encore.core_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

// Full Screen Red Translucent Error Screen
@Composable
fun FullScreenErrorScreen(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0x99FF4343),
    errorMessage: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor),
    ) {

        BasicTextLabel(
            modifier = modifier.align(Alignment.Center),
            text = errorMessage,
            fontSize = 32,
            fontWeight = FontWeight.Bold
        )

    }

}