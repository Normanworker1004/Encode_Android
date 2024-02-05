package com.sweetwater.encore.external_api.boxaudit.remote;

import com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse;
import retrofit2.http.GET;
import retrofit2.http.Url;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lcom/sweetwater/encore/external_api/boxaudit/remote/BoxAuditAPI;", "", "getBoxAudit", "Lcom/sweetwater/encore/external_api/boxaudit/dto/response/ScanTrackingResponse;", "boxAuditUrl", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface BoxAuditAPI {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET
    public abstract java.lang.Object getBoxAudit(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String boxAuditUrl, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse> continuation);
}