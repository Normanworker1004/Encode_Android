package com.sweetwater.encore.dashboard.screens;

import androidx.compose.animation.ExperimentalAnimationApi;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.tooling.preview.Preview;
import com.sweetwater.encore.authorization.state.AppAuthState;
import com.sweetwater.encore.dashboard.DashboardUIEvent;
import com.sweetwater.encore.dashboard.SoundEvent;
import com.sweetwater.encore.dashboard.data.WorkflowIcon;
import com.sweetwater.encore.dashboard.state.DashboardState;
import com.sweetwater.encore.ui.theme.AppTheme;

@kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalAnimationApi.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0080\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\b\u0010\u0010\u001a\u00020\u0001H\u0007\u001ar\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a?\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162#\b\u0002\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001at\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u00a8\u0006\u001c"}, d2 = {"DashboardUI", "", "dashboardUiState", "Lcom/sweetwater/encore/dashboard/state/DashboardState;", "dashboardUIEvent", "Lkotlin/Function1;", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent;", "appAuthState", "Lcom/sweetwater/encore/authorization/state/AppAuthState;", "onClickedProductRecounts", "Lkotlin/Function0;", "onClickedPickModScanner", "onClickedTakeAPhoto", "onClickedCycleCounts", "onClickedBoxAudit", "onLoggedOut", "DashboardUIPreview", "LandingScreen", "WorkflowIconItem", "modifier", "Landroidx/compose/ui/Modifier;", "workflowIcon", "Lcom/sweetwater/encore/dashboard/data/WorkflowIcon;", "onItemClick", "Lkotlin/ParameterName;", "name", "WorkflowIcons", "dashboardState", "app_debug"})
public final class DashboardScreenKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    @kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalAnimationApi.class})
    public static final void DashboardUIPreview() {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.animation.ExperimentalAnimationApi
    public static final void DashboardUI(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dashboard.state.DashboardState dashboardUiState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.dashboard.DashboardUIEvent, kotlin.Unit> dashboardUIEvent, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.state.AppAuthState appAuthState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedProductRecounts, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedPickModScanner, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedTakeAPhoto, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedCycleCounts, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedBoxAudit, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onLoggedOut) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalAnimationApi.class})
    public static final void LandingScreen(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dashboard.state.DashboardState dashboardUiState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.dashboard.DashboardUIEvent, kotlin.Unit> dashboardUIEvent, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.state.AppAuthState appAuthState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedProductRecounts, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedPickModScanner, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedTakeAPhoto, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedCycleCounts, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedBoxAudit) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void WorkflowIcons(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dashboard.state.DashboardState dashboardState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.dashboard.DashboardUIEvent, kotlin.Unit> dashboardUIEvent, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedProductRecounts, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedPickModScanner, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedTakeAPhoto, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedCycleCounts, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClickedBoxAudit) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void WorkflowIconItem(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dashboard.data.WorkflowIcon workflowIcon, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.dashboard.data.WorkflowIcon, kotlin.Unit> onItemClick) {
    }
}