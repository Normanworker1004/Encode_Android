package com.sweetwater.encore.recounts.data.repository

import androidx.datastore.core.DataStore
import com.sweetwater.encore.RecountLocation
import com.sweetwater.encore.RecountRequest
import com.sweetwater.encore.RecountsData
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import java.io.IOException

class RecountsDataStoreRepository(private val recountsDataStore: DataStore<RecountsData>) :
    IRecountsRepository {
    private val recountsDataFlow: Flow<RecountsData> = recountsDataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(RecountsData.getDefaultInstance())
            } else {
                throw exception
            }
        }

    override suspend fun resetRecountData() {
        recountsDataStore.updateData { recountData ->
            recountData.toBuilder().clear().build()
        }
    }

    override suspend fun setCurrentRequest(recountRequest: RecountRequest) {
        clearCurrentProduct()
        recountsDataStore.updateData { recountData ->
            recountData.toBuilder().setCurrentRecountRequest(recountRequest).build()
        }
    }

    override suspend fun setCurrentLocations(recountLocations: List<RecountLocation>) {
        clearCurrentLocations()
        recountsDataStore.updateData { recountData ->
            recountData.toBuilder().addAllCurrentRecountLocations(recountLocations).build()
        }
    }

    override suspend fun getCurrentLocations(): List<RecountLocation> {
        return recountsDataFlow.first().currentRecountLocationsList
    }

    override suspend fun getCurrentRequest(): RecountRequest {
        return recountsDataFlow.first().currentRecountRequest
    }

    private suspend fun clearCurrentProduct() {
        recountsDataStore.updateData { recountData ->
            recountData.toBuilder().clearCurrentRecountRequest().build()
        }
    }

    private suspend fun clearCurrentLocations() {
        recountsDataStore.updateData { recountData ->
            recountData.toBuilder().clearCurrentRecountLocations().build()
        }
    }
}