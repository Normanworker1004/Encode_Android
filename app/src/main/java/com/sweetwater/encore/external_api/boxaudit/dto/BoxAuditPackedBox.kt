package com.sweetwater.encore.external_api.boxaudit.dto

data class BoxAuditPackedBox(
    val barcode: String,
    val invoiceId: Int,
    val hasBluesheet: Boolean,
    val bluesheetText: String,
    val packerId: Int
)
