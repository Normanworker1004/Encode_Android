package com.sweetwater.encore.external_api.products.dto

data class SerialNumbersValidationResponse(
    val valid: Boolean,
    val failureMessage: String,
)