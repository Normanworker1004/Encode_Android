package com.sweetwater.encore.cart_scanner.viewmodels;

import android.content.Context;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.R;
import com.sweetwater.encore.cart_scanner.state.CartScannerState;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService;
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError;
import com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService;
import com.sweetwater.encore.utilities.IKeyboardInputViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineDispatcher;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B?\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001aJ\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0016J\u0006\u0010$\u001a\u00020\u001aR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/sweetwater/encore/cart_scanner/viewmodels/CartScannerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/sweetwater/encore/utilities/IKeyboardInputViewModel;", "context", "Landroid/content/Context;", "cartScannerService", "Lcom/sweetwater/encore/dependency_injection/cart_scanner/ICartScannerService;", "barcodeScanner", "Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;", "connectivityService", "Lcom/sweetwater/encore/dependency_injection/connectivity/IConnectivityService;", "soundService", "Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;", "vibratorService", "Lcom/sweetwater/encore/dependency_injection/vibrator/IVibratorService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/sweetwater/encore/dependency_injection/cart_scanner/ICartScannerService;Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;Lcom/sweetwater/encore/dependency_injection/connectivity/IConnectivityService;Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;Lcom/sweetwater/encore/dependency_injection/vibrator/IVibratorService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_cartScannerState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/cart_scanner/state/CartScannerState;", "cartScannerState", "Landroidx/compose/runtime/State;", "getCartScannerState", "()Landroidx/compose/runtime/State;", "clearError", "", "handleBarcodeScan", "scannedBarcode", "", "onBack", "onConfirmKeyboard", "text", "onKeyboardToggled", "isToggled", "", "onNavigatedTo", "app_debug"})
public final class CartScannerViewModel extends androidx.lifecycle.ViewModel implements com.sweetwater.encore.utilities.IKeyboardInputViewModel {
    private final android.content.Context context = null;
    private final com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService cartScannerService = null;
    private final com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner = null;
    private final com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService connectivityService = null;
    private final com.sweetwater.encore.dependency_injection.sound.ISoundService soundService = null;
    private final com.sweetwater.encore.dependency_injection.vibrator.IVibratorService vibratorService = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private final androidx.compose.runtime.MutableState<com.sweetwater.encore.cart_scanner.state.CartScannerState> _cartScannerState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.cart_scanner.state.CartScannerState> cartScannerState = null;
    
    @javax.inject.Inject
    public CartScannerViewModel(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService cartScannerService, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService connectivityService, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.sound.ISoundService soundService, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.vibrator.IVibratorService vibratorService, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.cart_scanner.state.CartScannerState> getCartScannerState() {
        return null;
    }
    
    @java.lang.Override
    public void onKeyboardToggled(boolean isToggled) {
    }
    
    @java.lang.Override
    public void onConfirmKeyboard(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    public final void onNavigatedTo() {
    }
    
    public final void onBack() {
    }
    
    public final void clearError() {
    }
    
    private final void handleBarcodeScan(java.lang.String scannedBarcode) {
    }
}