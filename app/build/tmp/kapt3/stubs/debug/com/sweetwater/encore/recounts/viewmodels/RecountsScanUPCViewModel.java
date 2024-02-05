package com.sweetwater.encore.recounts.viewmodels;

import android.content.Context;
import androidx.compose.runtime.State;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService;
import com.sweetwater.encore.external_api.inventory.dto.requests.UploadRecountRequest;
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository;
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository;
import com.sweetwater.encore.recounts.state.RecountsScanUPCState;
import com.sweetwater.encore.utilities.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineDispatcher;
import java.time.LocalDateTime;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001BO\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\u0006\u0010.\u001a\u00020/J\u0011\u00100\u001a\u00020/H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J\u0019\u00102\u001a\u00020/2\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00103J\u0010\u00104\u001a\u00020/2\u0006\u00105\u001a\u00020\u0016H\u0002J\u0019\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00108J\u000e\u00109\u001a\u00020/2\u0006\u00107\u001a\u00020\u0016J\u000e\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020\u001eJ\u0006\u0010<\u001a\u00020/J\u0006\u0010=\u001a\u00020/J\b\u0010>\u001a\u00020\u001eH\u0002J\u0011\u0010?\u001a\u00020/H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J\u0010\u0010@\u001a\u00020/2\u0006\u00107\u001a\u00020\u0016H\u0002R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b&\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001c0(\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006A"}, d2 = {"Lcom/sweetwater/encore/recounts/viewmodels/RecountsScanUPCViewModel;", "Landroidx/lifecycle/ViewModel;", "barcodeScanner", "Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;", "recountsDataRepository", "Lcom/sweetwater/encore/recounts/data/repository/interfaces/IRecountsRepository;", "soundService", "Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;", "vibratorService", "Lcom/sweetwater/encore/dependency_injection/vibrator/IVibratorService;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "inventoryRepository", "Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;", "getEmployeeLoginDetailsUseCase", "Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "context", "Landroid/content/Context;", "(Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;Lcom/sweetwater/encore/recounts/data/repository/interfaces/IRecountsRepository;Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;Lcom/sweetwater/encore/dependency_injection/vibrator/IVibratorService;Landroidx/lifecycle/SavedStateHandle;Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;Lkotlinx/coroutines/CoroutineDispatcher;Landroid/content/Context;)V", "_campusId", "", "_employeeId", "", "_locationName", "_recountsScanUPCState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/recounts/state/RecountsScanUPCState;", "_shouldForce", "", "campusId", "getCampusId", "()Ljava/lang/String;", "employeeId", "getEmployeeId", "()I", "locationName", "getLocationName", "recountsScanUPCState", "Landroidx/compose/runtime/State;", "getRecountsScanUPCState", "()Landroidx/compose/runtime/State;", "shouldForce", "getShouldForce", "()Z", "clearErrorMessage", "", "displayFullScreenError", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserData", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleProductIdentifierInput", "productIdentifier", "handleTextInput", "text", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onKeyboardConfirm", "onKeyboardToggled", "isToggled", "onNavigatedTo", "onProductClicked", "serialNumberPending", "uploadRecount", "validateSerialNumber", "app_debug"})
public final class RecountsScanUPCViewModel extends androidx.lifecycle.ViewModel {
    private final com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner = null;
    private final com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository recountsDataRepository = null;
    private final com.sweetwater.encore.dependency_injection.sound.ISoundService soundService = null;
    private final com.sweetwater.encore.dependency_injection.vibrator.IVibratorService vibratorService = null;
    private final androidx.lifecycle.SavedStateHandle savedStateHandle = null;
    private final com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository inventoryRepository = null;
    private final com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private final android.content.Context context = null;
    private final androidx.compose.runtime.MutableState<com.sweetwater.encore.recounts.state.RecountsScanUPCState> _recountsScanUPCState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.recounts.state.RecountsScanUPCState> recountsScanUPCState = null;
    private java.lang.String _locationName = "";
    private int _employeeId = 0;
    private java.lang.String _campusId = "";
    private boolean _shouldForce = false;
    
    @javax.inject.Inject
    public RecountsScanUPCViewModel(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository recountsDataRepository, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.sound.ISoundService soundService, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.vibrator.IVibratorService vibratorService, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository inventoryRepository, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.recounts.state.RecountsScanUPCState> getRecountsScanUPCState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocationName() {
        return null;
    }
    
    public final int getEmployeeId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCampusId() {
        return null;
    }
    
    public final boolean getShouldForce() {
        return false;
    }
    
    public final void onNavigatedTo() {
    }
    
    public final void onProductClicked() {
    }
    
    public final void clearErrorMessage() {
    }
    
    public final void onKeyboardToggled(boolean isToggled) {
    }
    
    public final void onKeyboardConfirm(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    private final java.lang.Object handleTextInput(java.lang.String text, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleProductIdentifierInput(java.lang.String productIdentifier) {
    }
    
    private final boolean serialNumberPending() {
        return false;
    }
    
    private final java.lang.Object getUserData(android.content.Context context, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object uploadRecount(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object displayFullScreenError(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void validateSerialNumber(java.lang.String text) {
    }
}