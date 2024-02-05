package com.sweetwater.encore.dependency_injection.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/sweetwater/encore/dependency_injection/connectivity/ConnectivityService;", "Lcom/sweetwater/encore/dependency_injection/connectivity/IConnectivityService;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isOnline", "", "app_debug"})
public final class ConnectivityService implements com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService {
    private final android.content.Context context = null;
    
    @javax.inject.Inject
    public ConnectivityService(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override
    public boolean isOnline() {
        return false;
    }
}