package com.sweetwater.encore.external_api.boxaudit.repository;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.sweetwater.encore.BuildConfig;
import com.sweetwater.encore.R;
import com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse;
import com.sweetwater.encore.external_api.boxaudit.remote.BoxAuditAPI;
import com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository;
import com.sweetwater.encore.helpers.enums.BoxAuditPath;
import com.sweetwater.encore.helpers.functions.HelperFunctions;
import com.sweetwater.encore.utilities.ApiErrorResponse;
import com.sweetwater.encore.utilities.ErrorMessage;
import com.sweetwater.encore.utilities.Resource;
import kotlinx.coroutines.flow.Flow;
import retrofit2.HttpException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\f\u001a\u00060\rj\u0002`\u000eH\u0002J5\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00182\n\u0010\f\u001a\u00060\rj\u0002`\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/sweetwater/encore/external_api/boxaudit/repository/BoxAuditRepository;", "Lcom/sweetwater/encore/external_api/boxaudit/repository/interfaces/IBoxAuditRepository;", "boxAuditAPI", "Lcom/sweetwater/encore/external_api/boxaudit/remote/BoxAuditAPI;", "context", "Landroid/content/Context;", "(Lcom/sweetwater/encore/external_api/boxaudit/remote/BoxAuditAPI;Landroid/content/Context;)V", "getApiErrorResponse", "Lcom/sweetwater/encore/utilities/ApiErrorResponse;", "apiErrorString", "", "getApiErrorString", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getBoxAuditDetails", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sweetwater/encore/utilities/Resource;", "Lcom/sweetwater/encore/external_api/boxaudit/dto/response/ScanTrackingResponse;", "barcode", "selectedQuestions", "campusId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getErrorMessage", "Lcom/sweetwater/encore/utilities/ErrorMessage$CustomErrorMessage;", "apiErrorResponse", "app_debug"})
public final class BoxAuditRepository implements com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository {
    private final com.sweetwater.encore.external_api.boxaudit.remote.BoxAuditAPI boxAuditAPI = null;
    private final android.content.Context context = null;
    
    @javax.inject.Inject
    public BoxAuditRepository(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.boxaudit.remote.BoxAuditAPI boxAuditAPI, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getBoxAuditDetails(@org.jetbrains.annotations.NotNull
    java.lang.String barcode, @org.jetbrains.annotations.NotNull
    java.lang.String selectedQuestions, @org.jetbrains.annotations.NotNull
    java.lang.String campusId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse>>> continuation) {
        return null;
    }
    
    private final java.lang.String getApiErrorString(java.lang.Exception e) {
        return null;
    }
    
    private final com.sweetwater.encore.utilities.ApiErrorResponse getApiErrorResponse(java.lang.String apiErrorString) {
        return null;
    }
    
    private final com.sweetwater.encore.utilities.ErrorMessage.CustomErrorMessage getErrorMessage(java.lang.Exception e, com.sweetwater.encore.utilities.ApiErrorResponse apiErrorResponse) {
        return null;
    }
}