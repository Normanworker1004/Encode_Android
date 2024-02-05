package com.sweetwater.encore.helpers.enums

enum class ProductsPath(val path: String) {
    GetProductInfoByIdentifier("/product-info?identifier=:barcode"),
    ValidateSerialNumber("/serial-numbers/are-valid/?serialNumbers=:serialNumbers&productId=:productId"),
}