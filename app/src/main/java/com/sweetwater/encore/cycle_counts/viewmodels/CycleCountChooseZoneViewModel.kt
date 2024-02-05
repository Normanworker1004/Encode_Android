package com.sweetwater.encore.cycle_counts.viewmodels

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase
import com.sweetwater.encore.cycle_counts.state.CycleCountChooseZoneState
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository
import com.sweetwater.encore.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CycleCountChooseZoneViewModel @Inject constructor(
    private val getEmployeeLoginDetailsUseCase: GetEmployeeLoginDetailsUseCase,
    private val inventoryRepository: IInventoryRepository,
    private val ioDispatcher: CoroutineDispatcher,
    context: Context,
) : ViewModel() {
    private val _cycleCountChooseZoneState = mutableStateOf(
        CycleCountChooseZoneState.initialState()
    )
    val cycleCountChooseZoneState: State<CycleCountChooseZoneState> = _cycleCountChooseZoneState

    private var _employeeId = 0
    val employeeId: Int get() = _employeeId

    private var _campusId = ""
    val campusId: String get() = _campusId

    init {
        viewModelScope.launch {
            getUserData(context)
            getCountDetailsForQuarter(
                campusId, employeeId
            )
        }
    }

    fun clearError() {
        _cycleCountChooseZoneState.value = cycleCountChooseZoneState.value.copy(
            error = ""
        )
    }

    private suspend fun getCountDetailsForQuarter(campusId: String, employeeId: Int) {
        inventoryRepository.getCountDetailsForQuarter(campusId, employeeId).flowOn(ioDispatcher)
            .collectLatest {
                when (it) {
                    is Resource.Success -> {
                        _cycleCountChooseZoneState.value = cycleCountChooseZoneState.value.copy(
                            detailsForCurrentQuarter = it.data!!,
                        )
                    }

                    is Resource.Loading -> {
                        _cycleCountChooseZoneState.value = cycleCountChooseZoneState.value.copy(
                            isLoading = it.isLoading
                        )
                    }

                    is Resource.Error -> {
                        _cycleCountChooseZoneState.value = cycleCountChooseZoneState.value.copy(
                            error = it.message!!.message
                        )
                    }
                }
            }
    }

    private suspend fun getUserData(context: Context) {
        getEmployeeLoginDetailsUseCase().flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Error -> {
                    _cycleCountChooseZoneState.value = cycleCountChooseZoneState.value.copy(
                        error = context.getString(R.string.login_user_data_not_found_in_db_error)
                    )
                }

                is Resource.Loading -> {
                    _cycleCountChooseZoneState.value = cycleCountChooseZoneState.value.copy(
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
}