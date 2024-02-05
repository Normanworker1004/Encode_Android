package com.sweetwater.encore.external_api.inventory.dto.requests

data class RecountLocationRequest(
    val locationId: Int,
    val recountPriority: Int
)