@file:OptIn(ExperimentalAnimationApi::class)

package com.sweetwater.encore.core_components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sweetwater.encore.R
import com.sweetwater.encore.ui.theme.AppTheme

@Preview
@Composable
private fun CustomErrorSnackBarViewPreview() {
    CustomErrorSnackBarView(
        errorMessage = "Error. Something went wrong. Please add more at least few more products to the list.",
        hasAction = true,
        actionText = "Got it"
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CustomErrorSnackBarView(
    modifier: Modifier = Modifier,
    errorMessage: String,
    hasAction: Boolean = false,
    actionText: String = "",
    backgroundColor: Color = Color.Red,
    actionTextAction: () -> Unit = {}
) {
    AnimatedContent(
        modifier = modifier.padding(top = 2.dp),
        targetState = errorMessage.isNotEmpty(),
        transitionSpec = {
            slideInVertically(
                animationSpec = tween(1500, easing = LinearOutSlowInEasing)
            ) with slideOutHorizontally()
        },
        label = "${stringResource(id = R.string.core_components_snackbar_animation_with_hasaction_inline_label)} $hasAction"
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(
                    backgroundColor.copy(alpha = 0.5f)
                )
        ) {
            Column(
                modifier = modifier
                    .border(
                        border = BorderStroke(2.dp, color = Color.LightGray),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clip(RoundedCornerShape(12.dp))
            ) {
                BasicTextLabel(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
                    fontSize = AppTheme.typo.textSize_12.value.toInt(),
                    textColor = Color.White.copy(
                        alpha = 0.8f
                    ),
                    textAlign = TextAlign.Start,
                    maxLines = 10,
                    fontWeight = FontWeight.Normal,
                    text = errorMessage
                )

                if (hasAction) {
                    Box(
                        modifier = modifier
                            .align(Alignment.End)
                            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                            .clickable(onClick = {
                                actionTextAction()
                            })
                    ) {
                        BasicTextLabel(modifier = Modifier.padding(
                            start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp
                        ),
                            fontSize = AppTheme.typo.textSize_12.value.toInt(),
                            textColor = Color.White.copy(
                                alpha = 0.8f
                            ),
                            fontWeight = FontWeight.ExtraBold,
                            text = actionText,
                            onLabelTapped = {
                                actionTextAction()
                            })
                    }
                }
            }
        }
    }
}