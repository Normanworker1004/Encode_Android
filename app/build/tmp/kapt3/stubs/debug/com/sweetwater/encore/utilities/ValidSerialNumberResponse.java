package com.sweetwater.encore.utilities;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/sweetwater/encore/utilities/ValidSerialNumberResponse;", "", "valid", "", "failureMessage", "", "(ZLjava/lang/String;)V", "getFailureMessage", "()Ljava/lang/String;", "getValid", "()Z", "app_debug"})
public final class ValidSerialNumberResponse {
    @com.google.gson.annotations.SerializedName(value = "valid")
    private final boolean valid = false;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "failureMessage")
    private final java.lang.String failureMessage = null;
    
    public ValidSerialNumberResponse(boolean valid, @org.jetbrains.annotations.NotNull
    java.lang.String failureMessage) {
        super();
    }
    
    public final boolean getValid() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFailureMessage() {
        return null;
    }
}