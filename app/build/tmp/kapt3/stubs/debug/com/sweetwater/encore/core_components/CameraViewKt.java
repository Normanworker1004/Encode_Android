package com.sweetwater.encore.core_components;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import android.widget.LinearLayout;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.LifecycleCameraController;
import androidx.camera.view.PreviewView;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.sweetwater.encore.R;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.Executor;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\bH\u0007\u001a \u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012\u001a\u0015\u0010\u001b\u001a\u00020\u001c*\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001d\u001a\n\u0010\u001e\u001a\u00020\u0012*\u00020\f\u001aJ\u0010\u001f\u001a\u00020\u0004*\u00020 2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00040\b2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"FILENAME", "", "PHOTO_EXTENSION", "CameraControls", "", "modifier", "Landroidx/compose/ui/Modifier;", "cameraUIAction", "Lkotlin/Function1;", "Lcom/sweetwater/encore/core_components/CameraUIAction;", "CameraView", "context", "Landroid/content/Context;", "cameraController", "Landroidx/camera/view/LifecycleCameraController;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "createFile", "Ljava/io/File;", "baseFolder", "format", "extension", "getOutputFileOptions", "Landroidx/camera/core/ImageCapture$OutputFileOptions;", "lensFacing", "", "photoFile", "getCameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOutputDirectory", "takePicture", "Landroidx/camera/core/ImageCapture;", "onImageCaptured", "Landroid/net/Uri;", "onError", "Landroidx/camera/core/ImageCaptureException;", "app_debug"})
public final class CameraViewKt {
    private static final java.lang.String FILENAME = "yyyy-MM-dd-HH-mm-ss-SSS";
    private static final java.lang.String PHOTO_EXTENSION = ".jpg";
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.ui.ExperimentalComposeUiApi.class})
    public static final void CameraView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    androidx.camera.view.LifecycleCameraController cameraController, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.LifecycleOwner lifecycleOwner) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CameraControls(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.core_components.CameraUIAction, kotlin.Unit> cameraUIAction) {
    }
    
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object getCameraProvider(@org.jetbrains.annotations.NotNull
    android.content.Context $this$getCameraProvider, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super androidx.camera.lifecycle.ProcessCameraProvider> p1) {
        return null;
    }
    
    public static final void takePicture(@org.jetbrains.annotations.NotNull
    androidx.camera.core.ImageCapture $this$takePicture, @org.jetbrains.annotations.NotNull
    android.content.Context context, int lensFacing, @org.jetbrains.annotations.NotNull
    androidx.camera.view.LifecycleCameraController cameraController, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.net.Uri, kotlin.Unit> onImageCaptured, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super androidx.camera.core.ImageCaptureException, kotlin.Unit> onError) {
    }
    
    @org.jetbrains.annotations.NotNull
    public static final androidx.camera.core.ImageCapture.OutputFileOptions getOutputFileOptions(int lensFacing, @org.jetbrains.annotations.NotNull
    java.io.File photoFile) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.io.File createFile(@org.jetbrains.annotations.NotNull
    java.io.File baseFolder, @org.jetbrains.annotations.NotNull
    java.lang.String format, @org.jetbrains.annotations.NotNull
    java.lang.String extension) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.io.File getOutputDirectory(@org.jetbrains.annotations.NotNull
    android.content.Context $this$getOutputDirectory) {
        return null;
    }
}