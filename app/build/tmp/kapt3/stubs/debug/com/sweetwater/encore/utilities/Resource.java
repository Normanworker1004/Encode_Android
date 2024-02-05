package com.sweetwater.encore.utilities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u000f\u0010\u0011B)\b\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0003\u0012\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/sweetwater/encore/utilities/Resource;", "T", "", "data", "message", "Lcom/sweetwater/encore/utilities/ErrorMessage;", "isLoading", "", "(Ljava/lang/Object;Lcom/sweetwater/encore/utilities/ErrorMessage;Z)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "()Z", "getMessage", "()Lcom/sweetwater/encore/utilities/ErrorMessage;", "Error", "Loading", "Success", "Lcom/sweetwater/encore/utilities/Resource$Error;", "Lcom/sweetwater/encore/utilities/Resource$Loading;", "Lcom/sweetwater/encore/utilities/Resource$Success;", "app_debug"})
public abstract class Resource<T extends java.lang.Object> {
    @org.jetbrains.annotations.Nullable
    private final T data = null;
    @org.jetbrains.annotations.Nullable
    private final com.sweetwater.encore.utilities.ErrorMessage message = null;
    private final boolean isLoading = false;
    
    private Resource(T data, com.sweetwater.encore.utilities.ErrorMessage message, boolean isLoading) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final T getData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sweetwater.encore.utilities.ErrorMessage getMessage() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/utilities/Resource$Success;", "T", "Lcom/sweetwater/encore/utilities/Resource;", "data", "(Ljava/lang/Object;)V", "app_debug"})
    public static final class Success<T extends java.lang.Object> extends com.sweetwater.encore.utilities.Resource<T> {
        
        public Success(@org.jetbrains.annotations.Nullable
        T data) {
            super(null, null, false);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/sweetwater/encore/utilities/Resource$Error;", "T", "Lcom/sweetwater/encore/utilities/Resource;", "message", "Lcom/sweetwater/encore/utilities/ErrorMessage;", "data", "(Lcom/sweetwater/encore/utilities/ErrorMessage;Ljava/lang/Object;)V", "app_debug"})
    public static final class Error<T extends java.lang.Object> extends com.sweetwater.encore.utilities.Resource<T> {
        
        public Error(@org.jetbrains.annotations.Nullable
        com.sweetwater.encore.utilities.ErrorMessage message, @org.jetbrains.annotations.Nullable
        T data) {
            super(null, null, false);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/sweetwater/encore/utilities/Resource$Loading;", "T", "Lcom/sweetwater/encore/utilities/Resource;", "isLoading", "", "(Z)V", "app_debug"})
    public static final class Loading<T extends java.lang.Object> extends com.sweetwater.encore.utilities.Resource<T> {
        
        public Loading() {
            super(null, null, false);
        }
        
        public Loading(boolean isLoading) {
            super(null, null, false);
        }
    }
}