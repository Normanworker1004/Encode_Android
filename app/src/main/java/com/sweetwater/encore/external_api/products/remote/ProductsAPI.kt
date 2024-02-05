package com.sweetwater.encore.external_api.products.remote

import com.sweetwater.encore.external_api.products.dto.ProductInfo
import com.sweetwater.encore.external_api.products.dto.SerialNumbersValidationResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface ProductsAPI {
    @GET
    suspend fun getProductInfo(@Url productInfoUrl: String): ArrayList<ProductInfo>
    @GET
    suspend fun validateSerialNumbersForProductId(@Url validateSerialNumbersForProductIdUrl: String): SerialNumbersValidationResponse
}