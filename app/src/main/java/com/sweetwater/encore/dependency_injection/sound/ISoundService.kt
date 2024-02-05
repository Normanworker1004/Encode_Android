package com.sweetwater.encore.dependency_injection.sound

interface ISoundService {
    fun playPositiveFeedbackSound()
    fun playNegativeFeedbackSound()
    fun playNotificationSound()
}