package com.sweetwater.encore.recounts.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.recounts.data.mappers.toRecountLocationsDtoList
import com.sweetwater.encore.recounts.data.mappers.toRecountLocationsList
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class RecountsCompleteViewModel @Inject constructor(
    private val recountsDataStoreRepository: IRecountsRepository,
) : ViewModel() {

    private var _outOfLocations: Boolean = false

    val outOfLocations: Boolean get() = _outOfLocations

    suspend fun onLaunch(locationName: String) {
        viewModelScope.launch {
            val recountLocations =
                recountsDataStoreRepository.getCurrentLocations().toRecountLocationsDtoList()
            val pendingLocations = recountLocations.toMutableList()
            pendingLocations.removeIf { it.location.name == locationName }
            recountsDataStoreRepository.setCurrentLocations(pendingLocations.toRecountLocationsList())
            if (pendingLocations.isEmpty()) {
                _outOfLocations = true
            }
        }
    }
}