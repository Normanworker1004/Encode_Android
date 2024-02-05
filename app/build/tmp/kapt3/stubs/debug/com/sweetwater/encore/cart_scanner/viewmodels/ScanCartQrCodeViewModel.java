package com.sweetwater.encore.cart_scanner.viewmodels;

import android.content.Context;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.R;
import com.sweetwater.encore.cart_scanner.state.ScanCartQrCodeState;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService;
import com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineDispatcher;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u0019R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/sweetwater/encore/cart_scanner/viewmodels/ScanCartQrCodeViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "cartScannerService", "Lcom/sweetwater/encore/dependency_injection/cart_scanner/ICartScannerService;", "barcodeScanner", "Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;", "connectivityService", "Lcom/sweetwater/encore/dependency_injection/connectivity/IConnectivityService;", "soundService", "Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;", "vibratorService", "Lcom/sweetwater/encore/dependency_injection/vibrator/IVibratorService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/sweetwater/encore/dependency_injection/cart_scanner/ICartScannerService;Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;Lcom/sweetwater/encore/dependency_injection/connectivity/IConnectivityService;Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;Lcom/sweetwater/encore/dependency_injection/vibrator/IVibratorService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_scanCartQrCodeState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/cart_scanner/state/ScanCartQrCodeState;", "scanCartQrCodeState", "Landroidx/compose/runtime/State;", "getScanCartQrCodeState", "()Landroidx/compose/runtime/State;", "clearError", "", "handleScanCartQrCodeScan", "cartIdentifier", "", "onBack", "onNavigatedTo", "app_debug"})
public final class ScanCartQrCodeViewModel extends androidx.lifecycle.ViewModel {
    private final android.content.Context context = null;
    private final com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService cartScannerService = null;
    private final com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner = null;
    private final com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService connectivityService = null;
    private final com.sweetwater.encore.dependency_injection.sound.ISoundService soundService = null;
    private final com.sweetwater.encore.dependency_injection.vibrator.IVibratorService vibratorService = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private final androidx.compose.runtime.MutableState<com.sweetwater.encore.cart_scanner.state.ScanCartQrCodeState> _scanCartQrCodeState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.cart_scanner.state.ScanCartQrCodeState> scanCartQrCodeState = null;
    
    @javax.inject.Inject
    public ScanCartQrCodeViewModel(@org.jetbrains.annotations.NotNull
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
    public final androidx.compose.runtime.State<com.sweetwater.encore.cart_scanner.state.ScanCartQrCodeState> getScanCartQrCodeState() {
        return null;
    }
    
    public final void onNavigatedTo() {
    }
    
    public final void onBack() {
    }
    
    public final void clearError() {
    }
    
    private final void handleScanCartQrCodeScan(java.lang.String cartIdentifier) {
    }
}