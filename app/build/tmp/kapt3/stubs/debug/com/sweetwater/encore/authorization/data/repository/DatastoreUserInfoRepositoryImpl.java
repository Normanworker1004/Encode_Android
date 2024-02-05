package com.sweetwater.encore.authorization.data.repository;

import androidx.datastore.core.DataStore;
import com.sweetwater.encore.UserInfoMessage;
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository;
import com.sweetwater.encore.external_api.dcservice.dto.response.UserInfoDto;
import kotlinx.coroutines.flow.Flow;
import java.io.IOException;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/sweetwater/encore/authorization/data/repository/DatastoreUserInfoRepositoryImpl;", "Lcom/sweetwater/encore/authorization/data/repository/interfaces/IUserInfoRepository;", "userInfoDatastore", "Landroidx/datastore/core/DataStore;", "Lcom/sweetwater/encore/UserInfoMessage;", "(Landroidx/datastore/core/DataStore;)V", "userInfoFlow", "Lkotlinx/coroutines/flow/Flow;", "getUserInfo", "Lcom/sweetwater/encore/external_api/dcservice/dto/response/UserInfoDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetUserInfo", "", "setUserInfo", "newUserInfo", "(Lcom/sweetwater/encore/external_api/dcservice/dto/response/UserInfoDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class DatastoreUserInfoRepositoryImpl implements com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository {
    private final androidx.datastore.core.DataStore<com.sweetwater.encore.UserInfoMessage> userInfoDatastore = null;
    private final kotlinx.coroutines.flow.Flow<com.sweetwater.encore.UserInfoMessage> userInfoFlow = null;
    
    public DatastoreUserInfoRepositoryImpl(@org.jetbrains.annotations.NotNull
    androidx.datastore.core.DataStore<com.sweetwater.encore.UserInfoMessage> userInfoDatastore) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object resetUserInfo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object setUserInfo(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.dcservice.dto.response.UserInfoDto newUserInfo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getUserInfo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sweetwater.encore.external_api.dcservice.dto.response.UserInfoDto> continuation) {
        return null;
    }
}