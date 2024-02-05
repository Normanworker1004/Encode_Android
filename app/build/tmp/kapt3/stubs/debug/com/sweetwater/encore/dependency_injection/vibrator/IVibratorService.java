package com.sweetwater.encore.dependency_injection.vibrator;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/sweetwater/encore/dependency_injection/vibrator/IVibratorService;", "", "doubleClick", "", "heavyClick", "singleClick", "tick", "app_debug"})
public abstract interface IVibratorService {
    
    public abstract void tick();
    
    public abstract void heavyClick();
    
    public abstract void singleClick();
    
    public abstract void doubleClick();
}