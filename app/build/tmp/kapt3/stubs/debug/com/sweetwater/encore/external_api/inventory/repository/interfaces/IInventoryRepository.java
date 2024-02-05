package com.sweetwater.encore.external_api.inventory.repository.interfaces;

import com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance;
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
import com.sweetwater.encore.utilities.Resource;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JC\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ;\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u00040\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J-\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00040\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J-\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00040\u00032\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J3\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00050\u00040\u00032\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ3\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00040\u00032\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ-\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00040\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J+\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00050\u00040\u00032\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#JE\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u00040\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010*\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+JG\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u00040\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/2\u0006\u0010(\u001a\u00020)H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00100\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2 = {"Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;", "", "addLocationToRecount", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sweetwater/encore/utilities/Resource;", "", "Lcom/sweetwater/encore/external_api/inventory/dto/response/ProductRecountLocationResponse;", "locationId", "", "recountPriority", "recountRequestId", "campusId", "", "(IIILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assignCountRequestsForZone", "Lcom/sweetwater/encore/external_api/inventory/dto/response/AssignedLocationResponse;", "employeeId", "zoneId", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCountDetailsForQuarter", "Lcom/sweetwater/encore/external_api/inventory/dto/response/DetailsForCurrentQuarterResponse;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocationByName", "Lcom/sweetwater/encore/external_api/inventory/dto/response/LocationResponse;", "locationName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecountLocationsForRequest", "Lcom/sweetwater/encore/recounts/data/dto/RecountLocationDto;", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecountRequestsForZone", "Lcom/sweetwater/encore/recounts/data/dto/RecountRequestDto;", "getRecountsDailyStatistics", "Lcom/sweetwater/encore/recounts/data/dto/RecountsDisplayStats;", "getRecountsSummary", "Lcom/sweetwater/encore/recounts/data/dto/RecountsZone;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadProductCountsForCountRequest", "Lcom/sweetwater/encore/external_api/inventory/dto/ProductIdsWithVariance;", "requests", "Lcom/sweetwater/encore/external_api/inventory/dto/requests/UploadProductCountsRequest;", "force", "", "countRequestId", "(Ljava/util/List;ZLjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadProductRecountsForRecountRequest", "recountLocationId", "uploadRecountRequest", "Lcom/sweetwater/encore/external_api/inventory/dto/requests/UploadRecountRequest;", "(Ljava/lang/String;IILcom/sweetwater/encore/external_api/inventory/dto/requests/UploadRecountRequest;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface IInventoryRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCountDetailsForQuarter(@org.jetbrains.annotations.NotNull
    java.lang.String campusId, int employeeId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.inventory.dto.response.DetailsForCurrentQuarterResponse>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object assignCountRequestsForZone(@org.jetbrains.annotations.NotNull
    java.lang.String campusId, int employeeId, int zoneId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<java.util.List<com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse>>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object uploadProductCountsForCountRequest(@org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.external_api.inventory.dto.requests.UploadProductCountsRequest> requests, boolean force, @org.jetbrains.annotations.NotNull
    java.lang.String campusId, int countRequestId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecountsSummary(@org.jetbrains.annotations.NotNull
    java.lang.String campusId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<java.util.List<com.sweetwater.encore.recounts.data.dto.RecountsZone>>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecountsDailyStatistics(@org.jetbrains.annotations.NotNull
    java.lang.String campusId, int employeeId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecountRequestsForZone(int zoneId, @org.jetbrains.annotations.NotNull
    java.lang.String campusId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<java.util.List<com.sweetwater.encore.recounts.data.dto.RecountRequestDto>>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecountLocationsForRequest(int recountRequestId, @org.jetbrains.annotations.NotNull
    java.lang.String campusId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<java.util.List<com.sweetwater.encore.recounts.data.dto.RecountLocationDto>>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object uploadProductRecountsForRecountRequest(@org.jetbrains.annotations.NotNull
    java.lang.String campusId, int recountRequestId, int recountLocationId, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.inventory.dto.requests.UploadRecountRequest uploadRecountRequest, boolean force, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLocationByName(@org.jetbrains.annotations.NotNull
    java.lang.String locationName, @org.jetbrains.annotations.NotNull
    java.lang.String campusId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.inventory.dto.response.LocationResponse>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addLocationToRecount(int locationId, int recountPriority, int recountRequestId, @org.jetbrains.annotations.NotNull
    java.lang.String campusId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<java.util.List<com.sweetwater.encore.external_api.inventory.dto.response.ProductRecountLocationResponse>>>> continuation);
}