package com.sweetwater.encore.external_api.inventory.dto.requests

data class UploadRecountRequest(
    val serialNumber: String?,
    val countedByEmployee: Int,
    val countedQuantity: Int,
    val countStartAt: String,
    val countEndAt: String
)