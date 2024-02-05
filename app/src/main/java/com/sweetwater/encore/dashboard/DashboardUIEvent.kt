package com.sweetwater.encore.dashboard

import com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarEvent

sealed class DashboardUIEvent {
    object FetchUserInfo : DashboardUIEvent()
    object ToggleSideMenu : DashboardUIEvent()
    class TopBarEvent(val topAppBarEvent: TopAppBarEvent) : DashboardUIEvent()
    class PlaySoundEvent(val soundEvent: SoundEvent) : DashboardUIEvent()
    object NavigateToMainScreen : DashboardUIEvent()
    object ClearError : DashboardUIEvent()
}