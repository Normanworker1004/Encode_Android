package com.sweetwater.encore.cycle_counts.screens;

import androidx.compose.animation.ExperimentalAnimationApi;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.tooling.preview.Preview;
import com.sweetwater.encore.R;
import com.sweetwater.encore.cycle_counts.state.CycleCountScanLocationState;
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanLocationViewModel;
import com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse;
import com.sweetwater.encore.external_api.inventory.dto.response.CycleCountLocation;

@kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalAnimationApi.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0094\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\n2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\n2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013H\u0007\u001a\b\u0010\u0015\u001a\u00020\u0001H\u0007\u001aB\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013H\u0007\u00a8\u0006\u001a"}, d2 = {"CycleCountScanLocationContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lcom/sweetwater/encore/cycle_counts/state/CycleCountScanLocationState;", "onBackEvent", "Lkotlin/Function0;", "onErrorClear", "onKeyboardConfirm", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "input", "onKeyboardToggle", "", "isToggled", "onLocationMatch", "Lkotlin/Function2;", "", "CycleCountScanLocationContentPreview", "CycleCountScanLocationScreen", "viewModel", "Lcom/sweetwater/encore/cycle_counts/viewmodels/CycleCountScanLocationViewModel;", "onNavigateToCycleCountScanUpcs", "app_debug"})
public final class CycleCountScanLocationScreenKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void CycleCountScanLocationContentPreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CycleCountScanLocationScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanLocationViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackEvent, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> onNavigateToCycleCountScanUpcs) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CycleCountScanLocationContent(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.cycle_counts.state.CycleCountScanLocationState state, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackEvent, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onErrorClear, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onKeyboardConfirm, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onKeyboardToggle, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> onLocationMatch) {
    }
}