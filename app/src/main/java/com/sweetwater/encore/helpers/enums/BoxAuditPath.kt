package com.sweetwater.encore.helpers.enums

enum class BoxAuditPath(val path: String) {
    GetBoxAudit("/audit?barcode=:shippingLabelBarcode&selectedQuestions=:questionScope "),
}