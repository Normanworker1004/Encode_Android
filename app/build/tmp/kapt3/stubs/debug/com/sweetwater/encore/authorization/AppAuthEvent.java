package com.sweetwater.encore.authorization;

import com.sweetwater.encore.authorization.data.enums.SignInMode;
import com.sweetwater.encore.authorization.data.model.login.request.LoginRequest;
import com.sweetwater.encore.authorization.data.model.logout.request.LogoutRequest;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/sweetwater/encore/authorization/AppAuthEvent;", "", "()V", "ClearErrors", "FetchUserInfo", "SignIn", "SignOut", "Lcom/sweetwater/encore/authorization/AppAuthEvent$ClearErrors;", "Lcom/sweetwater/encore/authorization/AppAuthEvent$FetchUserInfo;", "Lcom/sweetwater/encore/authorization/AppAuthEvent$SignIn;", "Lcom/sweetwater/encore/authorization/AppAuthEvent$SignOut;", "app_debug"})
public abstract class AppAuthEvent {
    
    private AppAuthEvent() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/sweetwater/encore/authorization/AppAuthEvent$SignIn;", "Lcom/sweetwater/encore/authorization/AppAuthEvent;", "loginRequest", "Lcom/sweetwater/encore/authorization/data/model/login/request/LoginRequest;", "signInMode", "Lcom/sweetwater/encore/authorization/data/enums/SignInMode;", "onSignInSuccess", "Lkotlin/Function0;", "", "(Lcom/sweetwater/encore/authorization/data/model/login/request/LoginRequest;Lcom/sweetwater/encore/authorization/data/enums/SignInMode;Lkotlin/jvm/functions/Function0;)V", "getLoginRequest", "()Lcom/sweetwater/encore/authorization/data/model/login/request/LoginRequest;", "getOnSignInSuccess", "()Lkotlin/jvm/functions/Function0;", "getSignInMode", "()Lcom/sweetwater/encore/authorization/data/enums/SignInMode;", "app_debug"})
    public static final class SignIn extends com.sweetwater.encore.authorization.AppAuthEvent {
        @org.jetbrains.annotations.NotNull
        private final com.sweetwater.encore.authorization.data.model.login.request.LoginRequest loginRequest = null;
        @org.jetbrains.annotations.NotNull
        private final com.sweetwater.encore.authorization.data.enums.SignInMode signInMode = null;
        @org.jetbrains.annotations.NotNull
        private final kotlin.jvm.functions.Function0<kotlin.Unit> onSignInSuccess = null;
        
        public SignIn(@org.jetbrains.annotations.NotNull
        com.sweetwater.encore.authorization.data.model.login.request.LoginRequest loginRequest, @org.jetbrains.annotations.NotNull
        com.sweetwater.encore.authorization.data.enums.SignInMode signInMode, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function0<kotlin.Unit> onSignInSuccess) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.authorization.data.model.login.request.LoginRequest getLoginRequest() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.authorization.data.enums.SignInMode getSignInMode() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnSignInSuccess() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/sweetwater/encore/authorization/AppAuthEvent$SignOut;", "Lcom/sweetwater/encore/authorization/AppAuthEvent;", "logoutRequest", "Lcom/sweetwater/encore/authorization/data/model/logout/request/LogoutRequest;", "onSignOutSuccess", "Lkotlin/Function0;", "", "(Lcom/sweetwater/encore/authorization/data/model/logout/request/LogoutRequest;Lkotlin/jvm/functions/Function0;)V", "getLogoutRequest", "()Lcom/sweetwater/encore/authorization/data/model/logout/request/LogoutRequest;", "getOnSignOutSuccess", "()Lkotlin/jvm/functions/Function0;", "app_debug"})
    public static final class SignOut extends com.sweetwater.encore.authorization.AppAuthEvent {
        @org.jetbrains.annotations.NotNull
        private final com.sweetwater.encore.authorization.data.model.logout.request.LogoutRequest logoutRequest = null;
        @org.jetbrains.annotations.NotNull
        private final kotlin.jvm.functions.Function0<kotlin.Unit> onSignOutSuccess = null;
        
        public SignOut(@org.jetbrains.annotations.NotNull
        com.sweetwater.encore.authorization.data.model.logout.request.LogoutRequest logoutRequest, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function0<kotlin.Unit> onSignOutSuccess) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.authorization.data.model.logout.request.LogoutRequest getLogoutRequest() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnSignOutSuccess() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/sweetwater/encore/authorization/AppAuthEvent$FetchUserInfo;", "Lcom/sweetwater/encore/authorization/AppAuthEvent;", "()V", "app_debug"})
    public static final class FetchUserInfo extends com.sweetwater.encore.authorization.AppAuthEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.sweetwater.encore.authorization.AppAuthEvent.FetchUserInfo INSTANCE = null;
        
        private FetchUserInfo() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/sweetwater/encore/authorization/AppAuthEvent$ClearErrors;", "Lcom/sweetwater/encore/authorization/AppAuthEvent;", "()V", "app_debug"})
    public static final class ClearErrors extends com.sweetwater.encore.authorization.AppAuthEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.sweetwater.encore.authorization.AppAuthEvent.ClearErrors INSTANCE = null;
        
        private ClearErrors() {
            super();
        }
    }
}