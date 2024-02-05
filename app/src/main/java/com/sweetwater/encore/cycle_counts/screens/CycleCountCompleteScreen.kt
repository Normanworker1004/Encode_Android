package com.sweetwater.encore.cycle_counts.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sweetwater.encore.R
import com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse
import com.sweetwater.encore.core_components.FullScreenErrorScreen
import kotlinx.coroutines.delay

@Preview
@Composable
fun CycleCountCompletePreview() {
    CycleCountCompleteContent(
        locationName = "NC-01-01-A-01",
        varianceReported = true,
    ) {}
}

@Composable
fun CycleCountCompleteScreen(
    locationsList: MutableList<AssignedLocationResponse>,
    locationName: String,
    varianceReported: Boolean,
    onNavigateToScanLocation: () -> Unit
) {
    LaunchedEffect(key1 = true) {
        locationsList.removeFirst()
    }

    CycleCountCompleteContent(
        locationName = locationName,
        varianceReported = varianceReported,
        onNavigateToScanLocation = onNavigateToScanLocation)
}
@Composable
fun CycleCountCompleteContent(
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

    val resourceId: Int = if (varianceReported) R.string.cycle_count_count_complete_variance_label
        else R.string.cycle_count_count_complete_success_label

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
    ) {
        Spacer(modifier = Modifier.height(48.dp))
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
        Spacer(modifier = Modifier.height(200.dp))
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