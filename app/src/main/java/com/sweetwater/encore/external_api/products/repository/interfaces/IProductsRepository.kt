package com.sweetwater.encore.external_api.products.repository.interfaces

import com.sweetwater.encore.external_api.products.dto.ProductInfo
import com.sweetwater.encore.external_api.products.dto.SerialNumbersValidationResponse
import com.sweetwater.encore.utilities.Resource
import kotlinx.coroutines.flow.Flow

interface IProductsRepository {
    suspend fun getProductInfo(productIdentifier: String): Flow<Resource<ArrayList<ProductInfo>>>
    suspend fun validateSerialNumbersForProductId(serialNumber: String, productId: Number): Flow<Resource<SerialNumbersValidationResponse>>
}