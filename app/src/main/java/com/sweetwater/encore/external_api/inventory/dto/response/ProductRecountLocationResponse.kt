package com.sweetwater.encore.external_api.inventory.dto.response

import com.google.gson.annotations.SerializedName

data class ProductRecountLocationResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("recountRequestId")
    val recountRequestId: Int,

    @SerializedName("locationId")
    val locationId: Int,

    @SerializedName("zoneId")
    val zoneId: Int,

    @SerializedName("recountPriority")
    val recountPriority: Int,

    @SerializedName("note")
    val note: String? = null,

    @SerializedName("countedByEmployee")
    val countedByEmployee: Int? = null,

    @SerializedName("expectedQuantity")
    val expectedQuantity: Int? = null,

    @SerializedName("countedQuantity")
    val countedQuantity: Int? = null,

    @SerializedName("countStartAt")
    val countStartAt: String? = null,

    @SerializedName("countCompletedAt")
    val countCompletedAt: String? = null
)