package com.sweetwater.encore.dashboard;

import com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarEvent;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/sweetwater/encore/dashboard/DashboardUIEvent;", "", "()V", "ClearError", "FetchUserInfo", "NavigateToMainScreen", "PlaySoundEvent", "ToggleSideMenu", "TopBarEvent", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent$ClearError;", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent$FetchUserInfo;", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent$NavigateToMainScreen;", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent$PlaySoundEvent;", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent$ToggleSideMenu;", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent$TopBarEvent;", "app_debug"})
public abstract class DashboardUIEvent {
    
    private DashboardUIEvent() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/sweetwater/encore/dashboard/DashboardUIEvent$FetchUserInfo;", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent;", "()V", "app_debug"})
    public static final class FetchUserInfo extends com.sweetwater.encore.dashboard.DashboardUIEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.sweetwater.encore.dashboard.DashboardUIEvent.FetchUserInfo INSTANCE = null;
        
        private FetchUserInfo() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/sweetwater/encore/dashboard/DashboardUIEvent$ToggleSideMenu;", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent;", "()V", "app_debug"})
    public static final class ToggleSideMenu extends com.sweetwater.encore.dashboard.DashboardUIEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.sweetwater.encore.dashboard.DashboardUIEvent.ToggleSideMenu INSTANCE = null;
        
        private ToggleSideMenu() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/sweetwater/encore/dashboard/DashboardUIEvent$TopBarEvent;", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent;", "topAppBarEvent", "Lcom/sweetwater/encore/dashboard/topappbar/presentation/TopAppBarEvent;", "(Lcom/sweetwater/encore/dashboard/topappbar/presentation/TopAppBarEvent;)V", "getTopAppBarEvent", "()Lcom/sweetwater/encore/dashboard/topappbar/presentation/TopAppBarEvent;", "app_debug"})
    public static final class TopBarEvent extends com.sweetwater.encore.dashboard.DashboardUIEvent {
        @org.jetbrains.annotations.NotNull
        private final com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarEvent topAppBarEvent = null;
        
        public TopBarEvent(@org.jetbrains.annotations.NotNull
        com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarEvent topAppBarEvent) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarEvent getTopAppBarEvent() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/sweetwater/encore/dashboard/DashboardUIEvent$PlaySoundEvent;", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent;", "soundEvent", "Lcom/sweetwater/encore/dashboard/SoundEvent;", "(Lcom/sweetwater/encore/dashboard/SoundEvent;)V", "getSoundEvent", "()Lcom/sweetwater/encore/dashboard/SoundEvent;", "app_debug"})
    public static final class PlaySoundEvent extends com.sweetwater.encore.dashboard.DashboardUIEvent {
        @org.jetbrains.annotations.NotNull
        private final com.sweetwater.encore.dashboard.SoundEvent soundEvent = null;
        
        public PlaySoundEvent(@org.jetbrains.annotations.NotNull
        com.sweetwater.encore.dashboard.SoundEvent soundEvent) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.dashboard.SoundEvent getSoundEvent() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/sweetwater/encore/dashboard/DashboardUIEvent$NavigateToMainScreen;", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent;", "()V", "app_debug"})
    public static final class NavigateToMainScreen extends com.sweetwater.encore.dashboard.DashboardUIEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.sweetwater.encore.dashboard.DashboardUIEvent.NavigateToMainScreen INSTANCE = null;
        
        private NavigateToMainScreen() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/sweetwater/encore/dashboard/DashboardUIEvent$ClearError;", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent;", "()V", "app_debug"})
    public static final class ClearError extends com.sweetwater.encore.dashboard.DashboardUIEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.sweetwater.encore.dashboard.DashboardUIEvent.ClearError INSTANCE = null;
        
        private ClearError() {
            super();
        }
    }
}