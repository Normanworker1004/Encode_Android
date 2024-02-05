package com.sweetwater.encore.external_api.products.repository

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.sweetwater.encore.BuildConfig
import com.sweetwater.encore.R
import com.sweetwater.encore.external_api.products.dto.ProductInfo
import com.sweetwater.encore.external_api.products.dto.SerialNumbersValidationResponse
import com.sweetwater.encore.external_api.products.remote.ProductsAPI
import com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository
import com.sweetwater.encore.utilities.ErrorMessage
import com.sweetwater.encore.utilities.Resource
import com.sweetwater.encore.helpers.enums.ProductsPath
import com.sweetwater.encore.utilities.ValidSerialNumberResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val productsAPI: ProductsAPI, private val context: Context) : IProductsRepository {
    override suspend fun getProductInfo(productIdentifier: String): Flow<Resource<ArrayList<ProductInfo>>> =
        flow {
            emit(Resource.Loading(true))

            try {
                val generatedUrl = "${BuildConfig.PRODUCTS_API_BASE_URL}${ProductsPath.GetProductInfoByIdentifier.path}".replace(
                    oldValue = ":barcode",
                    newValue = productIdentifier
                )

                val productInfo = productsAPI.getProductInfo(generatedUrl)

                if (productInfo.isNotEmpty()) {
                    emit(Resource.Success(productInfo))
                } else {
                    emit(
                        Resource.Error(
                            message = ErrorMessage.CustomErrorMessage(
                                errorCode = 404,
                                customMessage = "${context.getString(R.string.cycle_count_no_product_exists_for_barcode_inline_label)} $productIdentifier."
                            ),
                            data = null
                        )
                    )
                }
            } catch (e: Exception) {
                Log.e("WorkFlowRepoImpl", "Compare and Upload Serial: ", e)
                emit(Resource.Loading(false))

                emit(
                    Resource.Error(
                        ErrorMessage.CustomErrorMessage(
                            errorCode = 500,
                            customMessage = "${context.getString(R.string.cycle_count_error_code_inline_label)}, ${context.getString(R.string.cycle_count_something_wrong_try_again_error)}"
                        )
                    )
                )
            }

            emit(Resource.Loading(false))
            return@flow
        }

    override suspend fun validateSerialNumbersForProductId(serialNumber: String, productId: Number): Flow<Resource<SerialNumbersValidationResponse>> =
        flow {
            emit(Resource.Loading(true))

            try {
                val generatedUrl = "${BuildConfig.PRODUCTS_API_BASE_URL}${ProductsPath.ValidateSerialNumber.path}".replace(
                    oldValue = ":serialNumbers",
                    newValue = serialNumber,
                ).replace(
                    oldValue = ":productId",
                    newValue = productId.toString(),
                )

                val isValidSerialNumber = productsAPI.validateSerialNumbersForProductId(generatedUrl)

                if (isValidSerialNumber.valid) {
                    emit(Resource.Success(isValidSerialNumber))
                }
            } catch (e: Exception) {
                Log.e("Products Repository", "validateSerialNumbersForProductID: ", e)
                emit(Resource.Loading(false))

                val errorMessage = getErrorMessage(e)

                emit(
                    Resource.Error(
                        message = errorMessage
                    )
                )
            }

            emit(Resource.Loading(false))
            return@flow
        }

    private fun getErrorMessage(
        e: Exception,
    ): ErrorMessage.CustomErrorMessage {
        val customMessage = if (e.message.isNullOrEmpty()) {
            context.getString(R.string.cycle_count_something_wrong_try_again_error)
        } else {
            e.message
        }

        val errorMessage = when (e) {
            is HttpException -> {
                val gson = Gson()
                val errorMessageBody = gson.fromJson(e.response()?.errorBody()?.string(), ValidSerialNumberResponse::class.java)

                ErrorMessage.CustomErrorMessage(
                    errorCode = e.code(),
                    customMessage = "${errorMessageBody.failureMessage}"
                )
            }

            else -> {
                ErrorMessage.CustomErrorMessage(
                    customMessage = "$customMessage"
                )
            }
        }

        return errorMessage
    }
}