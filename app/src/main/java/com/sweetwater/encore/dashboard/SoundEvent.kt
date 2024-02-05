package com.sweetwater.encore.dashboard

sealed class SoundEvent {
    object PlayNegativeFeedbackSound : SoundEvent()
    object PlayPositiveFeedbackSound : SoundEvent()
}