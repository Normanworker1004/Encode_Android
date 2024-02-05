package com.sweetwater.encore.external_api.inventory.dto.response;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/sweetwater/encore/external_api/inventory/dto/response/AssignedLocationResponse;", "", "id", "", "cycleCountQuarterId", "location", "Lcom/sweetwater/encore/external_api/inventory/dto/response/CycleCountLocation;", "currentEmployeeId", "(IILcom/sweetwater/encore/external_api/inventory/dto/response/CycleCountLocation;I)V", "getCurrentEmployeeId", "()I", "getCycleCountQuarterId", "getId", "getLocation", "()Lcom/sweetwater/encore/external_api/inventory/dto/response/CycleCountLocation;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class AssignedLocationResponse {
    @com.google.gson.annotations.SerializedName(value = "id")
    private final int id = 0;
    @com.google.gson.annotations.SerializedName(value = "cycleCountQuarterId")
    private final int cycleCountQuarterId = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "location")
    private final com.sweetwater.encore.external_api.inventory.dto.response.CycleCountLocation location = null;
    @com.google.gson.annotations.SerializedName(value = "currentEmployeeId")
    private final int currentEmployeeId = 0;
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse copy(int id, int cycleCountQuarterId, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.inventory.dto.response.CycleCountLocation location, int currentEmployeeId) {
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
    
    public AssignedLocationResponse(int id, int cycleCountQuarterId, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.inventory.dto.response.CycleCountLocation location, int currentEmployeeId) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getCycleCountQuarterId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.external_api.inventory.dto.response.CycleCountLocation component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.external_api.inventory.dto.response.CycleCountLocation getLocation() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getCurrentEmployeeId() {
        return 0;
    }
}