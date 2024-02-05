package com.sweetwater.encore.authorization.data.repository.interfaces;

import com.sweetwater.encore.external_api.dcservice.dto.response.UserInfoDto;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/sweetwater/encore/authorization/data/repository/interfaces/IUserInfoRepository;", "", "getUserInfo", "Lcom/sweetwater/encore/external_api/dcservice/dto/response/UserInfoDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetUserInfo", "", "setUserInfo", "newUserInfo", "(Lcom/sweetwater/encore/external_api/dcservice/dto/response/UserInfoDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface IUserInfoRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object resetUserInfo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object setUserInfo(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.dcservice.dto.response.UserInfoDto newUserInfo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserInfo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sweetwater.encore.external_api.dcservice.dto.response.UserInfoDto> continuation);
}