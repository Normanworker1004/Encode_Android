package com.sweetwater.encore.external_api.inventory.dto.response

import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("areaId")
    val areaId: String,

    @SerializedName("aisle")
    val aisle: String? = null,

    @SerializedName("rack")
    val rack: String? = null,

    @SerializedName("level")
    val level: String? = null,

    @SerializedName("slot")
    val slot: String? = null,

    @SerializedName("position")
    val position: Int? = null,

    @SerializedName("palletNumber")
    val palletNumber: Int? = null,

    @SerializedName("tag")
    val tag: String? = null,

    @SerializedName("isAssignable")
    val isAssignable: Boolean? = null,

    @SerializedName("isCountable")
    val isCountable: Boolean? = null,

    @SerializedName("isPickable")
    val isPickable: Boolean? = null,

    @SerializedName("isConveyable")
    val isConveyable: Boolean? = null,

    @SerializedName("zoneId")
    val zoneId: Int? = null,

    @SerializedName("slotSizeId")
    val slotSizeId: Int? = null,

    @SerializedName("buildingId")
    val buildingId: Int? = null,

    @SerializedName("shouldDeleteIfZero")
    val shouldDeleteIfZero: Boolean? = null,

    @SerializedName("placedVolume")
    val placedVolume: Int? = null
)