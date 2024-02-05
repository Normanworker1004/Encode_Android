package com.sweetwater.encore.authorization.data;

import com.sweetwater.encore.authorization.data.enums.AppAuthStatusState;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/sweetwater/encore/authorization/data/AppLoginStatusStorage;", "", "()V", "_appLoginStatusState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/sweetwater/encore/authorization/data/enums/AppAuthStatusState;", "appLoginStatusState", "Lkotlinx/coroutines/flow/StateFlow;", "getAppLoginStatusState", "()Lkotlinx/coroutines/flow/StateFlow;", "onLoggedIn", "", "onLoggedOut", "onResetState", "app_debug"})
@javax.inject.Singleton
public final class AppLoginStatusStorage {
    private kotlinx.coroutines.flow.MutableStateFlow<com.sweetwater.encore.authorization.data.enums.AppAuthStatusState> _appLoginStatusState;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.sweetwater.encore.authorization.data.enums.AppAuthStatusState> appLoginStatusState = null;
    
    @javax.inject.Inject
    public AppLoginStatusStorage() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.sweetwater.encore.authorization.data.enums.AppAuthStatusState> getAppLoginStatusState() {
        return null;
    }
    
    public final void onLoggedIn() {
    }
    
    public final void onLoggedOut() {
    }
    
    public final void onResetState() {
    }
}