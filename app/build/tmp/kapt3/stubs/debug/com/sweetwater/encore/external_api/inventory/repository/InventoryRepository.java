package com.sweetwater.encore.external_api.inventory.repository;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.sweetwater.encore.BuildConfig;
import com.sweetwater.encore.R;
import com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance;
import com.sweetwater.encore.external_api.inventory.dto.requests.RecountLocationRequest;
import com.sweetwater.encore.external_api.inventory.dto.requests.UploadProductCountsRequest;
import com.sweetwater.encore.external_api.inventory.dto.requests.UploadRecountRequest;
import com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse;
import com.sweetwater.encore.external_api.inventory.dto.response.DetailsForCurrentQuarterResponse;
import com.sweetwater.encore.external_api.inventory.dto.response.LocationResponse;
import com.sweetwater.encore.external_api.inventory.dto.response.ProductRecountLocationResponse;
import com.sweetwater.encore.external_api.inventory.remote.InventoryAPI;
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository;
import com.sweetwater.encore.helpers.enums.InventoryPath;
import com.sweetwater.encore.recounts.data.dto.RecountLocationDto;
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto;
import com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats;
import com.sweetwater.encore.recounts.data.dto.RecountsZone;
import com.sweetwater.encore.utilities.ApiErrorResponse;
import com.sweetwater.encore.utilities.ErrorMessage;
import com.sweetwater.encore.utilities.Resource;
import kotlinx.coroutines.flow.Flow;
import retrofit2.HttpException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006JC\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J;\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\t0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0002J\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00112\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001eH\u0002J-\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\t0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020#2\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001e2\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0002J-\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\t0\b2\u0006\u0010\'\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(J3\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\n0\t0\b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J3\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\n0\t0\b2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J-\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\t0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J+\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\n0\t0\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102JE\u00103\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001040\t0\b2\f\u00105\u001a\b\u0012\u0004\u0012\u0002060\n2\u0006\u00107\u001a\u0002082\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00109\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:JG\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001040\t0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020>2\u0006\u00107\u001a\u000208H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010?R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006@"}, d2 = {"Lcom/sweetwater/encore/external_api/inventory/repository/InventoryRepository;", "Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;", "inventoryAPI", "Lcom/sweetwater/encore/external_api/inventory/remote/InventoryAPI;", "context", "Landroid/content/Context;", "(Lcom/sweetwater/encore/external_api/inventory/remote/InventoryAPI;Landroid/content/Context;)V", "addLocationToRecount", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sweetwater/encore/utilities/Resource;", "", "Lcom/sweetwater/encore/external_api/inventory/dto/response/ProductRecountLocationResponse;", "locationId", "", "recountPriority", "recountRequestId", "campusId", "", "(IIILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assignCountRequestsForZone", "Lcom/sweetwater/encore/external_api/inventory/dto/response/AssignedLocationResponse;", "employeeId", "zoneId", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getApiErrorResponse", "Lcom/sweetwater/encore/utilities/ApiErrorResponse;", "apiErrorString", "getApiErrorString", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getCountDetailsForQuarter", "Lcom/sweetwater/encore/external_api/inventory/dto/response/DetailsForCurrentQuarterResponse;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getErrorMessage", "Lcom/sweetwater/encore/utilities/ErrorMessage$CustomErrorMessage;", "apiErrorResponse", "getLocationByName", "Lcom/sweetwater/encore/external_api/inventory/dto/response/LocationResponse;", "locationName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecountLocationsForRequest", "Lcom/sweetwater/encore/recounts/data/dto/RecountLocationDto;", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecountRequestsForZone", "Lcom/sweetwater/encore/recounts/data/dto/RecountRequestDto;", "getRecountsDailyStatistics", "Lcom/sweetwater/encore/recounts/data/dto/RecountsDisplayStats;", "getRecountsSummary", "Lcom/sweetwater/encore/recounts/data/dto/RecountsZone;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadProductCountsForCountRequest", "Lcom/sweetwater/encore/external_api/inventory/dto/ProductIdsWithVariance;", "requests", "Lcom/sweetwater/encore/external_api/inventory/dto/requests/UploadProductCountsRequest;", "force", "", "countRequestId", "(Ljava/util/List;ZLjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadProductRecountsForRecountRequest", "recountLocationId", "uploadRecountRequest", "Lcom/sweetwater/encore/external_api/inventory/dto/requests/UploadRecountRequest;", "(Ljava/lang/String;IILcom/sweetwater/encore/external_api/inventory/dto/requests/UploadRecountRequest;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class InventoryRepository implements com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository {
    private final com.sweetwater.encore.external_api.inventory.remote.InventoryAPI inventoryAPI = null;
    private final android.content.Context context = null;
    
    @javax.inject.Inject
    public InventoryRepository(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.inventory.remote.InventoryAPI inventoryAPI, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getCountDetailsForQuarter(@org.jetbrains.annotations.NotNull
    java.lang.String campusId, int employeeId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.inventory.dto.response.DetailsForCurrentQuarterResponse>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object assignCountRequestsForZone(@org.jetbrains.annotations.NotNull
    java.lang.String campusId, int employeeId, int zoneId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<java.util.List<com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse>>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object uploadProductCountsForCountRequest(@org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.external_api.inventory.dto.requests.UploadProductCountsRequest> requests, boolean force, @org.jetbrains.annotations.NotNull
    java.lang.String campusId, int countRequestId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getRecountsSummary(@org.jetbrains.annotations.NotNull
    java.lang.String campusId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<java.util.List<com.sweetwater.encore.recounts.data.dto.RecountsZone>>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getRecountsDailyStatistics(@org.jetbrains.annotations.NotNull
    java.lang.String campusId, int employeeId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getRecountRequestsForZone(int zoneId, @org.jetbrains.annotations.NotNull
    java.lang.String campusId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<java.util.List<com.sweetwater.encore.recounts.data.dto.RecountRequestDto>>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getRecountLocationsForRequest(int recountRequestId, @org.jetbrains.annotations.NotNull
    java.lang.String campusId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<java.util.List<com.sweetwater.encore.recounts.data.dto.RecountLocationDto>>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object uploadProductRecountsForRecountRequest(@org.jetbrains.annotations.NotNull
    java.lang.String campusId, int recountRequestId, int recountLocationId, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.inventory.dto.requests.UploadRecountRequest uploadRecountRequest, boolean force, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getLocationByName(@org.jetbrains.annotations.NotNull
    java.lang.String locationName, @org.jetbrains.annotations.NotNull
    java.lang.String campusId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.inventory.dto.response.LocationResponse>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object addLocationToRecount(int locationId, int recountPriority, int recountRequestId, @org.jetbrains.annotations.NotNull
    java.lang.String campusId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<java.util.List<com.sweetwater.encore.external_api.inventory.dto.response.ProductRecountLocationResponse>>>> continuation) {
        return null;
    }
    
    private final com.sweetwater.encore.utilities.ErrorMessage.CustomErrorMessage getErrorMessage(java.lang.Exception e, com.sweetwater.encore.utilities.ApiErrorResponse apiErrorResponse) {
        return null;
    }
    
    private final java.lang.String getApiErrorString(java.lang.Exception e) {
        return null;
    }
    
    private final com.sweetwater.encore.utilities.ApiErrorResponse getApiErrorResponse(java.lang.String apiErrorString) {
        return null;
    }
}