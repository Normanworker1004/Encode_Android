package com.sweetwater.encore.recounts.viewmodels;

import android.content.Context;
import androidx.compose.runtime.State;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository;
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto;
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository;
import com.sweetwater.encore.recounts.state.RecountsScanProductState;
import com.sweetwater.encore.utilities.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineDispatcher;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010#\u001a\u00020$J!\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J!\u0010(\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J\u0019\u0010)\u001a\u00020$2\u0006\u0010\f\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*J\u0011\u0010+\u001a\u00020$H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J\u0019\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020/H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00100R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2 = {"Lcom/sweetwater/encore/recounts/viewmodels/RecountsScanProductViewModel;", "Landroidx/lifecycle/ViewModel;", "getEmployeeLoginDetailsUseCase", "Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;", "recountsDataRepository", "Lcom/sweetwater/encore/recounts/data/repository/interfaces/IRecountsRepository;", "inventoryRepository", "Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "context", "Landroid/content/Context;", "(Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;Lcom/sweetwater/encore/recounts/data/repository/interfaces/IRecountsRepository;Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/lifecycle/SavedStateHandle;Landroid/content/Context;)V", "_campusId", "", "_recountsScanProductState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/recounts/state/RecountsScanProductState;", "_zoneId", "", "_zoneName", "campusId", "getCampusId", "()Ljava/lang/String;", "recountsScanProductState", "Landroidx/compose/runtime/State;", "getRecountsScanProductState", "()Landroidx/compose/runtime/State;", "zoneId", "getZoneId", "()I", "zoneName", "getZoneName", "clearError", "", "getRecountLocationsForRequest", "recountRequestId", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecountRequestsForZone", "getUserData", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLaunch", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSelectedRequestAndLocations", "recountRequest", "Lcom/sweetwater/encore/recounts/data/dto/RecountRequestDto;", "(Lcom/sweetwater/encore/recounts/data/dto/RecountRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RecountsScanProductViewModel extends androidx.lifecycle.ViewModel {
    private final com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase = null;
    private final com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository recountsDataRepository = null;
    private final com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository inventoryRepository = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private final android.content.Context context = null;
    private final androidx.compose.runtime.MutableState<com.sweetwater.encore.recounts.state.RecountsScanProductState> _recountsScanProductState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.recounts.state.RecountsScanProductState> recountsScanProductState = null;
    private java.lang.String _campusId = "";
    private int _zoneId = 0;
    private java.lang.String _zoneName = "";
    
    @javax.inject.Inject
    public RecountsScanProductViewModel(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository recountsDataRepository, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository inventoryRepository, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.recounts.state.RecountsScanProductState> getRecountsScanProductState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCampusId() {
        return null;
    }
    
    public final int getZoneId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getZoneName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object onLaunch(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void clearError() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setSelectedRequestAndLocations(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.recounts.data.dto.RecountRequestDto recountRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object getRecountRequestsForZone(int zoneId, java.lang.String campusId, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object getRecountLocationsForRequest(int recountRequestId, java.lang.String campusId, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object getUserData(android.content.Context context, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}