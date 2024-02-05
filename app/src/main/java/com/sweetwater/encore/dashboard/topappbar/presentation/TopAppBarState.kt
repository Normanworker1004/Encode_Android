package com.sweetwater.encore.dashboard.topappbar.presentation

data class TopAppBarState(
    val isTopBarMenuIconToggled: Boolean = false,
    val isBarCodeIconToggled: Boolean = false,
    val topBarMenuLabel: String,
    val profileIcon: String,
    val barCodeIcon: Int = -1,
    val topBarBackgroundColor: Int = -1
)
