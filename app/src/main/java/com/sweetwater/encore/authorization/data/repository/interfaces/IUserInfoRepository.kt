package com.sweetwater.encore.authorization.data.repository.interfaces

import com.sweetwater.encore.external_api.dcservice.dto.response.UserInfoDto

interface IUserInfoRepository {
    suspend fun resetUserInfo()
    suspend fun setUserInfo(newUserInfo: UserInfoDto)
    suspend fun getUserInfo(): UserInfoDto
}