package com.sweetwater.encore.external_api.dcservice.remote;

import com.sweetwater.encore.external_api.dcservice.dto.request.LoginRequestDto;
import com.sweetwater.encore.external_api.dcservice.dto.request.LogoutRequestDto;
import com.sweetwater.encore.external_api.dcservice.dto.response.LogoutResponseDto;
import com.sweetwater.encore.external_api.dcservice.dto.response.UserInfoDto;
import retrofit2.http.Body;
import retrofit2.http.POST;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/sweetwater/encore/external_api/dcservice/remote/DcServiceAPI;", "", "loginUser", "Lcom/sweetwater/encore/external_api/dcservice/dto/response/UserInfoDto;", "loginRequest", "Lcom/sweetwater/encore/external_api/dcservice/dto/request/LoginRequestDto;", "(Lcom/sweetwater/encore/external_api/dcservice/dto/request/LoginRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logoutUser", "Lcom/sweetwater/encore/external_api/dcservice/dto/response/LogoutResponseDto;", "logoutRequest", "Lcom/sweetwater/encore/external_api/dcservice/dto/request/LogoutRequestDto;", "(Lcom/sweetwater/encore/external_api/dcservice/dto/request/LogoutRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface DcServiceAPI {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "dcLoginUser")
    public abstract java.lang.Object loginUser(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.sweetwater.encore.external_api.dcservice.dto.request.LoginRequestDto loginRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sweetwater.encore.external_api.dcservice.dto.response.UserInfoDto> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "dcLogoutUser")
    public abstract java.lang.Object logoutUser(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.sweetwater.encore.external_api.dcservice.dto.request.LogoutRequestDto logoutRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sweetwater.encore.external_api.dcservice.dto.response.LogoutResponseDto> continuation);
}