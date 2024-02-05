package com.sweetwater.encore.external_api.gds.repository.interfaces;

import android.net.Uri;
import com.sweetwater.encore.external_api.gds.dto.TakeAPhotoResponse;
import com.sweetwater.encore.utilities.Resource;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JE\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/sweetwater/encore/external_api/gds/repository/interfaces/IGDSRepository;", "", "uploadTakeAPhotoEntry", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sweetwater/encore/utilities/Resource;", "Lcom/sweetwater/encore/external_api/gds/dto/TakeAPhotoResponse;", "tag", "", "image", "Landroid/net/Uri;", "description", "employeeId", "employeeName", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface IGDSRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object uploadTakeAPhotoEntry(@org.jetbrains.annotations.NotNull
    java.lang.String tag, @org.jetbrains.annotations.NotNull
    android.net.Uri image, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String employeeId, @org.jetbrains.annotations.NotNull
    java.lang.String employeeName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.external_api.gds.dto.TakeAPhotoResponse>>> continuation);
}