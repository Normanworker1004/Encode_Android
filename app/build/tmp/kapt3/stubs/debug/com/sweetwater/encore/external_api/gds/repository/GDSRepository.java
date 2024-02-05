package com.sweetwater.encore.external_api.gds.repository;

import android.content.Context;
import android.net.Uri;
import com.sweetwater.encore.BuildConfig;
import com.sweetwater.encore.R;
import com.sweetwater.encore.external_api.gds.dto.TakeAPhotoResponse;
import com.sweetwater.encore.external_api.gds.dto.TakeAPhotoUploadBody;
import com.sweetwater.encore.external_api.gds.remote.GDSAPI;
import com.sweetwater.encore.external_api.gds.repository.interfaces.IGDSRepository;
import com.sweetwater.encore.utilities.ErrorMessage;
import com.sweetwater.encore.utilities.Resource;
import com.sweetwater.encore.helpers.enums.GDSPath;
import kotlinx.coroutines.flow.Flow;
import retrofit2.HttpException;
import java.io.File;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0002JE\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/sweetwater/encore/external_api/gds/repository/GDSRepository;", "Lcom/sweetwater/encore/external_api/gds/repository/interfaces/IGDSRepository;", "gdsAPI", "Lcom/sweetwater/encore/external_api/gds/remote/GDSAPI;", "context", "Landroid/content/Context;", "(Lcom/sweetwater/encore/external_api/gds/remote/GDSAPI;Landroid/content/Context;)V", "getErrorMessage", "Lcom/sweetwater/encore/utilities/ErrorMessage$CustomErrorMessage;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "uploadTakeAPhotoEntry", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sweetwater/encore/utilities/Resource;", "Lcom/sweetwater/encore/external_api/gds/dto/TakeAPhotoResponse;", "tag", "", "image", "Landroid/net/Uri;", "description", "employeeId", "employeeName", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GDSRepository implements com.sweetwater.encore.external_api.gds.repository.interfaces.IGDSRepository {
    private final com.sweetwater.encore.external_api.gds.remote.GDSAPI gdsAPI = null;
    private final android.content.Context context = null;
    
    @javax.inject.Inject
    public GDSRepository(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.gds.remote.GDSAPI gdsAPI, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object uploadTakeAPhotoEntry(@org.jetbrains.annotations.NotNull
    java.lang.String tag, @org.jetbrains.annotations.NotNull
    android.net.Uri image, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String employeeId, @org.jetbrains.annotations.NotNull
    java.lang.String employeeName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.gds.dto.TakeAPhotoResponse>>> continuation) {
        return null;
    }
    
    private final com.sweetwater.encore.utilities.ErrorMessage.CustomErrorMessage getErrorMessage(java.lang.Exception e) {
        return null;
    }
}