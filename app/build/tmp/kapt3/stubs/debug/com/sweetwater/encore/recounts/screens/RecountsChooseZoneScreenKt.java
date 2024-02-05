package com.sweetwater.encore.recounts.screens;

import androidx.compose.animation.ExperimentalAnimationApi;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.tooling.preview.Preview;
import com.sweetwater.encore.R;
import com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats;
import com.sweetwater.encore.recounts.data.dto.RecountsZone;
import com.sweetwater.encore.recounts.state.RecountsChooseZoneState;
import com.sweetwater.encore.recounts.viewmodels.RecountsChooseZoneViewModel;
import com.sweetwater.encore.ui.theme.AppTheme;
import java.text.NumberFormat;
import java.util.Locale;

@kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalAnimationApi.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a`\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u000726\u0010\b\u001a2\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a`\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000726\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\b\u0010\u0015\u001a\u00020\u0001H\u0007\u001a*\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0007\u00a8\u0006\u001a"}, d2 = {"RecountsChooseZoneContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "recountsChooseZoneState", "Lcom/sweetwater/encore/recounts/state/RecountsChooseZoneState;", "onErrorEvent", "Lkotlin/Function0;", "onZoneClicked", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "zoneId", "", "zoneName", "RecountsChooseZoneScreen", "viewModel", "Lcom/sweetwater/encore/recounts/viewmodels/RecountsChooseZoneViewModel;", "onBackEvent", "onNavigateToScanProduct", "RecountsChooseZoneStatePreview", "RecountsTopStats", "locationsCount", "itemsCount", "dollars", "app_debug"})
public final class RecountsChooseZoneScreenKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void RecountsChooseZoneStatePreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RecountsChooseZoneScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.recounts.viewmodels.RecountsChooseZoneViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackEvent, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> onNavigateToScanProduct) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RecountsChooseZoneContent(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.recounts.state.RecountsChooseZoneState recountsChooseZoneState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onErrorEvent, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> onZoneClicked) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RecountsTopStats(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    java.lang.String locationsCount, @org.jetbrains.annotations.NotNull
    java.lang.String itemsCount, @org.jetbrains.annotations.NotNull
    java.lang.String dollars) {
    }
}