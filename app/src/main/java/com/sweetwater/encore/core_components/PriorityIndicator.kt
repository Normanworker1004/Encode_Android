package com.sweetwater.encore.core_components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

@Composable
fun PriorityIndicator(modifier: Modifier, size: Int, priority: Int) {
    Canvas(
        modifier = modifier
            .size(size.dp),
        onDraw = {
            val size = size.dp.toPx()
            val trianglePath = if (priority == 2)
                Path().apply {
                    moveTo(size / 2, 0f) // Moves to top center position
                    lineTo(size, size) // Add line to bottom right corner
                    lineTo(0f, size) // Add line to bottom left corner
                } else
                Path().apply {
                    moveTo(size / 2, size) // Moves to bottom center position
                    lineTo(size, 0f) // Add line to top right corner
                    lineTo(0f, 0f) // Add line to top left corner
                }
            drawPath(
                color = if (priority == 2) Color.Red else Color.Green,
                path = trianglePath
            )
        }
    )
}