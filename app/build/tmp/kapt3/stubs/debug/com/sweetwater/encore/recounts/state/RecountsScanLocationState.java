package com.sweetwater.encore.recounts.state;

import com.sweetwater.encore.recounts.data.dto.RecountLocationDto;
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 12\u00020\u0001:\u00011B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\bH\u00c6\u0003J\t\u0010\"\u001a\u00020\u000bH\u00c6\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010%\u001a\u00020\bH\u00c6\u0003J\t\u0010&\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\'\u001a\u00020\u000bH\u00c6\u0003J\t\u0010(\u001a\u00020\u000bH\u00c6\u0003J\t\u0010)\u001a\u00020\bH\u00c6\u0003J\t\u0010*\u001a\u00020\u000bH\u00c6\u0003J\u0081\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010,\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020/H\u00d6\u0001J\t\u00100\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0010\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\r\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016\u00a8\u00062"}, d2 = {"Lcom/sweetwater/encore/recounts/state/RecountsScanLocationState;", "", "recountRequest", "Lcom/sweetwater/encore/recounts/data/dto/RecountRequestDto;", "recountLocations", "", "Lcom/sweetwater/encore/recounts/data/dto/RecountLocationDto;", "matchedLocation", "", "error", "displayFullscreenError", "", "showDialog", "isKeyboardToggled", "additionalLocationName", "addingLocation", "addLocationError", "isLoading", "(Lcom/sweetwater/encore/recounts/data/dto/RecountRequestDto;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;ZLjava/lang/String;Z)V", "getAddLocationError", "()Ljava/lang/String;", "getAddingLocation", "()Z", "getAdditionalLocationName", "getDisplayFullscreenError", "getError", "getMatchedLocation", "getRecountLocations", "()Ljava/util/List;", "getRecountRequest", "()Lcom/sweetwater/encore/recounts/data/dto/RecountRequestDto;", "getShowDialog", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_debug"})
public final class RecountsScanLocationState {
    @org.jetbrains.annotations.Nullable
    private final com.sweetwater.encore.recounts.data.dto.RecountRequestDto recountRequest = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.sweetwater.encore.recounts.data.dto.RecountLocationDto> recountLocations = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String matchedLocation = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String error = null;
    private final boolean displayFullscreenError = false;
    private final boolean showDialog = false;
    private final boolean isKeyboardToggled = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String additionalLocationName = null;
    private final boolean addingLocation = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String addLocationError = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull
    public static final com.sweetwater.encore.recounts.state.RecountsScanLocationState.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.recounts.state.RecountsScanLocationState copy(@org.jetbrains.annotations.Nullable
    com.sweetwater.encore.recounts.data.dto.RecountRequestDto recountRequest, @org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.recounts.data.dto.RecountLocationDto> recountLocations, @org.jetbrains.annotations.Nullable
    java.lang.String matchedLocation, @org.jetbrains.annotations.NotNull
    java.lang.String error, boolean displayFullscreenError, boolean showDialog, boolean isKeyboardToggled, @org.jetbrains.annotations.NotNull
    java.lang.String additionalLocationName, boolean addingLocation, @org.jetbrains.annotations.NotNull
    java.lang.String addLocationError, boolean isLoading) {
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
    
    public RecountsScanLocationState(@org.jetbrains.annotations.Nullable
    com.sweetwater.encore.recounts.data.dto.RecountRequestDto recountRequest, @org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.recounts.data.dto.RecountLocationDto> recountLocations, @org.jetbrains.annotations.Nullable
    java.lang.String matchedLocation, @org.jetbrains.annotations.NotNull
    java.lang.String error, boolean displayFullscreenError, boolean showDialog, boolean isKeyboardToggled, @org.jetbrains.annotations.NotNull
    java.lang.String additionalLocationName, boolean addingLocation, @org.jetbrains.annotations.NotNull
    java.lang.String addLocationError, boolean isLoading) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sweetwater.encore.recounts.data.dto.RecountRequestDto component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sweetwater.encore.recounts.data.dto.RecountRequestDto getRecountRequest() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.sweetwater.encore.recounts.data.dto.RecountLocationDto> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.sweetwater.encore.recounts.data.dto.RecountLocationDto> getRecountLocations() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMatchedLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getError() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getDisplayFullscreenError() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getShowDialog() {
        return false;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean isKeyboardToggled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAdditionalLocationName() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getAddingLocation() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAddLocationError() {
        return null;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/recounts/state/RecountsScanLocationState$Companion;", "", "()V", "initialState", "Lcom/sweetwater/encore/recounts/state/RecountsScanLocationState;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.recounts.state.RecountsScanLocationState initialState() {
            return null;
        }
    }
}