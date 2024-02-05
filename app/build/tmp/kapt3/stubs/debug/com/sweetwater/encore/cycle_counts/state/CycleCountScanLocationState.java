package com.sweetwater.encore.cycle_counts.state;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\bH\u00c6\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003JH\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\bH\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\""}, d2 = {"Lcom/sweetwater/encore/cycle_counts/state/CycleCountScanLocationState;", "", "isLoading", "", "assignedLocations", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lcom/sweetwater/encore/external_api/inventory/dto/response/AssignedLocationResponse;", "error", "", "locationMatched", "keyboardToggled", "(ZLandroidx/compose/runtime/snapshots/SnapshotStateList;Ljava/lang/String;Ljava/lang/Boolean;Z)V", "getAssignedLocations", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "getError", "()Ljava/lang/String;", "()Z", "getKeyboardToggled", "getLocationMatched", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(ZLandroidx/compose/runtime/snapshots/SnapshotStateList;Ljava/lang/String;Ljava/lang/Boolean;Z)Lcom/sweetwater/encore/cycle_counts/state/CycleCountScanLocationState;", "equals", "other", "hashCode", "", "toString", "Companion", "app_debug"})
public final class CycleCountScanLocationState {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.snapshots.SnapshotStateList<com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse> assignedLocations = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String error = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Boolean locationMatched = null;
    private final boolean keyboardToggled = false;
    @org.jetbrains.annotations.NotNull
    public static final com.sweetwater.encore.cycle_counts.state.CycleCountScanLocationState.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.cycle_counts.state.CycleCountScanLocationState copy(boolean isLoading, @org.jetbrains.annotations.NotNull
    androidx.compose.runtime.snapshots.SnapshotStateList<com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse> assignedLocations, @org.jetbrains.annotations.NotNull
    java.lang.String error, @org.jetbrains.annotations.Nullable
    java.lang.Boolean locationMatched, boolean keyboardToggled) {
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
    
    public CycleCountScanLocationState(boolean isLoading, @org.jetbrains.annotations.NotNull
    androidx.compose.runtime.snapshots.SnapshotStateList<com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse> assignedLocations, @org.jetbrains.annotations.NotNull
    java.lang.String error, @org.jetbrains.annotations.Nullable
    java.lang.Boolean locationMatched, boolean keyboardToggled) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.snapshots.SnapshotStateList<com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.snapshots.SnapshotStateList<com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse> getAssignedLocations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getLocationMatched() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getKeyboardToggled() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/cycle_counts/state/CycleCountScanLocationState$Companion;", "", "()V", "initialState", "Lcom/sweetwater/encore/cycle_counts/state/CycleCountScanLocationState;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.cycle_counts.state.CycleCountScanLocationState initialState() {
            return null;
        }
    }
}