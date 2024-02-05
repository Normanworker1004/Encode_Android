package com.sweetwater.encore.utilities

import com.google.gson.annotations.SerializedName
class ValidSerialNumberResponse (
    @SerializedName("valid")
    val valid: Boolean,

    @SerializedName("failureMessage")
    val failureMessage: String,
)