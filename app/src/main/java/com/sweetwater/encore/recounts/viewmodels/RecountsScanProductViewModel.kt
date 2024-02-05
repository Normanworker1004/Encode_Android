package com.sweetwater.encore.recounts.viewmodels

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto
import com.sweetwater.encore.recounts.data.mappers.toRecountLocationsList
import com.sweetwater.encore.recounts.data.mappers.toRecountRequest
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository
import com.sweetwater.encore.recounts.state.RecountsScanProductState
import com.sweetwater.encore.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecountsScanProductViewModel @Inject constructor(
    private val getEmployeeLoginDetailsUseCase: GetEmployeeLoginDetailsUseCase,
    private val recountsDataRepository: IRecountsRepository,
    private val inventoryRepository: IInventoryRepository,
    private val ioDispatcher: CoroutineDispatcher,
    savedStateHandle: SavedStateHandle,
    private val context: Context
) : ViewModel() {

    private val _recountsScanProductState = mutableStateOf(
        RecountsScanProductState.initialState()
    )
    val recountsScanProductState: State<RecountsScanProductState> = _recountsScanProductState

    private var _campusId = ""
    val campusId: String get() = _campusId

    private var _zoneId: Int = 0
    val zoneId: Int get() = _zoneId

    private var _zoneName: String = ""
    val zoneName: String get() = _zoneName

    init {
        _zoneId = savedStateHandle["zoneId"]!!
        _zoneName = savedStateHandle["zoneName"]!!
    }

    suspend fun onLaunch() {
        viewModelScope.launch {
            getUserData(context = context)
            getRecountRequestsForZone(zoneId, campusId)
        }
    }

    fun clearError() {
        _recountsScanProductState.value = recountsScanProductState.value.copy(
            error = ""
        )
    }

    suspend fun setSelectedRequestAndLocations(recountRequest: RecountRequestDto) {
        getRecountLocationsForRequest(
            recountRequestId = recountRequest.recountRequestId, campusId = campusId
        )
        recountsDataRepository.setCurrentRequest(recountRequest.toRecountRequest())
        recountsDataRepository.setCurrentLocations(recountsScanProductState.value.locations.toRecountLocationsList())
    }

    private suspend fun getRecountRequestsForZone(zoneId: Int, campusId: String) {
        inventoryRepository.getRecountRequestsForZone(zoneId, campusId).flowOn(ioDispatcher)
            .collectLatest {
                when (it) {
                    is Resource.Error -> {
                        _recountsScanProductState.value = recountsScanProductState.value.copy(
                            error = it.message!!.message
                        )
                    }

                    is Resource.Loading -> {
                        _recountsScanProductState.value = recountsScanProductState.value.copy(
                            isLoading = it.isLoading
                        )
                    }

                    is Resource.Success -> {
                        _recountsScanProductState.value = recountsScanProductState.value.copy(
                            requests = it.data!!,
                        )
                    }
                }
            }
    }

    private suspend fun getRecountLocationsForRequest(recountRequestId: Int, campusId: String) {
        inventoryRepository.getRecountLocationsForRequest(recountRequestId, campusId)
            .flowOn(ioDispatcher).collectLatest {
                when (it) {
                    is Resource.Error -> {
                        _recountsScanProductState.value = recountsScanProductState.value.copy(
                            error = it.message!!.message
                        )
                    }

                    is Resource.Loading -> {
                        _recountsScanProductState.value = recountsScanProductState.value.copy(
                            isLoading = it.isLoading
                        )
                    }

                    is Resource.Success -> {
                        _recountsScanProductState.value = recountsScanProductState.value.copy(
                            locations = it.data!!,
                        )
                    }
                }
            }
    }

    private suspend fun getUserData(context: Context) {
        getEmployeeLoginDetailsUseCase().flowOn(ioDispatcher).collectLatest {
            when (it) {
                is Resource.Error -> {
                    _recountsScanProductState.value = recountsScanProductState.value.copy(
                        error = context.getString(R.string.login_user_data_not_found_in_db_error)
                    )
                }

                is Resource.Loading -> {
                    _recountsScanProductState.value = recountsScanProductState.value.copy(
                        isLoading = it.isLoading
                    )
                }

                is Resource.Success -> {
                    _campusId = it.data!!.campusId.toString()
                }
            }
        }
    }
}