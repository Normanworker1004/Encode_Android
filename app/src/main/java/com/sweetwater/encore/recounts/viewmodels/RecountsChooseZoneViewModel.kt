package com.sweetwater.encore.recounts.viewmodels

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository
import com.sweetwater.encore.recounts.state.RecountsChooseZoneState
import com.sweetwater.encore.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RecountsChooseZoneViewModel @Inject constructor(
    private val getEmployeeLoginDetailsUseCase: GetEmployeeLoginDetailsUseCase,
    private val inventoryRepository: IInventoryRepository,
    private val ioDispatcher: CoroutineDispatcher,
    private val context: Context,
) : ViewModel() {
    private val _recountsChooseZoneState = mutableStateOf(
        RecountsChooseZoneState.initialState()
    )
    val recountsChooseZoneState: State<RecountsChooseZoneState> = _recountsChooseZoneState

    private var _employeeId = 0
    val employeeId: Int get() = _employeeId

    private var _campusId = ""
    val campusId: String get() = _campusId

    fun onLaunch() {
        viewModelScope.launch {
            getUserData(context)
            getRecountsDailyStatistics(campusId, employeeId)
            getRecountsSummary(campusId)
        }
    }

    fun clearError() {
        _recountsChooseZoneState.value = recountsChooseZoneState.value.copy(
            error = ""
        )
    }

    private suspend fun getUserData(context: Context) {
        getEmployeeLoginDetailsUseCase().flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Error -> {
                    _recountsChooseZoneState.value = recountsChooseZoneState.value.copy(
                        error = context.getString(R.string.login_user_data_not_found_in_db_error)
                    )
                }

                is Resource.Loading -> {
                    _recountsChooseZoneState.value = recountsChooseZoneState.value.copy(
                        isLoading = it.isLoading
                    )
                }

                is Resource.Success -> {
                    _employeeId = it.data!!.employeeId
                    _campusId = it.data!!.campusId.toString()
                }
            }
        }
    }

    private suspend fun getRecountsSummary(campusId: String) {
        inventoryRepository.getRecountsSummary(campusId).flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Error -> {
                    _recountsChooseZoneState.value = recountsChooseZoneState.value.copy(
                        error = it.message!!.message
                    )
                }

                is Resource.Loading -> {
                    _recountsChooseZoneState.value = recountsChooseZoneState.value.copy(
                        isLoading = it.isLoading
                    )
                }

                is Resource.Success -> {
                    _recountsChooseZoneState.value = recountsChooseZoneState.value.copy(
                        zones = it.data!!
                    )
                }
            }
        }
    }

    private suspend fun getRecountsDailyStatistics(campusId: String, employeeId: Int) {
        inventoryRepository.getRecountsDailyStatistics(campusId, employeeId).flowOn(ioDispatcher)
            .collectLatest {
                when (it) {
                    is Resource.Error -> {
                        _recountsChooseZoneState.value = recountsChooseZoneState.value.copy(
                            error = it.message!!.message
                        )
                    }

                    is Resource.Loading -> {
                        _recountsChooseZoneState.value = recountsChooseZoneState.value.copy(
                            isLoading = it.isLoading
                        )
                    }

                    is Resource.Success -> {
                        _recountsChooseZoneState.value = recountsChooseZoneState.value.copy(
                            displayStats = it.data!!
                        )
                    }
                }
            }
    }
}