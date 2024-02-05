package com.sweetwater.encore.take_a_photo.viewmodels;

import android.content.Context;
import android.net.Uri;
import androidx.compose.runtime.State;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.external_api.gds.repository.GDSRepository;
import com.sweetwater.encore.take_a_photo.state.TakeAPhotoCaptureState;
import com.sweetwater.encore.utilities.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineDispatcher;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0014H\u0002J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020#J\u0006\u0010\'\u001a\u00020#J\u0011\u0010(\u001a\u00020#H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0014J\u000e\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\u0014J\u0006\u00101\u001a\u00020#J\u0006\u00102\u001a\u00020#J\u0011\u00103\u001a\u00020#H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J\u0006\u00104\u001a\u00020#R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/sweetwater/encore/take_a_photo/viewmodels/TakeAPhotoCaptureViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "gdsRepository", "Lcom/sweetwater/encore/external_api/gds/repository/GDSRepository;", "getEmployeeLoginDetailsUseCase", "Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;", "soundService", "Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;", "barcodeScanner", "Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroid/content/Context;Lcom/sweetwater/encore/external_api/gds/repository/GDSRepository;Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/lifecycle/SavedStateHandle;)V", "_employeeId", "", "_employeeName", "", "_takeAPhotoCaptureState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/take_a_photo/state/TakeAPhotoCaptureState;", "employeeId", "getEmployeeId", "()I", "employeeName", "getEmployeeName", "()Ljava/lang/String;", "takeAPhotoCaptureState", "Landroidx/compose/runtime/State;", "getTakeAPhotoCaptureState", "()Landroidx/compose/runtime/State;", "barcodeScanned", "", "contents", "clearCapturedImage", "clearError", "clearPhotoDescription", "getUserData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleCaptureError", "newError", "handleImageCaptured", "uri", "Landroid/net/Uri;", "onInputTextChanged", "text", "onNavigatedTo", "showCameraFeatures", "uploadDataToGDS", "uploadToGDS", "app_debug"})
public final class TakeAPhotoCaptureViewModel extends androidx.lifecycle.ViewModel {
    private final android.content.Context context = null;
    private final com.sweetwater.encore.external_api.gds.repository.GDSRepository gdsRepository = null;
    private final com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase = null;
    private final com.sweetwater.encore.dependency_injection.sound.ISoundService soundService = null;
    private final com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private final androidx.compose.runtime.MutableState<com.sweetwater.encore.take_a_photo.state.TakeAPhotoCaptureState> _takeAPhotoCaptureState = null;
    private int _employeeId = 0;
    private java.lang.String _employeeName = "";
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.take_a_photo.state.TakeAPhotoCaptureState> takeAPhotoCaptureState = null;
    
    @javax.inject.Inject
    public TakeAPhotoCaptureViewModel(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.gds.repository.GDSRepository gdsRepository, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.sound.ISoundService soundService, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    public final int getEmployeeId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmployeeName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.take_a_photo.state.TakeAPhotoCaptureState> getTakeAPhotoCaptureState() {
        return null;
    }
    
    public final void onNavigatedTo() {
    }
    
    public final void showCameraFeatures() {
    }
    
    public final void onInputTextChanged(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    private final void barcodeScanned(java.lang.String contents) {
    }
    
    public final void handleImageCaptured(@org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
    }
    
    public final void handleCaptureError(@org.jetbrains.annotations.NotNull
    java.lang.String newError) {
    }
    
    public final void clearCapturedImage() {
    }
    
    public final void clearPhotoDescription() {
    }
    
    public final void clearError() {
    }
    
    public final void uploadToGDS() {
    }
    
    private final java.lang.Object getUserData(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object uploadDataToGDS(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}