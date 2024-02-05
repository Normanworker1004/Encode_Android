package com.sweetwater.encore.recounts.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.sweetwater.encore.R
import com.sweetwater.encore.core_components.FullScreenErrorScreen
import com.sweetwater.encore.recounts.viewmodels.RecountsCompleteViewModel
import kotlinx.coroutines.delay

@Preview
@Composable
fun RecountsCompletePreview() {
    RecountsCompleteContent(
        locationName = "NC-01-01-A-01",
        varianceReported = true,
    ) {}
}

@Composable
fun RecountsCompleteScreen(
    viewModel: RecountsCompleteViewModel,
    locationName: String,
    varianceReported: Boolean,
    onNavigateToScanLocation: (outOfLocations: Boolean) -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.onLaunch(locationName)
    }

    RecountsCompleteContent(
        locationName = locationName,
        varianceReported = varianceReported,
        onNavigateToScanLocation = { onNavigateToScanLocation(viewModel.outOfLocations) })
}

@Composable
fun RecountsCompleteContent(
    locationName: String,
    varianceReported: Boolean,
    onNavigateToScanLocation: () -> Unit
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        delay(250)
        visible = true
        delay(1250)
        visible = false
        delay(250)
        onNavigateToScanLocation()
    }

    val resourceId: Int = if (varianceReported) R.string.recounts_variance_confirmed_label
    else R.string.recounts_complete_top_bar_menu_label

    AnimatedVisibility(
        visible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        FullScreenErrorScreen(
            errorMessage = "",
            backgroundColor = (if (varianceReported) Color.Yellow else Color.Green).copy(alpha = 0.6f)
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            locationName,
            style = TextStyle(
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                shadow = Shadow(
                    color = Color.Black, offset = Offset(2.0f, 2.0f), blurRadius = 3f
                )
            ),
        )
        Text(
            stringResource(resourceId),
            style = TextStyle(
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                shadow = Shadow(
                    color = Color.Black, offset = Offset(2.0f, 2.0f), blurRadius = 3f
                )
            ),
        )
    }
}