package com.sweetwater.encore.core_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sweetwater.encore.R

@Preview()
@Composable
private fun ProductItemViewPreview() {
    ProductTile(
        name = "Ui16",
        imageUrl = "https://www.sweetwater.com/images/items/120/SM57-medium.jpg",
        productManufacturer = "Soundcraft",
        shortDescription = "16-ch Ui Series Rkmt Digital Mixer",
        isSerialNumberRequired = true,
        serialNumber = "HJ19539069789",
        productQuantity = 27,
        isVarianceDetected = false,
        onProductItemClicked = { _, _, _ -> },
        priority = null
    )
}

@Composable
fun ProductTile(
    modifier: Modifier = Modifier,
    name: String,
    imageUrl: String,
    productManufacturer: String,
    shortDescription: String,
    isSerialNumberRequired: Boolean = false,
    isVarianceDetected: Boolean = false,
    hasBorderStroke: Boolean = true,
    hasBackground: Boolean = true,
    serialNumber: String?,
    productQuantity: Int? = null,
    priority: Int? = null,
    productBoxesCount: Int = 0,
    onProductItemClicked: (name: String, serialNumber: String?, requiresSerialNumber: Boolean) -> Unit
) {
    val productInfoItemBackground =
        (if (isVarianceDetected) Color.Red else if (isSerialNumberRequired && serialNumber.isNullOrEmpty()) Color.Yellow else Color.Black).copy(
            alpha = 0.5f
        )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(5.dp)
            .clip(shape = RoundedCornerShape(6.dp))
            .background(
                color = if (hasBackground) productInfoItemBackground else Color.Transparent,
                shape = RoundedCornerShape(6.dp)
            )
            .border(
                border = if (hasBorderStroke) BorderStroke(
                    1.dp,
                    color = Color.Gray
                ) else BorderStroke(
                    width = 0.dp,
                    color = Color.Transparent
                ), shape = RoundedCornerShape(6.dp)
            )
    ) {

        Row(
            modifier = modifier
                .padding(8.dp)
                .fillMaxHeight(),
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = modifier.background(
                    color = Color.White, shape = RoundedCornerShape(6.dp)
                ),
                contentAlignment = BottomEnd
            ) {
                AsyncProductImage(
                    modifier = Modifier
                        .height(80.dp)
                        .padding(8.dp)
                        .aspectRatio(1f),
                    imageData = imageUrl
                ) { }
                if (productBoxesCount > 1) {
                    Box(
                        modifier = modifier.size(32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(Color.Green),
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .align(Alignment.Center)

                        )
                        Text(
                            text = productBoxesCount.toString(),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }

            Column(
                modifier = modifier.fillMaxWidth(.75f)
            ) {
                BasicText(
                    modifier = modifier.padding(horizontal = 8.dp),
                    text = name,
                    style = TextStyle(
                        color = Color.White.copy(
                            alpha = 1f
                        ), fontWeight = FontWeight.Bold, fontSize = 25.sp, shadow = Shadow(
                            color = Color.Black, offset = Offset(2.0f, 2.0f), blurRadius = 3f
                        )
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                BasicText(
                    modifier = modifier.padding(horizontal = 8.dp),
                    text = "$productManufacturer $shortDescription",
                    style = TextStyle(
                        color = Color.White.copy(
                            alpha = 1f
                        ), fontWeight = FontWeight.Normal, fontSize = 14.sp, shadow = Shadow(
                            color = Color.Black, offset = Offset(2.0f, 2.0f), blurRadius = 3f
                        )
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                BasicText(
                    modifier = modifier.padding(horizontal = 8.dp),
                    text = serialNumber ?: "",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color.Yellow,
                        shadow = Shadow(
                            color = Color.Black, offset = Offset(2.0f, 2.0f), blurRadius = 3f
                        )
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            if (productQuantity != null) {
                BasicTextLabel(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(CenterVertically),
                    text = productQuantity.toString(),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                    textColor = Color.White,
                    fontSize = 35,
                )
            } else if (priority != null) {
                PriorityIndicator(modifier, size = 32, priority)
            }
        }

        Box(modifier = modifier
            .fillMaxSize()
            .clickable {
                onProductItemClicked(name, serialNumber, isSerialNumberRequired)
            })
    }
}