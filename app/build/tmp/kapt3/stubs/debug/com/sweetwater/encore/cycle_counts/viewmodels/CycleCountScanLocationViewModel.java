package com.sweetwater.encore.cycle_counts.viewmodels;

import android.content.Context;
import androidx.compose.runtime.State;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.cycle_counts.state.CycleCountScanLocationState;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.external_api.inventory.dto.response.CycleCountLocation;
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository;
import com.sweetwater.encore.utilities.IKeyboardInputViewModel;
import com.sweetwater.encore.utilities.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineDispatcher;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B?\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J)\u0010#\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u0018H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\u0006\u0010\'\u001a\u00020$J\u0006\u0010(\u001a\u00020$J\u0018\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,H\u0002J\u0019\u0010-\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u0013H\u0016J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u000203H\u0016J\u0006\u00104\u001a\u00020$R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/sweetwater/encore/cycle_counts/viewmodels/CycleCountScanLocationViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/sweetwater/encore/utilities/IKeyboardInputViewModel;", "getEmployeeLoginDetailsUseCase", "Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;", "inventoryRepository", "Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;", "barcodeScanner", "Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;", "soundService", "Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "context", "Landroid/content/Context;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;Lkotlinx/coroutines/CoroutineDispatcher;Landroid/content/Context;Landroidx/lifecycle/SavedStateHandle;)V", "_campusId", "", "_cycleCountScanLocationState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/cycle_counts/state/CycleCountScanLocationState;", "_employeeId", "", "campusId", "getCampusId", "()Ljava/lang/String;", "cycleCountScanLocationState", "Landroidx/compose/runtime/State;", "getCycleCountScanLocationState", "()Landroidx/compose/runtime/State;", "employeeId", "getEmployeeId", "()I", "assignCountRequestsForZone", "", "zoneId", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearError", "clearLocationMatchFlag", "compareInputToLocation", "input", "location", "Lcom/sweetwater/encore/external_api/inventory/dto/response/CycleCountLocation;", "getUserData", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onConfirmKeyboard", "text", "onKeyboardToggled", "isToggled", "", "onNavigatedTo", "app_debug"})
public final class CycleCountScanLocationViewModel extends androidx.lifecycle.ViewModel implements com.sweetwater.encore.utilities.IKeyboardInputViewModel {
    private final com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase = null;
    private final com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository inventoryRepository = null;
    private final com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner = null;
    private final com.sweetwater.encore.dependency_injection.sound.ISoundService soundService = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private final androidx.compose.runtime.MutableState<com.sweetwater.encore.cycle_counts.state.CycleCountScanLocationState> _cycleCountScanLocationState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.cycle_counts.state.CycleCountScanLocationState> cycleCountScanLocationState = null;
    private int _employeeId = 0;
    private java.lang.String _campusId = "";
    
    @javax.inject.Inject
    public CycleCountScanLocationViewModel(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository inventoryRepository, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.sound.ISoundService soundService, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.cycle_counts.state.CycleCountScanLocationState> getCycleCountScanLocationState() {
        return null;
    }
    
    public final int getEmployeeId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCampusId() {
        return null;
    }
    
    public final void onNavigatedTo() {
    }
    
    public final void clearError() {
    }
    
    public final void clearLocationMatchFlag() {
    }
    
    private final void compareInputToLocation(java.lang.String input, com.sweetwater.encore.external_api.inventory.dto.response.CycleCountLocation location) {
    }
    
    private final java.lang.Object assignCountRequestsForZone(java.lang.String campusId, int employeeId, int zoneId, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object getUserData(android.content.Context context, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @java.lang.Override
    public void onKeyboardToggled(boolean isToggled) {
    }
    
    @java.lang.Override
    public void onConfirmKeyboard(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
}