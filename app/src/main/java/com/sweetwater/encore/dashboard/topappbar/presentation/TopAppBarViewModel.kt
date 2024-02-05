package com.sweetwater.encore.dashboard.topappbar.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopAppBarViewModel @Inject constructor(

) : ViewModel() {

    private val _topAppBarState = mutableStateOf(
        TopAppBarState(
            isBarCodeIconToggled = false,
            topBarMenuLabel = "",
            profileIcon = "",
            barCodeIcon = 0,
            topBarBackgroundColor = 0
        )
    )

    val topAppBarState: State<TopAppBarState> = _topAppBarState

    fun onEvent(event: TopAppBarEvent) {

        when (event) {
            is TopAppBarEvent.ToggleBarCodeIcon -> {
                _topAppBarState.value = topAppBarState.value.copy(
                    isBarCodeIconToggled = !topAppBarState.value.isBarCodeIconToggled
                )
            }

            is TopAppBarEvent.ToggleProfileIcon -> {
                _topAppBarState.value = topAppBarState.value.copy(
                )
            }

            is TopAppBarEvent.ToggleTopBarMenuLabel -> {
                _topAppBarState.value = topAppBarState.value.copy(
                    topBarMenuLabel = event.topBarMenuLabel
                )
            }

            is TopAppBarEvent.ToggleMenuIcon -> {
                _topAppBarState.value = topAppBarState.value.copy(
                    isTopBarMenuIconToggled = !topAppBarState.value.isTopBarMenuIconToggled
                )
            }

        }
    }

}