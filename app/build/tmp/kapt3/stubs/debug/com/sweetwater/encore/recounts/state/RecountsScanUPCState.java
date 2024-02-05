package com.sweetwater.encore.recounts.state;

import com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance;
import com.sweetwater.encore.recounts.data.dto.RecountLocationDto;
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto;
import java.time.LocalDateTime;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b2\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0001FB\u00af\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u00a2\u0006\u0002\u0010\u001aJ\u000b\u00101\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\bH\u00c6\u0003J\t\u00103\u001a\u00020\bH\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\t\u00105\u001a\u00020\bH\u00c6\u0003J\t\u00106\u001a\u00020\bH\u00c6\u0003J\t\u00107\u001a\u00020\nH\u00c6\u0003J\t\u00108\u001a\u00020\nH\u00c6\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010:\u001a\u00020\bH\u00c6\u0003J\t\u0010;\u001a\u00020\nH\u00c6\u0003J\t\u0010<\u001a\u00020\fH\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\t\u0010>\u001a\u00020\bH\u00c6\u0003J\t\u0010?\u001a\u00020\bH\u00c6\u0003J\t\u0010@\u001a\u00020\nH\u00c6\u0003J\u00b5\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\nH\u00c6\u0001J\u0013\u0010B\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010D\u001a\u00020\fH\u00d6\u0001J\t\u0010E\u001a\u00020\nH\u00d6\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010\u0013\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0011\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0018\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0016\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\u0019\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010$R\u0011\u0010\u000f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\"R\u0011\u0010\u0012\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\"R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\"R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0017\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0010\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\"\u00a8\u0006G"}, d2 = {"Lcom/sweetwater/encore/recounts/state/RecountsScanUPCState;", "", "recountRequest", "Lcom/sweetwater/encore/recounts/data/dto/RecountRequestDto;", "recountLocations", "", "Lcom/sweetwater/encore/recounts/data/dto/RecountLocationDto;", "isVarianceDetected", "", "locationName", "", "countedQuantity", "", "countStartAt", "Ljava/time/LocalDateTime;", "isKeyboardToggled", "updatingQuantity", "errorMessage", "isLoading", "displayFullScreenError", "productIdsWithVariance", "Lcom/sweetwater/encore/external_api/inventory/dto/ProductIdsWithVariance;", "hasCompletedRecount", "promptForSerialNumber", "expectedSerialNumber", "inputSerialNumber", "(Lcom/sweetwater/encore/recounts/data/dto/RecountRequestDto;Ljava/util/List;ZLjava/lang/String;ILjava/time/LocalDateTime;ZZLjava/lang/String;ZZLcom/sweetwater/encore/external_api/inventory/dto/ProductIdsWithVariance;ZZLjava/lang/String;Ljava/lang/String;)V", "getCountStartAt", "()Ljava/time/LocalDateTime;", "getCountedQuantity", "()I", "setCountedQuantity", "(I)V", "getDisplayFullScreenError", "()Z", "getErrorMessage", "()Ljava/lang/String;", "getExpectedSerialNumber", "getHasCompletedRecount", "getInputSerialNumber", "getLocationName", "getProductIdsWithVariance", "()Lcom/sweetwater/encore/external_api/inventory/dto/ProductIdsWithVariance;", "getPromptForSerialNumber", "getRecountLocations", "()Ljava/util/List;", "getRecountRequest", "()Lcom/sweetwater/encore/recounts/data/dto/RecountRequestDto;", "getUpdatingQuantity", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class RecountsScanUPCState {
    @org.jetbrains.annotations.Nullable
    private final com.sweetwater.encore.recounts.data.dto.RecountRequestDto recountRequest = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.sweetwater.encore.recounts.data.dto.RecountLocationDto> recountLocations = null;
    private final boolean isVarianceDetected = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String locationName = null;
    private int countedQuantity;
    @org.jetbrains.annotations.Nullable
    private final java.time.LocalDateTime countStartAt = null;
    private final boolean isKeyboardToggled = false;
    private final boolean updatingQuantity = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String errorMessage = null;
    private final boolean isLoading = false;
    private final boolean displayFullScreenError = false;
    @org.jetbrains.annotations.Nullable
    private final com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance productIdsWithVariance = null;
    private final boolean hasCompletedRecount = false;
    private final boolean promptForSerialNumber = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String expectedSerialNumber = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String inputSerialNumber = null;
    @org.jetbrains.annotations.NotNull
    public static final com.sweetwater.encore.recounts.state.RecountsScanUPCState.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.recounts.state.RecountsScanUPCState copy(@org.jetbrains.annotations.Nullable
    com.sweetwater.encore.recounts.data.dto.RecountRequestDto recountRequest, @org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.recounts.data.dto.RecountLocationDto> recountLocations, boolean isVarianceDetected, @org.jetbrains.annotations.NotNull
    java.lang.String locationName, int countedQuantity, @org.jetbrains.annotations.Nullable
    java.time.LocalDateTime countStartAt, boolean isKeyboardToggled, boolean updatingQuantity, @org.jetbrains.annotations.NotNull
    java.lang.String errorMessage, boolean isLoading, boolean displayFullScreenError, @org.jetbrains.annotations.Nullable
    com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance productIdsWithVariance, boolean hasCompletedRecount, boolean promptForSerialNumber, @org.jetbrains.annotations.NotNull
    java.lang.String expectedSerialNumber, @org.jetbrains.annotations.NotNull
    java.lang.String inputSerialNumber) {
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
    
    public RecountsScanUPCState(@org.jetbrains.annotations.Nullable
    com.sweetwater.encore.recounts.data.dto.RecountRequestDto recountRequest, @org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.recounts.data.dto.RecountLocationDto> recountLocations, boolean isVarianceDetected, @org.jetbrains.annotations.NotNull
    java.lang.String locationName, int countedQuantity, @org.jetbrains.annotations.Nullable
    java.time.LocalDateTime countStartAt, boolean isKeyboardToggled, boolean updatingQuantity, @org.jetbrains.annotations.NotNull
    java.lang.String errorMessage, boolean isLoading, boolean displayFullScreenError, @org.jetbrains.annotations.Nullable
    com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance productIdsWithVariance, boolean hasCompletedRecount, boolean promptForSerialNumber, @org.jetbrains.annotations.NotNull
    java.lang.String expectedSerialNumber, @org.jetbrains.annotations.NotNull
    java.lang.String inputSerialNumber) {
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
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean isVarianceDetected() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocationName() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getCountedQuantity() {
        return 0;
    }
    
    public final void setCountedQuantity(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.time.LocalDateTime component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.time.LocalDateTime getCountStartAt() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean isKeyboardToggled() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean getUpdatingQuantity() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getErrorMessage() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean getDisplayFullScreenError() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sweetwater.encore.external_api.inventory.dto.ProductIdsWithVariance getProductIdsWithVariance() {
        return null;
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final boolean getHasCompletedRecount() {
        return false;
    }
    
    public final boolean component14() {
        return false;
    }
    
    public final boolean getPromptForSerialNumber() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getExpectedSerialNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getInputSerialNumber() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/recounts/state/RecountsScanUPCState$Companion;", "", "()V", "initialState", "Lcom/sweetwater/encore/recounts/state/RecountsScanUPCState;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.recounts.state.RecountsScanUPCState initialState() {
            return null;
        }
    }
}