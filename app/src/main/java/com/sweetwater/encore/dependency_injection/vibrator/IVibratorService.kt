package com.sweetwater.encore.dependency_injection.vibrator

interface IVibratorService {
    fun tick()
    fun heavyClick()
    fun singleClick()
    fun doubleClick()
}