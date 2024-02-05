package com.sweetwater.encore.box_audit.viewmodels;

import android.content.Context;
import android.util.Log;
import androidx.compose.runtime.State;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.box_audit.BoxAuditUIEvent;
import com.sweetwater.encore.box_audit.state.BoxAuditScanTrackingState;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository;
import com.sweetwater.encore.utilities.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineDispatcher;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0011\u0010\u001d\u001a\u00020\u001eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u0019\u0010 \u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\'J\u0006\u0010(\u001a\u00020\u001eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/sweetwater/encore/box_audit/viewmodels/BoxAuditScanTrackingViewModel;", "Landroidx/lifecycle/ViewModel;", "getEmployeeLoginDetailsUseCase", "Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;", "boxAuditRepository", "Lcom/sweetwater/encore/external_api/boxaudit/repository/interfaces/IBoxAuditRepository;", "barcodeScanner", "Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;", "soundService", "Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "context", "Landroid/content/Context;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;Lcom/sweetwater/encore/external_api/boxaudit/repository/interfaces/IBoxAuditRepository;Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;Lkotlinx/coroutines/CoroutineDispatcher;Landroid/content/Context;Landroidx/lifecycle/SavedStateHandle;)V", "_boxAuditScanTrackingState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/box_audit/state/BoxAuditScanTrackingState;", "_campusId", "", "boxAuditScanTrackingState", "Landroidx/compose/runtime/State;", "getBoxAuditScanTrackingState", "()Landroidx/compose/runtime/State;", "campusId", "getCampusId", "()Ljava/lang/String;", "displayFullScreenError", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserData", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleBarcodeScanned", "text", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onEvent", "event", "Lcom/sweetwater/encore/box_audit/BoxAuditUIEvent;", "onNavigatedTo", "app_debug"})
public final class BoxAuditScanTrackingViewModel extends androidx.lifecycle.ViewModel {
    private final com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase = null;
    private final com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository boxAuditRepository = null;
    private final com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner = null;
    private final com.sweetwater.encore.dependency_injection.sound.ISoundService soundService = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private androidx.compose.runtime.MutableState<com.sweetwater.encore.box_audit.state.BoxAuditScanTrackingState> _boxAuditScanTrackingState;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.box_audit.state.BoxAuditScanTrackingState> boxAuditScanTrackingState = null;
    private java.lang.String _campusId = "";
    
    @javax.inject.Inject
    public BoxAuditScanTrackingViewModel(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository boxAuditRepository, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.sound.ISoundService soundService, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.box_audit.state.BoxAuditScanTrackingState> getBoxAuditScanTrackingState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCampusId() {
        return null;
    }
    
    public final void onNavigatedTo() {
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.box_audit.BoxAuditUIEvent event) {
    }
    
    private final java.lang.Object handleBarcodeScanned(java.lang.String text, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object getUserData(android.content.Context context, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object displayFullScreenError(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}