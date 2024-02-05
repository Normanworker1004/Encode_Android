package com.sweetwater.encore.authorization.state;

import com.sweetwater.encore.authorization.data.model.login.response.UserInfo;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u000bH\u00c6\u0003JY\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\u000bH\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006#"}, d2 = {"Lcom/sweetwater/encore/authorization/state/AppAuthState;", "", "isLoggedIn", "", "isLoggedOut", "isLoading", "isAutoLoginValidated", "isManualLoginValidated", "userData", "Lcom/sweetwater/encore/authorization/data/model/login/response/UserInfo;", "appVersionName", "", "error", "(ZZZZZLcom/sweetwater/encore/authorization/data/model/login/response/UserInfo;Ljava/lang/String;Ljava/lang/String;)V", "getAppVersionName", "()Ljava/lang/String;", "getError", "()Z", "getUserData", "()Lcom/sweetwater/encore/authorization/data/model/login/response/UserInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_debug"})
public final class AppAuthState {
    private final boolean isLoggedIn = false;
    private final boolean isLoggedOut = false;
    private final boolean isLoading = false;
    private final boolean isAutoLoginValidated = false;
    private final boolean isManualLoginValidated = false;
    @org.jetbrains.annotations.NotNull
    private final com.sweetwater.encore.authorization.data.model.login.response.UserInfo userData = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String appVersionName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String error = null;
    @org.jetbrains.annotations.NotNull
    public static final com.sweetwater.encore.authorization.state.AppAuthState.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.authorization.state.AppAuthState copy(boolean isLoggedIn, boolean isLoggedOut, boolean isLoading, boolean isAutoLoginValidated, boolean isManualLoginValidated, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.data.model.login.response.UserInfo userData, @org.jetbrains.annotations.NotNull
    java.lang.String appVersionName, @org.jetbrains.annotations.NotNull
    java.lang.String error) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public AppAuthState(boolean isLoggedIn, boolean isLoggedOut, boolean isLoading, boolean isAutoLoginValidated, boolean isManualLoginValidated, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.data.model.login.response.UserInfo userData, @org.jetbrains.annotations.NotNull
    java.lang.String appVersionName, @org.jetbrains.annotations.NotNull
    java.lang.String error) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean isLoggedIn() {
        return false;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean isLoggedOut() {
        return false;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean isAutoLoginValidated() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean isManualLoginValidated() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.authorization.data.model.login.response.UserInfo component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.authorization.data.model.login.response.UserInfo getUserData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAppVersionName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getError() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/authorization/state/AppAuthState$Companion;", "", "()V", "initialState", "Lcom/sweetwater/encore/authorization/state/AppAuthState;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.authorization.state.AppAuthState initialState() {
            return null;
        }
    }
}