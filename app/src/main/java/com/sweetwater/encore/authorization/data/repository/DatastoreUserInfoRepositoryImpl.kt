package com.sweetwater.encore.authorization.data.repository

import androidx.datastore.core.DataStore
import com.sweetwater.encore.UserInfoMessage
import com.sweetwater.encore.authorization.data.mappers.toUserInfoDto
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository
import com.sweetwater.encore.external_api.dcservice.dto.response.UserInfoDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import java.io.IOException

class DatastoreUserInfoRepositoryImpl(private val userInfoDatastore: DataStore<UserInfoMessage>):
    IUserInfoRepository {
    private val userInfoFlow: Flow<UserInfoMessage> = userInfoDatastore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(UserInfoMessage.getDefaultInstance())
            } else {
                throw exception
            }
        }

    override suspend fun resetUserInfo() {
        userInfoDatastore.updateData { userInfo ->
            userInfo.toBuilder().clear().build()
        }
    }

    override suspend fun setUserInfo(newUserInfo: UserInfoDto) {
        userInfoDatastore.updateData { userInfo ->
            userInfo.toBuilder()
                .setCampusId(newUserInfo.campusId)
                .setEmployeeId(newUserInfo.employeeId)
                .setEmployeeNumber(newUserInfo.employeeNumber)
                .setIcon(newUserInfo.icon)
                .setId(newUserInfo.id)
                .setName(newUserInfo.name)
                .setPersonalLocationId(newUserInfo.personalLocationId)
                .setPersonalLocationName(newUserInfo.personalLocationName)
                .setRole(newUserInfo.role)
                .build()
        }
    }

    override suspend fun getUserInfo() = userInfoFlow.first().toUserInfoDto()
}