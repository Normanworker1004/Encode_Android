package com.sweetwater.encore.recounts.data.repository.interfaces;

import com.sweetwater.encore.RecountLocation;
import com.sweetwater.encore.RecountRequest;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/sweetwater/encore/recounts/data/repository/interfaces/IRecountsRepository;", "", "getCurrentLocations", "", "Lcom/sweetwater/encore/RecountLocation;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentRequest", "Lcom/sweetwater/encore/RecountRequest;", "resetRecountData", "", "setCurrentLocations", "recountLocations", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCurrentRequest", "recountRequest", "(Lcom/sweetwater/encore/RecountRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface IRecountsRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object resetRecountData(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object setCurrentRequest(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.RecountRequest recountRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object setCurrentLocations(@org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.RecountLocation> recountLocations, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCurrentRequest(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sweetwater.encore.RecountRequest> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCurrentLocations(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.sweetwater.encore.RecountLocation>> continuation);
}