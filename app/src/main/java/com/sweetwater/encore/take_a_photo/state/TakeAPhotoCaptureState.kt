package com.sweetwater.encore.take_a_photo.state

import android.net.Uri

data class TakeAPhotoCaptureState(
    val isLoading: Boolean = false,
    val error: String,
    val descriptionText: String = "",
    val tagText: String = "",
    val capturedImage: Uri?,
    var showCameraFeatures : Boolean = false,
    var isCaptured : Boolean = false,
    var uploading : Boolean = false,
    var complete: Boolean = false
) {
    companion object {
        fun initialState() = TakeAPhotoCaptureState(
            isLoading = false,
            error = "",
            capturedImage = null,
            isCaptured = false,
            descriptionText = "",
            uploading = false,
            complete = false
        )
    }
}