package com.sweetwater.encore.authorization.usecases;

import android.content.Context;
import android.util.Log;
import com.sweetwater.encore.R;
import com.sweetwater.encore.UserInfoMessage;
import com.sweetwater.encore.authorization.data.model.login.response.UserInfo;
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository;
import com.sweetwater.encore.utilities.ErrorMessage;
import com.sweetwater.encore.utilities.Resource;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;", "", "userInfoRepository", "Lcom/sweetwater/encore/authorization/data/repository/interfaces/IUserInfoRepository;", "context", "Landroid/content/Context;", "(Lcom/sweetwater/encore/authorization/data/repository/interfaces/IUserInfoRepository;Landroid/content/Context;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sweetwater/encore/utilities/Resource;", "Lcom/sweetwater/encore/authorization/data/model/login/response/UserInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetEmployeeLoginDetailsUseCase {
    private final com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository userInfoRepository = null;
    private final android.content.Context context = null;
    
    @javax.inject.Inject
    public GetEmployeeLoginDetailsUseCase(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository userInfoRepository, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.sweetwater.encore.utilities.Resource<com.sweetwater.encore.authorization.data.model.login.response.UserInfo>>> continuation) {
        return null;
    }
}