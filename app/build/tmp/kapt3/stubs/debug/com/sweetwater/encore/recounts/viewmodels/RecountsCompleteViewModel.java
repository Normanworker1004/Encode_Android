package com.sweetwater.encore.recounts.viewmodels;

import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/sweetwater/encore/recounts/viewmodels/RecountsCompleteViewModel;", "Landroidx/lifecycle/ViewModel;", "recountsDataStoreRepository", "Lcom/sweetwater/encore/recounts/data/repository/interfaces/IRecountsRepository;", "(Lcom/sweetwater/encore/recounts/data/repository/interfaces/IRecountsRepository;)V", "_outOfLocations", "", "outOfLocations", "getOutOfLocations", "()Z", "onLaunch", "", "locationName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RecountsCompleteViewModel extends androidx.lifecycle.ViewModel {
    private final com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository recountsDataStoreRepository = null;
    private boolean _outOfLocations = false;
    
    @javax.inject.Inject
    public RecountsCompleteViewModel(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository recountsDataStoreRepository) {
        super();
    }
    
    public final boolean getOutOfLocations() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object onLaunch(@org.jetbrains.annotations.NotNull
    java.lang.String locationName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}