package com.sweetwater.encore.dashboard.topappbar.presentation

sealed class TopAppBarEvent {
    object ToggleMenuIcon : TopAppBarEvent()
    data class ToggleTopBarMenuLabel(val topBarMenuLabel: String) : TopAppBarEvent()
    data class ToggleBarCodeIcon(val isBarCodeIconToggled: Boolean) : TopAppBarEvent()
    object ToggleProfileIcon : TopAppBarEvent()
}