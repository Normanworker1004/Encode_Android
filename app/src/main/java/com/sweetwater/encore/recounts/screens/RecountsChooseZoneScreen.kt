@file:OptIn(ExperimentalAnimationApi::class)

package com.sweetwater.encore.recounts.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sweetwater.encore.R
import com.sweetwater.encore.core_components.CustomErrorSnackBarView
import com.sweetwater.encore.core_components.GridItemSpan
import com.sweetwater.encore.core_components.RecountsZoneSelectionKey
import com.sweetwater.encore.core_components.RecountsZoneSelectionSpan
import com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats
import com.sweetwater.encore.recounts.data.dto.RecountsZone
import com.sweetwater.encore.recounts.state.RecountsChooseZoneState
import com.sweetwater.encore.recounts.viewmodels.RecountsChooseZoneViewModel
import com.sweetwater.encore.ui.theme.AppTheme
import kotlinx.coroutines.delay
import java.text.NumberFormat
import java.util.Locale

@Preview
@Composable
fun RecountsChooseZoneStatePreview() {
    RecountsChooseZoneContent(
        recountsChooseZoneState = RecountsChooseZoneState(
            isLoading = false,
            zones = listOf(
                RecountsZone(1, "Pickmod 1 West", 2, 1),
                RecountsZone(1, "Pickmod 2 East", 12, 2),
                RecountsZone(1, "Noncon", 5, 7),
            ),
            error = stringResource(id = R.string.recounts_choose_zone_error),
            displayStats = RecountsDisplayStats(
                locationsWithVariances = 162,
                totalVariances = 182,
                totalVarianceInDollars = 12351.62
            ),
        ),
        onErrorEvent = {},
        onZoneClicked = { _, _ -> }
    )
}

@Composable
fun RecountsChooseZoneScreen(
    modifier: Modifier = Modifier,
    viewModel: RecountsChooseZoneViewModel,
    onBackEvent: () -> Unit,
    onNavigateToScanProduct: (zoneId: Int, zoneName: String) -> Unit
) {
    BackHandler {
        onBackEvent()
    }

    LaunchedEffect(key1 = true) {
        viewModel.onLaunch()
    }

    RecountsChooseZoneContent(
        modifier = modifier,
        recountsChooseZoneState = viewModel.recountsChooseZoneState.value,
        onErrorEvent = {
            viewModel.clearError()
            onBackEvent()
        },
        onZoneClicked = { zoneId, zoneName ->
            onNavigateToScanProduct(zoneId, zoneName)
        }
    )
}

@Composable
fun RecountsChooseZoneContent(
    modifier: Modifier = Modifier,
    recountsChooseZoneState: RecountsChooseZoneState,
    onErrorEvent: () -> Unit,
    onZoneClicked: (zoneId: Int, zoneName: String) -> Unit
) {
    if (recountsChooseZoneState.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = modifier
                    .padding(top = 18.dp)
                    .align(Alignment.Center),
                color = Color.White,
                strokeWidth = 4.dp,
            )
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (recountsChooseZoneState.error.isNotEmpty()) {
            CustomErrorSnackBarView(
                errorMessage = recountsChooseZoneState.error
            )

            LaunchedEffect(key1 = true) {
                delay(2500)
                onErrorEvent()
            }
        }

        val dailyStatistics = recountsChooseZoneState.displayStats
        RecountsTopStats(
            locationsCount = dailyStatistics.locationsWithVariances.toString(),
            itemsCount = dailyStatistics.totalVariances.toString(),
            dollars = NumberFormat.getNumberInstance(Locale.US)
                .format(dailyStatistics.totalVarianceInDollars.toInt()),
        )

        Spacer(modifier = Modifier.height(4.dp))

        RecountsZoneSelectionKey()

        LazyVerticalGrid(
            modifier = modifier
                .padding(12.dp),
            columns = GridCells.Fixed(1),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            items(
                items = recountsChooseZoneState.zones,
            ) { zone ->
                RecountsZoneSelectionSpan(
                    hasBorderStroke = true,
                    borderStroke = BorderStroke(
                        width = 1.dp,
                        color = Color.White.copy(
                            alpha = .5f
                        )
                    ),
                    hasBackground = true,
                    backgroundColor = Color.Black.copy(
                        alpha = .4f
                    ),
                    zone = zone.zoneName,
                    highPriorityCounts = zone.highPriorityLocationsCount,
                    lowPriorityCounts = zone.lowPriorityLocationsCount,
                    valueColor = Color.White.copy(alpha = .5f),
                    textSize = AppTheme.typo.textSize_12.value.toInt(),
                    onItemClicked = {
                        onZoneClicked(zone.zoneId, zone.zoneName)
                    }
                )
            }
        }
    }

}

@Composable
fun RecountsTopStats(
    modifier: Modifier = Modifier,
    locationsCount: String,
    itemsCount: String,
    dollars: String
) {
    Row(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        GridItemSpan(
            hasBorderStroke = false,
            label = stringResource(id = R.string.recounts_locations_label),
            value = locationsCount,
            valueTextSize = AppTheme.typo.textSize_18.value.toInt(),
            labelTextSize = AppTheme.typo.textSize_11.value.toInt(),
            onItemClicked = {}
        )

        GridItemSpan(
            hasBorderStroke = false,
            label = stringResource(id = R.string.recounts_items_label),
            value = itemsCount,
            valueTextSize = AppTheme.typo.textSize_18.value.toInt(),
            labelTextSize = AppTheme.typo.textSize_11.value.toInt(),
            onItemClicked = {}
        )

        GridItemSpan(
            hasBorderStroke = false,
            label = stringResource(id = R.string.recounts_dollars_label),
            value = "$$dollars",
            valueTextSize = AppTheme.typo.textSize_18.value.toInt(),
            labelTextSize = AppTheme.typo.textSize_11.value.toInt(),
            onItemClicked = {}
        )
    }
}