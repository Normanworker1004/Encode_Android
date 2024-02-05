package com.sweetwater.encore.authorization.usecases

import android.content.Context
import android.util.Log
import com.sweetwater.encore.R
import com.sweetwater.encore.UserInfoMessage
import com.sweetwater.encore.authorization.data.mappers.toLogoutRequestDto
import com.sweetwater.encore.authorization.data.mappers.toLogoutResponse
import com.sweetwater.encore.authorization.data.mappers.toUserInfoDto
import com.sweetwater.encore.authorization.data.model.logout.request.LogoutRequest
import com.sweetwater.encore.authorization.data.model.logout.response.LogoutResponse
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository
import com.sweetwater.encore.external_api.dcservice.dto.response.UserInfoDto
import com.sweetwater.encore.external_api.dcservice.remote.DcServiceAPI
import com.sweetwater.encore.utilities.ErrorMessage
import com.sweetwater.encore.utilities.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class LogoutEmployeeUseCase @Inject constructor(
    private val api: DcServiceAPI,
    private val userInfoRepository: IUserInfoRepository,
    private val context: Context,
) {
    suspend operator fun invoke(logoutRequest: LogoutRequest): Flow<Resource<LogoutResponse>> =
        flow {

            emit(Resource.Loading(true))

            try {


                val response = api.logoutUser(logoutRequest.toLogoutRequestDto())

                var logoutResponse: UserInfoDto? = null
                var userInfoDefault = UserInfoMessage.getDefaultInstance().toUserInfoDto()

                if (response.ok.isNotEmpty()) {
                    userInfoRepository.resetUserInfo()
                    logoutResponse = userInfoRepository.getUserInfo()
                }

                if (logoutResponse == userInfoDefault) {
                    emit(Resource.Success(response.toLogoutResponse()))
                } else {
                    emit(Resource.Error(ErrorMessage.LogoutErrorBasic(context.getString(R.string.logout_unable_log_out_error))))
                }

                emit(Resource.Loading(false))

            } catch (e: HttpException) {
                Log.e("AuthRepoImpl", "Sign out Error : ", e)
                emit(Resource.Loading(false))

                val errorMessage = e.message()

                val customMessage = if (errorMessage.isNullOrEmpty()) {
                    context.getString(R.string.logout_something_wrong_try_again_error)
                } else {
                    errorMessage
                }

                emit(
                    Resource.Error(
                        ErrorMessage.CustomErrorMessage(
                            errorCode = e.code(),
                            customMessage = "Error Code : ${e.code()} , $customMessage"
                        )
                    )
                )
                return@flow

            } catch (e: Exception) {

                Log.e("AuthRepoImpl", "Sign out Error : ", e)
                emit(Resource.Loading(false))

                val errorMessage = e.message

                val customMessage = if (errorMessage.isNullOrEmpty()) {
                    context.getString(R.string.logout_something_wrong_try_again_error)
                } else {
                    errorMessage
                }

                emit(
                    Resource.Error(
                        ErrorMessage.CustomErrorMessage(
                            customMessage = customMessage
                        )
                    )
                )
                return@flow

            }

        }
}