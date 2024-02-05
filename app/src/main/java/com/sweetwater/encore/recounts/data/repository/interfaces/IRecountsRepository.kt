package com.sweetwater.encore.recounts.data.repository.interfaces

import com.sweetwater.encore.RecountLocation
import com.sweetwater.encore.RecountRequest

interface IRecountsRepository {
    suspend fun resetRecountData()
    suspend fun setCurrentRequest(recountRequest: RecountRequest)
    suspend fun setCurrentLocations(recountLocations: List<RecountLocation>)
    suspend fun getCurrentRequest(): RecountRequest
    suspend fun getCurrentLocations(): List<RecountLocation>
}