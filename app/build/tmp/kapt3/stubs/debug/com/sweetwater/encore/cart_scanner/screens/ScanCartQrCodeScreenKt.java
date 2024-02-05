package com.sweetwater.encore.cart_scanner.screens;

import androidx.compose.animation.ExperimentalAnimationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.tooling.preview.Preview;
import com.sweetwater.encore.R;
import com.sweetwater.encore.cart_scanner.state.ScanCartQrCodeState;
import com.sweetwater.encore.cart_scanner.viewmodels.ScanCartQrCodeViewModel;

@kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalAnimationApi.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\b\u0010\b\u001a\u00020\u0001H\u0007\u001a8\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u00a8\u0006\u000e"}, d2 = {"ScanCartQrCodeContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "scanCartQrCodeState", "Lcom/sweetwater/encore/cart_scanner/state/ScanCartQrCodeState;", "onClearError", "Lkotlin/Function0;", "ScanCartQrCodePreview", "ScanCartQrCodeScreen", "viewModel", "Lcom/sweetwater/encore/cart_scanner/viewmodels/ScanCartQrCodeViewModel;", "onBack", "onCartRegistered", "app_debug"})
public final class ScanCartQrCodeScreenKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void ScanCartQrCodePreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ScanCartQrCodeScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.cart_scanner.viewmodels.ScanCartQrCodeViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onCartRegistered) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ScanCartQrCodeContent(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.cart_scanner.state.ScanCartQrCodeState scanCartQrCodeState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClearError) {
    }
}