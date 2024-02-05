package com.sweetwater.encore.take_a_photo.state;

import android.net.Uri;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003Je\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020+H\u00d6\u0001J\t\u0010,\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0012R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014\u00a8\u0006."}, d2 = {"Lcom/sweetwater/encore/take_a_photo/state/TakeAPhotoCaptureState;", "", "isLoading", "", "error", "", "descriptionText", "tagText", "capturedImage", "Landroid/net/Uri;", "showCameraFeatures", "isCaptured", "uploading", "complete", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;ZZZZ)V", "getCapturedImage", "()Landroid/net/Uri;", "getComplete", "()Z", "setComplete", "(Z)V", "getDescriptionText", "()Ljava/lang/String;", "getError", "setCaptured", "getShowCameraFeatures", "setShowCameraFeatures", "getTagText", "getUploading", "setUploading", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_debug"})
public final class TakeAPhotoCaptureState {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String error = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String descriptionText = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String tagText = null;
    @org.jetbrains.annotations.Nullable
    private final android.net.Uri capturedImage = null;
    private boolean showCameraFeatures;
    private boolean isCaptured;
    private boolean uploading;
    private boolean complete;
    @org.jetbrains.annotations.NotNull
    public static final com.sweetwater.encore.take_a_photo.state.TakeAPhotoCaptureState.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.take_a_photo.state.TakeAPhotoCaptureState copy(boolean isLoading, @org.jetbrains.annotations.NotNull
    java.lang.String error, @org.jetbrains.annotations.NotNull
    java.lang.String descriptionText, @org.jetbrains.annotations.NotNull
    java.lang.String tagText, @org.jetbrains.annotations.Nullable
    android.net.Uri capturedImage, boolean showCameraFeatures, boolean isCaptured, boolean uploading, boolean complete) {
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
    
    public TakeAPhotoCaptureState(boolean isLoading, @org.jetbrains.annotations.NotNull
    java.lang.String error, @org.jetbrains.annotations.NotNull
    java.lang.String descriptionText, @org.jetbrains.annotations.NotNull
    java.lang.String tagText, @org.jetbrains.annotations.Nullable
    android.net.Uri capturedImage, boolean showCameraFeatures, boolean isCaptured, boolean uploading, boolean complete) {
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
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescriptionText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTagText() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.net.Uri component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.net.Uri getCapturedImage() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getShowCameraFeatures() {
        return false;
    }
    
    public final void setShowCameraFeatures(boolean p0) {
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean isCaptured() {
        return false;
    }
    
    public final void setCaptured(boolean p0) {
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean getUploading() {
        return false;
    }
    
    public final void setUploading(boolean p0) {
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getComplete() {
        return false;
    }
    
    public final void setComplete(boolean p0) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/take_a_photo/state/TakeAPhotoCaptureState$Companion;", "", "()V", "initialState", "Lcom/sweetwater/encore/take_a_photo/state/TakeAPhotoCaptureState;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.take_a_photo.state.TakeAPhotoCaptureState initialState() {
            return null;
        }
    }
}