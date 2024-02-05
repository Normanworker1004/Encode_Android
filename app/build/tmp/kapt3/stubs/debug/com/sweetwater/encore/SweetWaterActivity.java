package com.sweetwater.encore;

import android.R;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.datadog.android.Datadog;
import com.datadog.android.DatadogSite;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.configuration.Credentials;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.tracking.ActivityViewTrackingStrategy;
import com.sweetwater.encore.authorization.data.AppLoginStatusStorage;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0014J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0010R\u001f\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/sweetwater/encore/SweetWaterActivity;", "Landroidx/activity/ComponentActivity;", "()V", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "getRequestPermissionLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "storage", "Lcom/sweetwater/encore/authorization/data/AppLoginStatusStorage;", "getStorage", "()Lcom/sweetwater/encore/authorization/data/AppLoginStatusStorage;", "setStorage", "(Lcom/sweetwater/encore/authorization/data/AppLoginStatusStorage;)V", "configureRumMonitoring", "", "hideSystemUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onWindowFocusChanged", "hasFocus", "", "requestCameraPermission", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class SweetWaterActivity extends androidx.activity.ComponentActivity {
    @javax.inject.Inject
    public com.sweetwater.encore.authorization.data.AppLoginStatusStorage storage;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> requestPermissionLauncher = null;
    
    public SweetWaterActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.authorization.data.AppLoginStatusStorage getStorage() {
        return null;
    }
    
    public final void setStorage(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.data.AppLoginStatusStorage p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    public void onWindowFocusChanged(boolean hasFocus) {
    }
    
    private final void hideSystemUI() {
    }
    
    private final void configureRumMonitoring() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.activity.result.ActivityResultLauncher<java.lang.String> getRequestPermissionLauncher() {
        return null;
    }
    
    public final void requestCameraPermission() {
    }
}