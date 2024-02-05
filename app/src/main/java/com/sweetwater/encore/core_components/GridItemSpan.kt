package com.sweetwater.encore.core_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sweetwater.encore.ui.theme.AppTheme

@Preview
@Composable
fun GridItemPreview() {

    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(.8f)
            .background(Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {

        GridItemSpan(
            label = "Location",
            value = "65%",
            hasBackground = true,
            backgroundColor = Color.Black.copy(alpha = .5f),
            hasBorderStroke = true,
            borderStroke = BorderStroke(
                width = 2.dp,
                color = Color.White
            ),
            onItemClicked = {}
        )
    }


}

@Composable
fun GridItemSpan(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    hasBorderStroke: Boolean = true,
    borderRadius: Int = 8,
    hasDropShadow: Boolean = true,
    shadow: Shadow = Shadow(
        color = Color.Black,
        offset = Offset(2.0f, 4.0f),
        blurRadius = 3f
    ),
    backgroundColor: Color = Color.Black,
    hasBackground: Boolean = false,
    labelTextSize: Int = 24,
    valueTextSize: Int = 24,
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
            .background(
                if (hasBackground) backgroundColor.copy(
                    alpha = .5f
                ) else Color.Transparent
            )
            .clickable { onItemClicked() }
            .border(
                border = if (hasBorderStroke) borderStroke else BorderStroke(
                    width = 0.dp,
                    color = Color.Transparent
                ),
                shape = RoundedCornerShape(borderRadius.dp)
            ),

        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = modifier.padding(AppTheme.dimens.gridItem_2),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                text = label,
                textAlign = TextAlign.Center,
                maxLines = 2,
                style = TextStyle(
                    color = Color.White.copy(
                        alpha = 1f
                    ),
                    fontWeight = FontWeight.Normal,
                    fontSize = labelTextSize.sp,
                    shadow = if (hasDropShadow) shadow else Shadow(
                        color = Color.Transparent,
                        offset = Offset(0f, 0f),
                        blurRadius = 0f
                    )
                )
            )

            Text(
                text = value,
                textAlign = TextAlign.Center,
                maxLines = 1,
                style = TextStyle(
                    color = valueColor.copy(
                        alpha = 1f
                    ),
                    fontWeight = FontWeight.Bold,
                    fontSize = valueTextSize.sp,
                    shadow = if (hasDropShadow) shadow else Shadow(
                        color = Color.Transparent,
                        offset = Offset(0f, 0f),
                        blurRadius = 0f
                    )
                )
            )
        }
    }

}