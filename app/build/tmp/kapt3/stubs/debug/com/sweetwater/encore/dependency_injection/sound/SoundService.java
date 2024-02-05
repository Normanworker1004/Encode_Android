package com.sweetwater.encore.dependency_injection.sound;

import android.content.Context;
import android.media.MediaPlayer;
import com.sweetwater.encore.R;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/sweetwater/encore/dependency_injection/sound/SoundService;", "Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "playNegativeFeedbackSound", "", "playNotificationSound", "playPositiveFeedbackSound", "playSound", "resourceIdentifier", "", "app_debug"})
public final class SoundService implements com.sweetwater.encore.dependency_injection.sound.ISoundService {
    @org.jetbrains.annotations.NotNull
    private android.content.Context context;
    
    public SoundService(@org.jetbrains.annotations.NotNull
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
    public void playPositiveFeedbackSound() {
    }
    
    @java.lang.Override
    public void playNegativeFeedbackSound() {
    }
    
    @java.lang.Override
    public void playNotificationSound() {
    }
    
    private final void playSound(int resourceIdentifier) {
    }
}