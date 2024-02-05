package com.sweetwater.encore.recounts.viewmodels;

import android.content.Context;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository;
import com.sweetwater.encore.recounts.data.dto.LocationDto;
import com.sweetwater.encore.recounts.data.dto.RecountLocationDto;
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository;
import com.sweetwater.encore.recounts.state.RecountsScanLocationState;
import com.sweetwater.encore.utilities.IKeyboardInputViewModel;
import com.sweetwater.encore.utilities.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineDispatcher;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B7\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ9\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u001dJ\u0006\u0010%\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020\u001dJ\u0010\u0010\'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u0011H\u0002J\u0019\u0010)\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u0011H\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.H\u0016J\u0006\u0010/\u001a\u00020\u001dJ\u0011\u00100\u001a\u00020\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/sweetwater/encore/recounts/viewmodels/RecountsScanLocationViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/sweetwater/encore/utilities/IKeyboardInputViewModel;", "barcodeScanner", "Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;", "recountsDataRepository", "Lcom/sweetwater/encore/recounts/data/repository/interfaces/IRecountsRepository;", "inventoryRepository", "Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;", "getEmployeeLoginDetailsUseCase", "Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "context", "Landroid/content/Context;", "(Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;Lcom/sweetwater/encore/recounts/data/repository/interfaces/IRecountsRepository;Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;Lkotlinx/coroutines/CoroutineDispatcher;Landroid/content/Context;)V", "_campusId", "", "_recountsScanLocationState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/recounts/state/RecountsScanLocationState;", "campusId", "getCampusId", "()Ljava/lang/String;", "recountsScanLocationState", "Landroidx/compose/runtime/State;", "getRecountsScanLocationState", "()Landroidx/compose/runtime/State;", "addLocationToRecount", "", "locationId", "", "locationName", "recountPriority", "recountRequestId", "(ILjava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAdditionalLocation", "clearError", "clearMatchedLocation", "compareInputToLocations", "text", "getUserData", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onConfirmKeyboard", "onKeyboardToggled", "isToggled", "", "onNavigatedTo", "validateLocationAndAddToRecount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RecountsScanLocationViewModel extends androidx.lifecycle.ViewModel implements com.sweetwater.encore.utilities.IKeyboardInputViewModel {
    private final com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner = null;
    private final com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository recountsDataRepository = null;
    private final com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository inventoryRepository = null;
    private final com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private final android.content.Context context = null;
    private androidx.compose.runtime.MutableState<com.sweetwater.encore.recounts.state.RecountsScanLocationState> _recountsScanLocationState;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.recounts.state.RecountsScanLocationState> recountsScanLocationState = null;
    private java.lang.String _campusId = "";
    
    @javax.inject.Inject
    public RecountsScanLocationViewModel(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository recountsDataRepository, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository inventoryRepository, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.recounts.state.RecountsScanLocationState> getRecountsScanLocationState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCampusId() {
        return null;
    }
    
    public final void onNavigatedTo() {
    }
    
    public final void clearError() {
    }
    
    public final void clearMatchedLocation() {
    }
    
    public final void clearAdditionalLocation() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object validateLocationAndAddToRecount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @java.lang.Override
    public void onKeyboardToggled(boolean isToggled) {
    }
    
    @java.lang.Override
    public void onConfirmKeyboard(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    private final void compareInputToLocations(java.lang.String text) {
    }
    
    private final java.lang.Object getUserData(android.content.Context context, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object addLocationToRecount(int locationId, java.lang.String locationName, int recountPriority, int recountRequestId, java.lang.String campusId, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}