package com.sweetwater.encore.utilities

// Wrapper for Handing all API requests
sealed class Resource<T>(
    val data: T? = null,
    val message: ErrorMessage? = null,
    val isLoading: Boolean = false
) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: ErrorMessage?, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(isLoading: Boolean = true) :
        Resource<T>(
            data = null,
            message = null,
            isLoading = isLoading
        )
}

sealed class ErrorMessage(var message: String) {

    class InvalidInput(invalidInputMessage: String) :
        ErrorMessage(message = invalidInputMessage)

    class LoginErrorBasic(loginErrorBasicMessage: String) : ErrorMessage(message = loginErrorBasicMessage)
    class LogoutErrorBasic(logoutErrorBasicMessage: String) : ErrorMessage(message = logoutErrorBasicMessage)
    class UserNotFoundInDbError(userNotFoundInDbErrorMessage: String) : ErrorMessage(message = userNotFoundInDbErrorMessage)
    class EmptyEmployeeNumberInputError(emptyEmployeeNumberInputErrorMessage: String) :
        ErrorMessage(message = emptyEmployeeNumberInputErrorMessage)

    class ServerError(serverErrorMessage: String) : ErrorMessage(message = serverErrorMessage)
    data class CustomErrorMessage(
        val errorCode: Int = -1,
        val customMessage: String) : ErrorMessage(message = customMessage)



}

