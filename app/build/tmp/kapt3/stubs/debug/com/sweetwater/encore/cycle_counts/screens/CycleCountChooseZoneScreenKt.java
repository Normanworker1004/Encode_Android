package com.sweetwater.encore.cycle_counts.screens;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.tooling.preview.Preview;
import com.sweetwater.encore.R;
import com.sweetwater.encore.cycle_counts.state.CycleCountChooseZoneState;
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountChooseZoneViewModel;
import com.sweetwater.encore.external_api.inventory.dto.CycleCountDisplayStats;
import com.sweetwater.encore.external_api.inventory.dto.CycleCountZone;
import com.sweetwater.encore.external_api.inventory.dto.response.DetailsForCurrentQuarterResponse;
import com.sweetwater.encore.ui.theme.AppTheme;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aY\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\b\u0010\u000f\u001a\u00020\u0001H\u0007\u001a>\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a*\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0007\u00a8\u0006\u001a"}, d2 = {"CycleCountChooseZoneContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "cycleCountChooseZoneState", "Lcom/sweetwater/encore/cycle_counts/state/CycleCountChooseZoneState;", "onBackEvent", "Lkotlin/Function0;", "onErrorEvent", "onZoneClickedEvent", "Lkotlin/Function1;", "Lcom/sweetwater/encore/external_api/inventory/dto/CycleCountZone;", "Lkotlin/ParameterName;", "name", "zone", "CycleCountChooseZoneContentPreview", "CycleCountChooseZoneScreen", "viewModel", "Lcom/sweetwater/encore/cycle_counts/viewmodels/CycleCountChooseZoneViewModel;", "onNavigateToScanLocation", "", "CycleCountTopStats", "locationsCount", "", "itemsCount", "qProgress", "app_debug"})
public final class CycleCountChooseZoneScreenKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void CycleCountChooseZoneContentPreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CycleCountChooseZoneScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.cycle_counts.viewmodels.CycleCountChooseZoneViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onNavigateToScanLocation, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackEvent) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CycleCountChooseZoneContent(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.cycle_counts.state.CycleCountChooseZoneState cycleCountChooseZoneState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackEvent, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onErrorEvent, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.external_api.inventory.dto.CycleCountZone, kotlin.Unit> onZoneClickedEvent) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CycleCountTopStats(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    java.lang.String locationsCount, @org.jetbrains.annotations.NotNull
    java.lang.String itemsCount, @org.jetbrains.annotations.NotNull
    java.lang.String qProgress) {
    }
}