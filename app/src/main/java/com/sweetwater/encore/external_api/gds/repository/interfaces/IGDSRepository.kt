package com.sweetwater.encore.external_api.gds.repository.interfaces

import android.net.Uri
import com.sweetwater.encore.external_api.gds.dto.TakeAPhotoResponse
import com.sweetwater.encore.utilities.Resource
import kotlinx.coroutines.flow.Flow

interface IGDSRepository {
    suspend fun uploadTakeAPhotoEntry(tag: String, image: Uri, description: String, employeeId: String, employeeName: String): Flow<Resource<TakeAPhotoResponse>>
}