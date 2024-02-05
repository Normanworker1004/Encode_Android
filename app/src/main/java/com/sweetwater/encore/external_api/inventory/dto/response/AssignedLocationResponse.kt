package com.sweetwater.encore.external_api.inventory.dto.response

import com.google.gson.annotations.SerializedName

data class AssignedLocationResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("cycleCountQuarterId")
    val cycleCountQuarterId: Int,

    @SerializedName("location")
    val location: CycleCountLocation,

    @SerializedName("currentEmployeeId")
    val currentEmployeeId: Int,
)

data class CycleCountLocation(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String
)