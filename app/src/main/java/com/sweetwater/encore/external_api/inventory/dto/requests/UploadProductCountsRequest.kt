package com.sweetwater.encore.external_api.inventory.dto.requests

data class UploadProductCountsRequest (
    val productId: Int,
    val countedByEmployee: Int,
    val countedQuantity: Int,
    val serialNumber: String?,
    val countStartAt: String,
    val countEndAt: String,
    val isQuantityKeyed: Boolean,
    val isItemIdKeyed: Boolean
)