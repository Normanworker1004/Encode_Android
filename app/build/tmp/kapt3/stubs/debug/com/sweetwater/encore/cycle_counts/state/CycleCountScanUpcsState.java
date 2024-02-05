package com.sweetwater.encore.cycle_counts.state;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.sweetwater.encore.cycle_counts.dto.ProductScanInfo;
import com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 42\u00020\u0001:\u00014B{\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0012J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\t\u0010%\u001a\u00020\u0006H\u00c6\u0003J\t\u0010&\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0006H\u00c6\u0003J\t\u0010(\u001a\u00020\u0006H\u00c6\u0003J\t\u0010)\u001a\u00020\nH\u00c6\u0003J\t\u0010*\u001a\u00020\u0006H\u00c6\u0003J\t\u0010+\u001a\u00020\u0006H\u00c6\u0003J\t\u0010,\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010/\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u000202H\u00d6\u0001J\t\u00103\u001a\u00020\nH\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014\u00a8\u00065"}, d2 = {"Lcom/sweetwater/encore/cycle_counts/state/CycleCountScanUpcsState;", "", "scannedProductList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lcom/sweetwater/encore/cycle_counts/dto/ProductScanInfo;", "isLoading", "", "isKeyboardToggled", "serialNumberPrompt", "errorMessage", "", "displayFullScreenError", "updatingQuantity", "updatingSerialNumber", "editingProduct", "productIdsWithVariance", "Lcom/sweetwater/encore/external_api/inventory/dto/ProductIdsWithVariance;", "hasCompletedCount", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;ZZZLjava/lang/String;ZZZLcom/sweetwater/encore/cycle_counts/dto/ProductScanInfo;Lcom/sweetwater/encore/external_api/inventory/dto/ProductIdsWithVariance;Z)V", "getDisplayFullScreenError", "()Z", "getEditingProduct", "()Lcom/sweetwater/encore/cycle_counts/dto/ProductScanInfo;", "getErrorMessage", "()Ljava/lang/String;", "getHasCompletedCount", "getProductIdsWithVariance", "()Lcom/sweetwater/encore/external_api/inventory/dto/ProductIdsWithVariance;", "getScannedProductList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "setScannedProductList", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)V", "getSerialNumberPrompt", "getUpdatingQuantity", "getUpdatingSerialNumber", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_debug"})
public final class CycleCountScanUpcsState {
    @org.jetbrains.annotations.NotNull
    private androidx.compose.runtime.snapshots.SnapshotStateList<com.sweetwater.encore.cycle_counts.dto.ProductScanInfo> scannedProductList;
    private final boolean isLoading = false;
    private final boolean isKeyboardToggled = false;
    private final boolean serialNumberPrompt = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String errorMessage = null;
    private final boolean displayFullScreenError = false;
    private final boolean updatingQuantity = false;
    private final boolean updatingSerialNumber = false;
    @org.jetbrains.annotations.Nullable
    private final com.sweetwater.encore.cycle_counts.dto.ProductScanInfo editingProduct = null;
    @org.jetbrains.annotations.Nullable
    private final com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance productIdsWithVariance = null;
    private final boolean hasCompletedCount = false;
    @org.jetbrains.annotations.NotNull
    public static final com.sweetwater.encore.cycle_counts.state.CycleCountScanUpcsState.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.cycle_counts.state.CycleCountScanUpcsState copy(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.snapshots.SnapshotStateList<com.sweetwater.encore.cycle_counts.dto.ProductScanInfo> scannedProductList, boolean isLoading, boolean isKeyboardToggled, boolean serialNumberPrompt, @org.jetbrains.annotations.NotNull
    java.lang.String errorMessage, boolean displayFullScreenError, boolean updatingQuantity, boolean updatingSerialNumber, @org.jetbrains.annotations.Nullable
    com.sweetwater.encore.cycle_counts.dto.ProductScanInfo editingProduct, @org.jetbrains.annotations.Nullable
    com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance productIdsWithVariance, boolean hasCompletedCount) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public CycleCountScanUpcsState(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.snapshots.SnapshotStateList<com.sweetwater.encore.cycle_counts.dto.ProductScanInfo> scannedProductList, boolean isLoading, boolean isKeyboardToggled, boolean serialNumberPrompt, @org.jetbrains.annotations.NotNull
    java.lang.String errorMessage, boolean displayFullScreenError, boolean updatingQuantity, boolean updatingSerialNumber, @org.jetbrains.annotations.Nullable
    com.sweetwater.encore.cycle_counts.dto.ProductScanInfo editingProduct, @org.jetbrains.annotations.Nullable
    com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance productIdsWithVariance, boolean hasCompletedCount) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.snapshots.SnapshotStateList<com.sweetwater.encore.cycle_counts.dto.ProductScanInfo> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.snapshots.SnapshotStateList<com.sweetwater.encore.cycle_counts.dto.ProductScanInfo> getScannedProductList() {
        return null;
    }
    
    public final void setScannedProductList(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.snapshots.SnapshotStateList<com.sweetwater.encore.cycle_counts.dto.ProductScanInfo> p0) {
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean isKeyboardToggled() {
        return false;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean getSerialNumberPrompt() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getErrorMessage() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getDisplayFullScreenError() {
        return false;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean getUpdatingQuantity() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean getUpdatingSerialNumber() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sweetwater.encore.cycle_counts.dto.ProductScanInfo component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sweetwater.encore.cycle_counts.dto.ProductScanInfo getEditingProduct() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance getProductIdsWithVariance() {
        return null;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean getHasCompletedCount() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/cycle_counts/state/CycleCountScanUpcsState$Companion;", "", "()V", "initialState", "Lcom/sweetwater/encore/cycle_counts/state/CycleCountScanUpcsState;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.cycle_counts.state.CycleCountScanUpcsState initialState() {
            return null;
        }
    }
}