package com.sweetwater.encore.external_api.products.remote;

import com.sweetwater.encore.external_api.products.dto.ProductInfo;
import com.sweetwater.encore.external_api.products.dto.SerialNumbersValidationResponse;
import retrofit2.http.GET;
import retrofit2.http.Url;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u001b\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/sweetwater/encore/external_api/products/remote/ProductsAPI;", "", "getProductInfo", "Ljava/util/ArrayList;", "Lcom/sweetwater/encore/external_api/products/dto/ProductInfo;", "Lkotlin/collections/ArrayList;", "productInfoUrl", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateSerialNumbersForProductId", "Lcom/sweetwater/encore/external_api/products/dto/SerialNumbersValidationResponse;", "validateSerialNumbersForProductIdUrl", "app_debug"})
public abstract interface ProductsAPI {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET
    public abstract java.lang.Object getProductInfo(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String productInfoUrl, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.sweetwater.encore.external_api.products.dto.ProductInfo>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET
    public abstract java.lang.Object validateSerialNumbersForProductId(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String validateSerialNumbersForProductIdUrl, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sweetwater.encore.external_api.products.dto.SerialNumbersValidationResponse> continuation);
}