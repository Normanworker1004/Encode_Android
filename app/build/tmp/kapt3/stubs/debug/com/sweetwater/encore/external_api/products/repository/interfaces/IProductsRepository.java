package com.sweetwater.encore.external_api.products.repository.interfaces;

import com.sweetwater.encore.external_api.products.dto.ProductInfo;
import com.sweetwater.encore.external_api.products.dto.SerialNumbersValidationResponse;
import com.sweetwater.encore.utilities.Resource;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00070\u00040\u00032\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ-\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00040\u00032\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/sweetwater/encore/external_api/products/repository/interfaces/IProductsRepository;", "", "getProductInfo", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sweetwater/encore/utilities/Resource;", "Ljava/util/ArrayList;", "Lcom/sweetwater/encore/external_api/products/dto/ProductInfo;", "Lkotlin/collections/ArrayList;", "productIdentifier", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateSerialNumbersForProductId", "Lcom/sweetwater/encore/external_api/products/dto/SerialNumbersValidationResponse;", "serialNumber", "productId", "", "(Ljava/lang/String;Ljava/lang/Number;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface IProductsRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getProductInfo(@org.jetbrains.annotations.NotNull
    java.lang.String productIdentifier, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<java.util.ArrayList<com.sweetwater.encore.external_api.products.dto.ProductInfo>>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object validateSerialNumbersForProductId(@org.jetbrains.annotations.NotNull
    java.lang.String serialNumber, @org.jetbrains.annotations.NotNull
    java.lang.Number productId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.products.dto.SerialNumbersValidationResponse>>> continuation);
}