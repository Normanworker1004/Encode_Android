package com.sweetwater.encore.take_a_photo.state

data class TakeAPhotoScanUPCState(
    val error: String,
    val isKeyboardToggled: Boolean = false,
    val tag: String = ""
) {
    companion object {
        fun initialState() = TakeAPhotoScanUPCState(
            error = "",
            tag = ""
        )
    }
}