package com.sweetwater.encore.core_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sweetwater.encore.R

@Preview
@Composable
fun RecountsZoneSelectionKeyPreview() {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(.8f)
            .background(Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {
        RecountsZoneSelectionKey(
            zone = "Zone",
            valueColor = Color.White,
            textSize = 18,
            triangleSize = 18
        )
    }
}

@Composable
fun RecountsZoneSelectionKey(
    modifier: Modifier = Modifier,
    zone: String = stringResource(id = R.string.recounts_zone_default_label),
    triangleSize: Int = 18,
    textSize: Int = 18,
    valueColor: Color = Color.White,
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = modifier,
                text = zone,
                textAlign = TextAlign.Center,
                maxLines = 2,
                style = TextStyle(
                    color = valueColor.copy(
                        alpha = 1f
                    ),
                    fontWeight = FontWeight.Normal,
                    fontSize = textSize.sp,
                    shadow = Shadow(
                        color = Color.Black, offset = Offset(2.0f, 2.0f), blurRadius = 3f
                    )
                )
            )

            Spacer(
                modifier = Modifier
                    .weight(1f)
            )

            PriorityIndicator(modifier = modifier, size = triangleSize, priority = 2)

            Spacer(
                modifier = Modifier
                    .weight(0.1f)
            )

            PriorityIndicator(modifier = modifier, size = triangleSize, priority = 1)
        }
    }
}