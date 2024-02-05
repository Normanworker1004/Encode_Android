package com.sweetwater.encore.dependency_injection.cart_scanner.dto

import com.google.gson.annotations.SerializedName

data class ScannerTopicMessage(
    @SerializedName("action")
    val action: String,

    @SerializedName("data")
    val data: List<String>
) {
    fun getValue(key: String): String {
        val keyIndex = data.indexOf(key)

        return if (keyIndex > -1) {
            data[keyIndex + 1]
        } else {
            ""
        }
    }
}