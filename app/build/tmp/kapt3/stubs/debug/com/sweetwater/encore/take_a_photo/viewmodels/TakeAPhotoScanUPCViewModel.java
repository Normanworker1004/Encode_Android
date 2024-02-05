package com.sweetwater.encore.take_a_photo.viewmodels;

import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.utilities.IKeyboardInputViewModel;
import com.sweetwater.encore.take_a_photo.state.TakeAPhotoScanUPCState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/sweetwater/encore/take_a_photo/viewmodels/TakeAPhotoScanUPCViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/sweetwater/encore/utilities/IKeyboardInputViewModel;", "barcodeScanner", "Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;", "(Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;)V", "_takeAPhotoScanUPCState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/take_a_photo/state/TakeAPhotoScanUPCState;", "takeAPhotoScanUPCState", "Landroidx/compose/runtime/State;", "getTakeAPhotoScanUPCState", "()Landroidx/compose/runtime/State;", "clearError", "", "clearTag", "handleBarcodeScan", "scannedBarcode", "", "onConfirmKeyboard", "text", "onKeyboardToggled", "isToggled", "", "onNavigatedTo", "app_debug"})
public final class TakeAPhotoScanUPCViewModel extends androidx.lifecycle.ViewModel implements com.sweetwater.encore.utilities.IKeyboardInputViewModel {
    private final com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner = null;
    private final androidx.compose.runtime.MutableState<com.sweetwater.encore.take_a_photo.state.TakeAPhotoScanUPCState> _takeAPhotoScanUPCState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.take_a_photo.state.TakeAPhotoScanUPCState> takeAPhotoScanUPCState = null;
    
    @javax.inject.Inject
    public TakeAPhotoScanUPCViewModel(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.take_a_photo.state.TakeAPhotoScanUPCState> getTakeAPhotoScanUPCState() {
        return null;
    }
    
    @java.lang.Override
    public void onKeyboardToggled(boolean isToggled) {
    }
    
    @java.lang.Override
    public void onConfirmKeyboard(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    public final void clearTag() {
    }
    
    public final void onNavigatedTo() {
    }
    
    public final void clearError() {
    }
    
    private final void handleBarcodeScan(java.lang.String scannedBarcode) {
    }
}