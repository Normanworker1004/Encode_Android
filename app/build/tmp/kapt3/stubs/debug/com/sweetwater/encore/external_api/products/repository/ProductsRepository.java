package com.sweetwater.encore.external_api.products.repository;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.sweetwater.encore.BuildConfig;
import com.sweetwater.encore.R;
import com.sweetwater.encore.external_api.products.dto.ProductInfo;
import com.sweetwater.encore.external_api.products.dto.SerialNumbersValidationResponse;
import com.sweetwater.encore.external_api.products.remote.ProductsAPI;
import com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository;
import com.sweetwater.encore.utilities.ErrorMessage;
import com.sweetwater.encore.utilities.Resource;
import com.sweetwater.encore.helpers.enums.ProductsPath;
import com.sweetwater.encore.utilities.ValidSerialNumberResponse;
import kotlinx.coroutines.flow.Flow;
import retrofit2.HttpException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0002J5\u0010\f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00110\u000e0\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000e0\r2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/sweetwater/encore/external_api/products/repository/ProductsRepository;", "Lcom/sweetwater/encore/external_api/products/repository/interfaces/IProductsRepository;", "productsAPI", "Lcom/sweetwater/encore/external_api/products/remote/ProductsAPI;", "context", "Landroid/content/Context;", "(Lcom/sweetwater/encore/external_api/products/remote/ProductsAPI;Landroid/content/Context;)V", "getErrorMessage", "Lcom/sweetwater/encore/utilities/ErrorMessage$CustomErrorMessage;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getProductInfo", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sweetwater/encore/utilities/Resource;", "Ljava/util/ArrayList;", "Lcom/sweetwater/encore/external_api/products/dto/ProductInfo;", "Lkotlin/collections/ArrayList;", "productIdentifier", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateSerialNumbersForProductId", "Lcom/sweetwater/encore/external_api/products/dto/SerialNumbersValidationResponse;", "serialNumber", "productId", "", "(Ljava/lang/String;Ljava/lang/Number;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ProductsRepository implements com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository {
    private final com.sweetwater.encore.external_api.products.remote.ProductsAPI productsAPI = null;
    private final android.content.Context context = null;
    
    @javax.inject.Inject
    public ProductsRepository(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.products.remote.ProductsAPI productsAPI, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getProductInfo(@org.jetbrains.annotations.NotNull
    java.lang.String productIdentifier, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<java.util.ArrayList<com.sweetwater.encore.external_api.products.dto.ProductInfo>>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object validateSerialNumbersForProductId(@org.jetbrains.annotations.NotNull
    java.lang.String serialNumber, @org.jetbrains.annotations.NotNull
    java.lang.Number productId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.products.dto.SerialNumbersValidationResponse>>> continuation) {
        return null;
    }
    
    private final com.sweetwater.encore.utilities.ErrorMessage.CustomErrorMessage getErrorMessage(java.lang.Exception e) {
        return null;
    }
}