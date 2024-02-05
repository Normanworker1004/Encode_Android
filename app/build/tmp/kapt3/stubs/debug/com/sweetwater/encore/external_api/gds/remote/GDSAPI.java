package com.sweetwater.encore.external_api.gds.remote;

import com.sweetwater.encore.external_api.gds.dto.TakeAPhotoResponse;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/sweetwater/encore/external_api/gds/remote/GDSAPI;", "", "uploadTakeAPhotoEntry", "Lcom/sweetwater/encore/external_api/gds/dto/TakeAPhotoResponse;", "takeAPhotoUploadUrl", "", "takeAPhotoUploadBody", "Lokhttp3/RequestBody;", "(Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface GDSAPI {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST
    public abstract java.lang.Object uploadTakeAPhotoEntry(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Url
    java.lang.String takeAPhotoUploadUrl, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    okhttp3.RequestBody takeAPhotoUploadBody, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sweetwater.encore.external_api.gds.dto.TakeAPhotoResponse> continuation);
}