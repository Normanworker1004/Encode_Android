package com.sweetwater.encore.utilities

interface IKeyboardInputViewModel {
    fun onKeyboardToggled(isToggled: Boolean)
    fun onConfirmKeyboard(text: String)
}