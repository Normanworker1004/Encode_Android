package com.sweetwater.encore.external_api.boxaudit.dto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/sweetwater/encore/external_api/boxaudit/dto/BoxAuditPackedBox;", "", "barcode", "", "invoiceId", "", "hasBluesheet", "", "bluesheetText", "packerId", "(Ljava/lang/String;IZLjava/lang/String;I)V", "getBarcode", "()Ljava/lang/String;", "getBluesheetText", "getHasBluesheet", "()Z", "getInvoiceId", "()I", "getPackerId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class BoxAuditPackedBox {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String barcode = null;
    private final int invoiceId = 0;
    private final boolean hasBluesheet = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String bluesheetText = null;
    private final int packerId = 0;
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.external_api.boxaudit.dto.BoxAuditPackedBox copy(@org.jetbrains.annotations.NotNull
    java.lang.String barcode, int invoiceId, boolean hasBluesheet, @org.jetbrains.annotations.NotNull
    java.lang.String bluesheetText, int packerId) {
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
    
    public BoxAuditPackedBox(@org.jetbrains.annotations.NotNull
    java.lang.String barcode, int invoiceId, boolean hasBluesheet, @org.jetbrains.annotations.NotNull
    java.lang.String bluesheetText, int packerId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBarcode() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getInvoiceId() {
        return 0;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean getHasBluesheet() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBluesheetText() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getPackerId() {
        return 0;
    }
}