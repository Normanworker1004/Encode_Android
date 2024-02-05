package com.sweetwater.encore.cycle_counts.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sweetwater.encore.R
import com.sweetwater.encore.cycle_counts.state.CycleCountChooseZoneState
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountChooseZoneViewModel
import com.sweetwater.encore.external_api.inventory.dto.CycleCountDisplayStats
import com.sweetwater.encore.external_api.inventory.dto.CycleCountZone
import com.sweetwater.encore.external_api.inventory.dto.response.DetailsForCurrentQuarterResponse
import com.sweetwater.encore.core_components.CustomErrorSnackBarView
import com.sweetwater.encore.core_components.GridItemSpan
import com.sweetwater.encore.ui.theme.AppTheme
import kotlinx.coroutines.delay
import java.math.RoundingMode
import java.text.DecimalFormat

@Preview
@Composable
fun CycleCountChooseZoneContentPreview() {
    CycleCountChooseZoneContent(
        cycleCountChooseZoneState = CycleCountChooseZoneState(
            detailsForCurrentQuarter = DetailsForCurrentQuarterResponse(
                displayStats = CycleCountDisplayStats(
                    locationsCountedToday = 15,
                    itemsCountedToday = 12,
                    zoneCountedPercentForQuarter = 16.4
                ),
                zones = listOf(
                    CycleCountZone(
                        countPriority = 1,
                        zoneName = "Mikeandroid",
                        zoneId = 1,
                        percentCounted = 15.2
                    ),
                    CycleCountZone(
                        countPriority = 0,
                        zoneName = "Blah Zone",
                        zoneId = 0,
                        percentCounted = 11.2
                    ),
                    CycleCountZone(
                        countPriority = 2,
                        zoneName = "Deez",
                        zoneId = 6,
                        percentCounted = 17.0
                    ),
                    CycleCountZone(
                        countPriority = 1,
                        zoneName = "Colts Stadium",
                        zoneId = 1,
                        percentCounted = 100.0
                    ),
                    CycleCountZone(
                        countPriority = 2,
                        zoneName = "Mike Richards Lawn",
                        zoneId = 1,
                        percentCounted = 0.0
                    )
                )
            ),
            isLoading = true
        ),
        onBackEvent = {},
        onErrorEvent = {},
        onZoneClickedEvent = {}
    )
}

@Composable
fun CycleCountChooseZoneScreen(
    modifier: Modifier = Modifier,
    viewModel: CycleCountChooseZoneViewModel = viewModel(),
    onNavigateToScanLocation: (Int) -> Unit,
    onBackEvent: () -> Unit,
) {
    CycleCountChooseZoneContent(
        modifier = modifier,
        cycleCountChooseZoneState = viewModel.cycleCountChooseZoneState.value,
        onBackEvent = {
            viewModel.clearError()
            onBackEvent()
        },
        onErrorEvent = {
            viewModel.clearError()
            onBackEvent()
        },
        onZoneClickedEvent = { zone ->
            onNavigateToScanLocation(zone.zoneId)
        },
    )
}

@Composable
fun CycleCountChooseZoneContent(
    modifier: Modifier = Modifier,
    cycleCountChooseZoneState: CycleCountChooseZoneState,
    onBackEvent: () -> Unit,
    onErrorEvent: () -> Unit,
    onZoneClickedEvent: (zone: CycleCountZone) -> Unit
) {
    BackHandler() {
        onBackEvent()
    }

    val detailsForCurrentQuarter = cycleCountChooseZoneState.detailsForCurrentQuarter
    val zones = detailsForCurrentQuarter.zones
    val displayStats = detailsForCurrentQuarter.displayStats
    val locationCount = displayStats.locationsCountedToday.toString()
    val itemsCount = displayStats.itemsCountedToday.toString()

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    val qProgress = df.format(displayStats.locationsCountedToday).toDouble().toString()

    Column(
        modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (cycleCountChooseZoneState.error.isNotEmpty()) {
            CustomErrorSnackBarView(
                errorMessage = cycleCountChooseZoneState.error
            )

            LaunchedEffect(key1 = true) {
                delay(2500)
                onErrorEvent()
            }
        }

        CycleCountTopStats(
            locationsCount = locationCount, itemsCount = itemsCount, qProgress = qProgress
        )

        if (cycleCountChooseZoneState.isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = modifier
                        .padding(top = 18.dp)
                        .align(Alignment.Center),
                    color = Color.White,
                    strokeWidth = 4.dp
                )
            }
        }

        LazyVerticalGrid(
            modifier = modifier.padding(6.dp),
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            items(
                items = zones.sortedBy { zone -> zone.percentCounted },
            ) { zone ->
                val countPriorityColor = when (zone.countPriority) {
                    0 -> Color.Red.toArgb()
                    2 -> Color.Green.toArgb()
                    else -> {
                        Color.White.toArgb()
                    }
                }

                GridItemSpan(modifier = Modifier
                    .aspectRatio(1f),
                    hasBorderStroke = true,
                    hasDropShadow = false,
                    borderStroke = BorderStroke(
                        width = 1.dp, color = Color.White.copy(
                            alpha = .5f
                        )
                    ),
                    hasBackground = true,
                    label = zone.zoneName.replace("Whs5", ""),
                    value = "${df.format(zone.percentCounted).toDouble()}%",
                    valueColor = Color(countPriorityColor),
                    valueTextSize = AppTheme.typo.textSize_14.value.toInt(),
                    labelTextSize = AppTheme.typo.textSize_14.value.toInt(),
                    onItemClicked = {
                        onZoneClickedEvent(zone)
                    })
            }
        }
    }
}

@Composable
fun CycleCountTopStats(
    modifier: Modifier = Modifier, locationsCount: String, itemsCount: String, qProgress: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for (label in listOf(
            R.string.cycle_count_locations_label,
            R.string.cycle_count_items_label,
            R.string.cycle_count_q_progress_label
        )) {
            GridItemSpan(modifier = Modifier.padding(4.dp),
                hasBorderStroke = false,
                hasBackground = false,
                label = stringResource(label),
                value = when (label) {
                    R.string.cycle_count_locations_label -> locationsCount
                    R.string.cycle_count_items_label -> itemsCount
                    else -> "${qProgress}%"
                },
                valueTextSize = AppTheme.typo.textSize_16.value.toInt(),
                labelTextSize = AppTheme.typo.textSize_10.value.toInt(),
                onItemClicked = {})
        }
    }
}