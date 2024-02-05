package com.sweetwater.encore.dashboard;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/sweetwater/encore/dashboard/SoundEvent;", "", "()V", "PlayNegativeFeedbackSound", "PlayPositiveFeedbackSound", "Lcom/sweetwater/encore/dashboard/SoundEvent$PlayNegativeFeedbackSound;", "Lcom/sweetwater/encore/dashboard/SoundEvent$PlayPositiveFeedbackSound;", "app_debug"})
public abstract class SoundEvent {
    
    private SoundEvent() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/sweetwater/encore/dashboard/SoundEvent$PlayNegativeFeedbackSound;", "Lcom/sweetwater/encore/dashboard/SoundEvent;", "()V", "app_debug"})
    public static final class PlayNegativeFeedbackSound extends com.sweetwater.encore.dashboard.SoundEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.sweetwater.encore.dashboard.SoundEvent.PlayNegativeFeedbackSound INSTANCE = null;
        
        private PlayNegativeFeedbackSound() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/sweetwater/encore/dashboard/SoundEvent$PlayPositiveFeedbackSound;", "Lcom/sweetwater/encore/dashboard/SoundEvent;", "()V", "app_debug"})
    public static final class PlayPositiveFeedbackSound extends com.sweetwater.encore.dashboard.SoundEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.sweetwater.encore.dashboard.SoundEvent.PlayPositiveFeedbackSound INSTANCE = null;
        
        private PlayPositiveFeedbackSound() {
            super();
        }
    }
}