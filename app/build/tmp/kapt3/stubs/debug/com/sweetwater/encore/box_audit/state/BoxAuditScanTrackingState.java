package com.sweetwater.encore.box_audit.state;

import com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\tH\u00c6\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012\u00a8\u0006#"}, d2 = {"Lcom/sweetwater/encore/box_audit/state/BoxAuditScanTrackingState;", "", "selectedPackArea", "", "packAreaOptions", "", "boxAuditResponse", "Lcom/sweetwater/encore/external_api/boxaudit/dto/response/ScanTrackingResponse;", "isLoading", "", "errorMessage", "displayFullScreenError", "(Ljava/lang/String;Ljava/util/List;Lcom/sweetwater/encore/external_api/boxaudit/dto/response/ScanTrackingResponse;ZLjava/lang/String;Z)V", "getBoxAuditResponse", "()Lcom/sweetwater/encore/external_api/boxaudit/dto/response/ScanTrackingResponse;", "getDisplayFullScreenError", "()Z", "getErrorMessage", "()Ljava/lang/String;", "getPackAreaOptions", "()Ljava/util/List;", "getSelectedPackArea", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_debug"})
public final class BoxAuditScanTrackingState {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String selectedPackArea = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> packAreaOptions = null;
    @org.jetbrains.annotations.Nullable
    private final com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse boxAuditResponse = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String errorMessage = null;
    private final boolean displayFullScreenError = false;
    @org.jetbrains.annotations.NotNull
    public static final com.sweetwater.encore.box_audit.state.BoxAuditScanTrackingState.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.box_audit.state.BoxAuditScanTrackingState copy(@org.jetbrains.annotations.NotNull
    java.lang.String selectedPackArea, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> packAreaOptions, @org.jetbrains.annotations.Nullable
    com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse boxAuditResponse, boolean isLoading, @org.jetbrains.annotations.NotNull
    java.lang.String errorMessage, boolean displayFullScreenError) {
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
    
    public BoxAuditScanTrackingState() {
        super();
    }
    
    public BoxAuditScanTrackingState(@org.jetbrains.annotations.NotNull
    java.lang.String selectedPackArea, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> packAreaOptions, @org.jetbrains.annotations.Nullable
    com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse boxAuditResponse, boolean isLoading, @org.jetbrains.annotations.NotNull
    java.lang.String errorMessage, boolean displayFullScreenError) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSelectedPackArea() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getPackAreaOptions() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sweetwater.encore.external_api.boxaudit.dto.response.ScanTrackingResponse getBoxAuditResponse() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean isLoading() {
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
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/box_audit/state/BoxAuditScanTrackingState$Companion;", "", "()V", "initialState", "Lcom/sweetwater/encore/box_audit/state/BoxAuditScanTrackingState;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.box_audit.state.BoxAuditScanTrackingState initialState() {
            return null;
        }
    }
}