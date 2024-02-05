package com.sweetwater.encore.authorization.usecases

import android.content.Context
import android.util.Log
import com.sweetwater.encore.R
import com.sweetwater.encore.UserInfoMessage
import com.sweetwater.encore.authorization.data.mappers.toLoginRequestDto
import com.sweetwater.encore.authorization.data.mappers.toUserInfo
import com.sweetwater.encore.authorization.data.mappers.toUserInfoDto
import com.sweetwater.encore.authorization.data.model.login.request.LoginRequest
import com.sweetwater.encore.authorization.data.model.login.response.UserInfo
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository
import com.sweetwater.encore.external_api.dcservice.remote.DcServiceAPI
import com.sweetwater.encore.utilities.ErrorMessage
import com.sweetwater.encore.utilities.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class LoginEmployeeUseCase @Inject constructor(
    private val api: DcServiceAPI,
    private val userInfoRepository: IUserInfoRepository,
    private val context: Context,
) {
    suspend operator fun invoke(loginRequest: LoginRequest): Flow<Resource<UserInfo>> =
        flow {

            if (loginRequest.employeeNumber.toString() == "0") {
                emit(
                    Resource.Error(
                        message = ErrorMessage.EmptyEmployeeNumberInputError(
                            context.getString(
                                R.string.login_empty_employee_number_input_error
                            )
                        )
                    )
                )
                emit(Resource.Loading(false))
                return@flow
            }

            emit(Resource.Loading(true))

            try {

                val response = api.loginUser(loginRequest.toLoginRequestDto())
                val userInfoDefault = UserInfoMessage.getDefaultInstance().toUserInfoDto()

                userInfoRepository.resetUserInfo()
                userInfoRepository.setUserInfo(response)
                val loginResponse = userInfoRepository.getUserInfo()

                if (loginResponse == userInfoDefault) {
                    emit(Resource.Error(ErrorMessage.UserNotFoundInDbError(context.getString(R.string.login_user_data_not_found_in_db_error))))

                } else {
                    emit(Resource.Success(loginResponse.toUserInfo()))
                }

                emit(Resource.Loading(false))

            } catch (e: HttpException) {
                Log.e("AuthRepoImpl", "Login  Error : ", e)
                emit(Resource.Loading(false))

                val errorMessage = e.message()

                val customMessage = if (errorMessage.isNullOrEmpty()) {
                    context.getString(R.string.login_user_data_not_found_in_db_error)
                } else {
                    errorMessage
                }

                emit(
                    Resource.Error(
                        ErrorMessage.CustomErrorMessage(
                            errorCode = e.code(),
                            customMessage = "${context.getString(R.string.login_error_code_inline_label)} ${e.code()} , $customMessage"
                        )
                    )
                )
                return@flow
            } catch (e: Exception) {

                Log.e("AuthRepoImpl", "Sign In Error : ", e)
                emit(Resource.Loading(false))

                val errorMessage = e.message

                val customMessage = if (errorMessage.isNullOrEmpty()) {
                    context.getString(R.string.login_something_wrong_try_again_error)
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