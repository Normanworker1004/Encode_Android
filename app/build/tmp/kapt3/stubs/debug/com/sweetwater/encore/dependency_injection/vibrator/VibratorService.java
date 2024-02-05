package com.sweetwater.encore.dependency_injection.vibrator;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/sweetwater/encore/dependency_injection/vibrator/VibratorService;", "Lcom/sweetwater/encore/dependency_injection/vibrator/IVibratorService;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "vibrator", "Landroid/os/Vibrator;", "doubleClick", "", "heavyClick", "singleClick", "tick", "vibrateDevice", "vibrationEffect", "", "app_debug"})
public final class VibratorService implements com.sweetwater.encore.dependency_injection.vibrator.IVibratorService {
    @org.jetbrains.annotations.NotNull
    private android.content.Context context;
    private final android.os.Vibrator vibrator = null;
    
    public VibratorService(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @java.lang.Override
    public void tick() {
    }
    
    @java.lang.Override
    public void heavyClick() {
    }
    
    @java.lang.Override
    public void singleClick() {
    }
    
    @java.lang.Override
    public void doubleClick() {
    }
    
    private final void vibrateDevice(int vibrationEffect) {
    }
}