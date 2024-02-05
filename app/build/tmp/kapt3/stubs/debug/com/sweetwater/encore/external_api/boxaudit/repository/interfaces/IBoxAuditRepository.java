package com.sweetwater.encore.external_api.boxaudit.repository.interfaces;

import com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse;
import com.sweetwater.encore.utilities.Resource;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/sweetwater/encore/external_api/boxaudit/repository/interfaces/IBoxAuditRepository;", "", "getBoxAuditDetails", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sweetwater/encore/utilities/Resource;", "Lcom/sweetwater/encore/external_api/boxaudit/dto/response/ScanTrackingResponse;", "barcode", "", "selectedQuestions", "campusId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface IBoxAuditRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getBoxAuditDetails(@org.jetbrains.annotations.NotNull
    java.lang.String barcode, @org.jetbrains.annotations.NotNull
    java.lang.String selectedQuestions, @org.jetbrains.annotations.NotNull
    java.lang.String campusId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse>>> continuation);
}