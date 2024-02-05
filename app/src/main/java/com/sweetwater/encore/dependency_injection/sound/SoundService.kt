package com.sweetwater.encore.dependency_injection.sound

import android.content.Context
import android.media.MediaPlayer
import com.sweetwater.encore.R

class SoundService(var context: Context) : ISoundService {
    override fun playPositiveFeedbackSound() {
        playSound(R.raw.positive_feedback_tone)
    }

    override fun playNegativeFeedbackSound() {
        playSound(R.raw.negative_feedback_tone)
    }

    override fun playNotificationSound() {
        playSound(R.raw.desk_bell)
    }

    private fun playSound(resourceIdentifier: Int) {
        var mediaPlayer = MediaPlayer.create(context, resourceIdentifier)
        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener {
            mediaPlayer.reset()
            mediaPlayer.release()
        }
    }
}