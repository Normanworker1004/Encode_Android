package com.sweetwater.encore.recounts.viewmodels;

import android.content.Context;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository;
import com.sweetwater.encore.recounts.state.RecountsChooseZoneState;
import com.sweetwater.encore.utilities.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineDispatcher;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u001c\u001a\u00020\u001dJ!\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u0019\u0010 \u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u001dR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/sweetwater/encore/recounts/viewmodels/RecountsChooseZoneViewModel;", "Landroidx/lifecycle/ViewModel;", "getEmployeeLoginDetailsUseCase", "Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;", "inventoryRepository", "Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "context", "Landroid/content/Context;", "(Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;Lkotlinx/coroutines/CoroutineDispatcher;Landroid/content/Context;)V", "_campusId", "", "_employeeId", "", "_recountsChooseZoneState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/recounts/state/RecountsChooseZoneState;", "campusId", "getCampusId", "()Ljava/lang/String;", "employeeId", "getEmployeeId", "()I", "recountsChooseZoneState", "Landroidx/compose/runtime/State;", "getRecountsChooseZoneState", "()Landroidx/compose/runtime/State;", "clearError", "", "getRecountsDailyStatistics", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecountsSummary", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserData", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLaunch", "app_debug"})
public final class RecountsChooseZoneViewModel extends androidx.lifecycle.ViewModel {
    private final com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase = null;
    private final com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository inventoryRepository = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private final android.content.Context context = null;
    private final androidx.compose.runtime.MutableState<com.sweetwater.encore.recounts.state.RecountsChooseZoneState> _recountsChooseZoneState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.recounts.state.RecountsChooseZoneState> recountsChooseZoneState = null;
    private int _employeeId = 0;
    private java.lang.String _campusId = "";
    
    @javax.inject.Inject
    public RecountsChooseZoneViewModel(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository inventoryRepository, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.recounts.state.RecountsChooseZoneState> getRecountsChooseZoneState() {
        return null;
    }
    
    public final int getEmployeeId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCampusId() {
        return null;
    }
    
    public final void onLaunch() {
    }
    
    public final void clearError() {
    }
    
    private final java.lang.Object getUserData(android.content.Context context, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object getRecountsSummary(java.lang.String campusId, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object getRecountsDailyStatistics(java.lang.String campusId, int employeeId, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}