package com.sweetwater.encore.external_api.inventory.remote;

import com.sweetwater.encore.external_api.inventory.dto.requests.RecountLocationRequest;
import com.sweetwater.encore.external_api.inventory.dto.requests.UploadProductCountsRequest;
import com.sweetwater.encore.external_api.inventory.dto.requests.UploadRecountRequest;
import com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse;
import com.sweetwater.encore.external_api.inventory.dto.response.DetailsForCurrentQuarterResponse;
import com.sweetwater.encore.external_api.inventory.dto.response.LocationResponse;
import com.sweetwater.encore.external_api.inventory.dto.response.ProductRecountLocationResponse;
import com.sweetwater.encore.recounts.data.dto.RecountLocationDto;
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto;
import com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats;
import com.sweetwater.encore.recounts.data.dto.RecountsZone;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001b\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u001f\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ+\u0010 \u001a\u00020!2\b\b\u0001\u0010\"\u001a\u00020\u00062\u000e\b\u0001\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ%\u0010%\u001a\u00020!2\b\b\u0001\u0010&\u001a\u00020\u00062\b\b\u0001\u0010\'\u001a\u00020(H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lcom/sweetwater/encore/external_api/inventory/remote/InventoryAPI;", "", "addLocationToRecount", "", "Lcom/sweetwater/encore/external_api/inventory/dto/response/ProductRecountLocationResponse;", "addLocationToRecountUrl", "", "recountLocations", "Lcom/sweetwater/encore/external_api/inventory/dto/requests/RecountLocationRequest;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assignCountRequestsForZone", "Lcom/sweetwater/encore/external_api/inventory/dto/response/AssignedLocationResponse;", "assignCountRequestUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDetailsForCurrentQuarter", "Lcom/sweetwater/encore/external_api/inventory/dto/response/DetailsForCurrentQuarterResponse;", "chooseZoneUrl", "getLocationByName", "Lcom/sweetwater/encore/external_api/inventory/dto/response/LocationResponse;", "locationByNameUrl", "getRecountLocationsForRequest", "Lcom/sweetwater/encore/recounts/data/dto/RecountLocationDto;", "recountLocationsForRequestUrl", "getRecountRequestsForZone", "Lcom/sweetwater/encore/recounts/data/dto/RecountRequestDto;", "recountRequestsForZoneUrl", "getRecountsDailyStatistics", "Lcom/sweetwater/encore/recounts/data/dto/RecountsDisplayStats;", "dailyStatisticsUrl", "getRecountsSummary", "Lcom/sweetwater/encore/recounts/data/dto/RecountsZone;", "recountsSummaryUrl", "uploadProductCountsForCountRequest", "", "uploadProductCountsRequestUrl", "uploadProductCountsRequestBody", "Lcom/sweetwater/encore/external_api/inventory/dto/requests/UploadProductCountsRequest;", "uploadProductRecountsForRecountRequest", "uploadRecountUrl", "recountRequests", "Lcom/sweetwater/encore/external_api/inventory/dto/requests/UploadRecountRequest;", "(Ljava/lang/String;Lcom/sweetwater/encore/external_api/inventory/dto/requests/UploadRecountRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface InventoryAPI {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET
    public abstract java.lang.Object getDetailsForCurrentQuarter(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String chooseZoneUrl, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sweetwater.encore.external_api.inventory.dto.response.DetailsForCurrentQuarterResponse> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST
    public abstract java.lang.Object assignCountRequestsForZone(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String assignCountRequestUrl, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST
    public abstract java.lang.Object uploadProductCountsForCountRequest(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String uploadProductCountsRequestUrl, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    java.util.List<com.sweetwater.encore.external_api.inventory.dto.requests.UploadProductCountsRequest> uploadProductCountsRequestBody, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET
    public abstract java.lang.Object getRecountsSummary(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String recountsSummaryUrl, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.sweetwater.encore.recounts.data.dto.RecountsZone>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET
    public abstract java.lang.Object getRecountsDailyStatistics(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String dailyStatisticsUrl, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET
    public abstract java.lang.Object getRecountRequestsForZone(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String recountRequestsForZoneUrl, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.sweetwater.encore.recounts.data.dto.RecountRequestDto>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET
    public abstract java.lang.Object getRecountLocationsForRequest(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String recountLocationsForRequestUrl, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.sweetwater.encore.recounts.data.dto.RecountLocationDto>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET
    public abstract java.lang.Object getLocationByName(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String locationByNameUrl, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sweetwater.encore.external_api.inventory.dto.response.LocationResponse> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST
    public abstract java.lang.Object addLocationToRecount(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String addLocationToRecountUrl, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    java.util.List<com.sweetwater.encore.external_api.inventory.dto.requests.RecountLocationRequest> recountLocations, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.sweetwater.encore.external_api.inventory.dto.response.ProductRecountLocationResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.PUT
    public abstract java.lang.Object uploadProductRecountsForRecountRequest(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String uploadRecountUrl, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.sweetwater.encore.external_api.inventory.dto.requests.UploadRecountRequest recountRequests, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}