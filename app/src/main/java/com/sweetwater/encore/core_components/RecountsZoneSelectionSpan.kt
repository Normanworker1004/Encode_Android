package com.sweetwater.encore.core_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun RecountsZoneSelectionPreview() {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(.8f)
            .background(Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {
        RecountsZoneSelectionSpan(
            zone = "Pickmod 1 West",
            highPriorityCounts = 2,
            lowPriorityCounts = 1,
            backgroundColor = Color.Black.copy(alpha = .5f),
            borderStroke = BorderStroke(
                width = 2.dp,
                color = Color.White
            ),
            onItemClicked = {}
        )
    }
}

@Composable
fun RecountsZoneSelectionSpan(
    modifier: Modifier = Modifier,
    zone: String = "",
    hasBackground: Boolean = true,
    hasBorderStroke: Boolean = true,
    highPriorityCounts: Int = 0,
    lowPriorityCounts: Int = 0,
    borderRadius: Int = 12,
    backgroundColor: Color = Color.Black,
    textSize: Int = 24,
    valueColor: Color = Color.White,
    borderStroke: BorderStroke = BorderStroke(
        width = 2.dp,
        color = Color.White
    ),
    onItemClicked: () -> Unit
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(borderRadius.dp))
            .clickable { onItemClicked() }
            .fillMaxWidth()
            .height(65.dp)
            .background(
                if (hasBackground) backgroundColor.copy(
                    alpha = .5f
                ) else Color.Transparent
            )
            .border(
                border = if (hasBorderStroke) borderStroke else BorderStroke(
                    width = 0.dp,
                    color = Color.Transparent
                ),
                shape = RoundedCornerShape(borderRadius.dp)
            ),
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 16.dp)
        ) {
            Text(
                modifier = modifier
                    .padding(8.dp),
                text = zone,
                textAlign = TextAlign.Center,
                maxLines = 2,
                style = TextStyle(
                    color = valueColor.copy(
                        alpha = 1f
                    ),
                    fontWeight = FontWeight.Normal,
                    fontSize = textSize.sp
                )
            )

            Spacer(modifier = Modifier
                .weight(1f)
            )

            Text(
                modifier = modifier
                    .padding(8.dp),
                text = highPriorityCounts.toString(),
                textAlign = TextAlign.Center,
                maxLines = 2,
                style = TextStyle(
                    color = valueColor.copy(
                        alpha = 1f
                    ),
                    fontWeight = FontWeight.Normal,
                    fontSize = textSize.sp
                )
            )

            Spacer(modifier = Modifier
                .weight(0.1f)
            )

            Text(
                modifier = modifier
                    .padding(8.dp),
                text = lowPriorityCounts.toString(),
                textAlign = TextAlign.Center,
                maxLines = 2,
                style = TextStyle(
                    color = valueColor.copy(
                        alpha = 1f
                    ),
                    fontWeight = FontWeight.Normal,
                    fontSize = textSize.sp
                )
            )

            Spacer(modifier = Modifier
                .weight(0.1f)
            )
        }
    }
}