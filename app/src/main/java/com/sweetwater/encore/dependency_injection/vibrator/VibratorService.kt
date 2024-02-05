package com.sweetwater.encore.dependency_injection.vibrator

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

class VibratorService(var context: Context): IVibratorService {
    private val vibrator: Vibrator = if (Build.VERSION.SDK_INT>=31) {
        val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator
    } else {
        context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    override fun tick() {
        vibrateDevice(VibrationEffect.EFFECT_TICK)
    }
    override fun heavyClick() {
        vibrateDevice(VibrationEffect.EFFECT_HEAVY_CLICK)
    }
    override fun singleClick() {
        vibrateDevice(VibrationEffect.EFFECT_CLICK)
    }
    override fun doubleClick() {
        vibrateDevice(VibrationEffect.EFFECT_DOUBLE_CLICK)
    }
    private fun vibrateDevice(vibrationEffect: Int
    ){
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createPredefined(vibrationEffect))
        }
        else {
            vibrator.vibrate(500)
        }
    }
}