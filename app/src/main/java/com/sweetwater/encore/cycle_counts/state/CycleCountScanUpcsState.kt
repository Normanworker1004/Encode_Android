package com.sweetwater.encore.cycle_counts.state

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.sweetwater.encore.cycle_counts.dto.ProductScanInfo
import com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance

data class CycleCountScanUpcsState(
    var scannedProductList: SnapshotStateList<ProductScanInfo>,
    val isLoading: Boolean = false,
    val isKeyboardToggled: Boolean = false,
    val serialNumberPrompt: Boolean = false,
    val errorMessage: String = "",
    val displayFullScreenError: Boolean = false,
    val updatingQuantity: Boolean = false,
    val updatingSerialNumber: Boolean = false,
    val editingProduct: ProductScanInfo? = null,
    val productIdsWithVariance: ProductIdsWithVariance? = null,
    val hasCompletedCount: Boolean = false,
) {
    companion object {
        fun initialState() = CycleCountScanUpcsState(
            scannedProductList = SnapshotStateList(),
        )
    }
}