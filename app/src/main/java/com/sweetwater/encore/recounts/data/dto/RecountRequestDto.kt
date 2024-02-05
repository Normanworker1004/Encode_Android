package com.sweetwater.encore.recounts.data.dto

import com.sweetwater.encore.external_api.products.dto.ProductBoxDto

data class RecountRequestDto(
    val recountRequestId: Int,
    val priority: Int,
    val requestedByEmployee: Int,
    val requestedDate: String,
    val requestedStatus: String,
    val completedAt: String,
    val product: RecountProductDto,
)

class RecountProductDto(
    val id: Int,
    val serialNumber: String?,
    val name: String,
    val description: String,
    val manufacturer: String,
    val imageURL: String,
    val productIdentifiers: List<String>,
    val productBoxes: List<ProductBoxDto>,
)