package com.sweetwater.encore.authorization.usecases

import android.content.Context
import android.util.Log
import com.sweetwater.encore.R
import com.sweetwater.encore.UserInfoMessage
import com.sweetwater.encore.authorization.data.mappers.toUserInfo
import com.sweetwater.encore.authorization.data.mappers.toUserInfoDto
import com.sweetwater.encore.authorization.data.model.login.response.UserInfo
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository
import com.sweetwater.encore.utilities.ErrorMessage
import com.sweetwater.encore.utilities.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetEmployeeLoginDetailsUseCase @Inject constructor(
    private val userInfoRepository: IUserInfoRepository,
    private val context: Context
) {
    suspend operator fun invoke(): Flow<Resource<UserInfo>> = flow {
        emit(Resource.Loading(true))

        try {

            var userDataFromDb = userInfoRepository.getUserInfo()
            var userInfoDefault = UserInfoMessage.getDefaultInstance().toUserInfoDto()

            if (userDataFromDb == userInfoDefault) {
                emit(Resource.Error(message = ErrorMessage.UserNotFoundInDbError(context.getString(R.string.login_user_data_not_found_in_db_error))))
            } else {
                emit(Resource.Success(data = userDataFromDb.toUserInfo()))
            }

            emit(Resource.Loading(false))

        } catch (e: Exception) {
            Log.e("AuthRepoImpl", "Fetch User Error : ", e)
            emit(Resource.Loading(false))
            emit(Resource.Error(ErrorMessage.CustomErrorMessage(customMessage = context.getString(R.string.login_something_wrong_try_again_error))))
            return@flow
        }

    }
}