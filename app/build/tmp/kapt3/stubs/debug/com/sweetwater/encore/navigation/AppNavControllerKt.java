package com.sweetwater.encore.navigation;

import android.annotation.SuppressLint;
import androidx.compose.animation.ExperimentalAnimationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.layout.ContentScale;
import androidx.navigation.NavHostController;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.AppAuthEvent;
import com.sweetwater.encore.authorization.data.AppLoginStatusStorage;
import com.sweetwater.encore.authorization.data.model.logout.request.LogoutRequest;
import com.sweetwater.encore.authorization.viewmodels.AppAuthViewModel;
import com.sweetwater.encore.authorization.viewmodels.LoginViewModel;
import com.sweetwater.encore.box_audit.viewmodels.BoxAuditScanTrackingViewModel;
import com.sweetwater.encore.cart_scanner.viewmodels.CartScannerViewModel;
import com.sweetwater.encore.cart_scanner.viewmodels.ScanCartQrCodeViewModel;
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountChooseZoneViewModel;
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanLocationViewModel;
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanUpcsViewModel;
import com.sweetwater.encore.dashboard.DashboardUIEvent;
import com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarEvent;
import com.sweetwater.encore.dashboard.viewmodels.DashboardViewModel;
import com.sweetwater.encore.recounts.viewmodels.RecountsChooseZoneViewModel;
import com.sweetwater.encore.recounts.viewmodels.RecountsCompleteViewModel;
import com.sweetwater.encore.recounts.viewmodels.RecountsScanLocationViewModel;
import com.sweetwater.encore.recounts.viewmodels.RecountsScanProductViewModel;
import com.sweetwater.encore.recounts.viewmodels.RecountsScanUPCViewModel;
import com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoCaptureViewModel;
import com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoScanUPCViewModel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\f"}, d2 = {"AppNavController", "", "authLoginStatusStorage", "Lcom/sweetwater/encore/authorization/data/AppLoginStatusStorage;", "onExitApp", "Lkotlin/Function0;", "navController", "Landroidx/navigation/NavHostController;", "navigateSingleTopTo", "route", "", "navigateToMostRecentCopyOf", "app_debug"})
public final class AppNavControllerKt {
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalAnimationApi.class})
    @android.annotation.SuppressLint(value = {"UnusedMaterialScaffoldPaddingParameter"})
    public static final void AppNavController(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.data.AppLoginStatusStorage authLoginStatusStorage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onExitApp, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController navController) {
    }
    
    public static final void navigateSingleTopTo(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController $this$navigateSingleTopTo, @org.jetbrains.annotations.NotNull
    java.lang.String route) {
    }
    
    public static final void navigateToMostRecentCopyOf(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController $this$navigateToMostRecentCopyOf, @org.jetbrains.annotations.NotNull
    java.lang.String route) {
    }
}