package com.sweetwater.encore.recounts.data.dto

data class RecountLocationDto(
    val recountLocationId: Int,
    val priority: Int,
    val location: LocationDto,
    val note: String? = "",
    val countedByEmployee: Int? = 0,
    val expectedQuantity: Int? = 0,
    val countedQuantity: Int? = 0,
    val countStartAt: String? = "",
    val countCompletedAt: String? = "",
)

class LocationDto(
    val id: Int,
    val name: String,
)