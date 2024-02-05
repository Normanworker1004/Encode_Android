package com.sweetwater.encore.recounts.data.repository;

import androidx.datastore.core.DataStore;
import com.sweetwater.encore.RecountLocation;
import com.sweetwater.encore.RecountRequest;
import com.sweetwater.encore.RecountsData;
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository;
import kotlinx.coroutines.flow.Flow;
import java.io.IOException;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u0011\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u0012\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/sweetwater/encore/recounts/data/repository/RecountsDataStoreRepository;", "Lcom/sweetwater/encore/recounts/data/repository/interfaces/IRecountsRepository;", "recountsDataStore", "Landroidx/datastore/core/DataStore;", "Lcom/sweetwater/encore/RecountsData;", "(Landroidx/datastore/core/DataStore;)V", "recountsDataFlow", "Lkotlinx/coroutines/flow/Flow;", "clearCurrentLocations", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCurrentProduct", "getCurrentLocations", "", "Lcom/sweetwater/encore/RecountLocation;", "getCurrentRequest", "Lcom/sweetwater/encore/RecountRequest;", "resetRecountData", "setCurrentLocations", "recountLocations", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCurrentRequest", "recountRequest", "(Lcom/sweetwater/encore/RecountRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RecountsDataStoreRepository implements com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository {
    private final androidx.datastore.core.DataStore<com.sweetwater.encore.RecountsData> recountsDataStore = null;
    private final kotlinx.coroutines.flow.Flow<com.sweetwater.encore.RecountsData> recountsDataFlow = null;
    
    public RecountsDataStoreRepository(@org.jetbrains.annotations.NotNull
    androidx.datastore.core.DataStore<com.sweetwater.encore.RecountsData> recountsDataStore) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object resetRecountData(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object setCurrentRequest(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.RecountRequest recountRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object setCurrentLocations(@org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.RecountLocation> recountLocations, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getCurrentLocations(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.sweetwater.encore.RecountLocation>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getCurrentRequest(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sweetwater.encore.RecountRequest> continuation) {
        return null;
    }
    
    private final java.lang.Object clearCurrentProduct(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object clearCurrentLocations(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}