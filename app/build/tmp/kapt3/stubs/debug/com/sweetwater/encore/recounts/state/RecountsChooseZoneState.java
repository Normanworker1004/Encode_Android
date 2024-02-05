package com.sweetwater.encore.recounts.state;

import com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats;
import com.sweetwater.encore.recounts.data.dto.RecountsZone;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/sweetwater/encore/recounts/state/RecountsChooseZoneState;", "", "isLoading", "", "error", "", "displayStats", "Lcom/sweetwater/encore/recounts/data/dto/RecountsDisplayStats;", "zones", "", "Lcom/sweetwater/encore/recounts/data/dto/RecountsZone;", "(ZLjava/lang/String;Lcom/sweetwater/encore/recounts/data/dto/RecountsDisplayStats;Ljava/util/List;)V", "getDisplayStats", "()Lcom/sweetwater/encore/recounts/data/dto/RecountsDisplayStats;", "getError", "()Ljava/lang/String;", "()Z", "getZones", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_debug"})
public final class RecountsChooseZoneState {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String error = null;
    @org.jetbrains.annotations.NotNull
    private final com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats displayStats = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.sweetwater.encore.recounts.data.dto.RecountsZone> zones = null;
    @org.jetbrains.annotations.NotNull
    public static final com.sweetwater.encore.recounts.state.RecountsChooseZoneState.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.recounts.state.RecountsChooseZoneState copy(boolean isLoading, @org.jetbrains.annotations.NotNull
    java.lang.String error, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats displayStats, @org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.recounts.data.dto.RecountsZone> zones) {
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
    
    public RecountsChooseZoneState(boolean isLoading, @org.jetbrains.annotations.NotNull
    java.lang.String error, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats displayStats, @org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.recounts.data.dto.RecountsZone> zones) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.recounts.data.dto.RecountsDisplayStats getDisplayStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.sweetwater.encore.recounts.data.dto.RecountsZone> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.sweetwater.encore.recounts.data.dto.RecountsZone> getZones() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/recounts/state/RecountsChooseZoneState$Companion;", "", "()V", "initialState", "Lcom/sweetwater/encore/recounts/state/RecountsChooseZoneState;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.recounts.state.RecountsChooseZoneState initialState() {
            return null;
        }
    }
}