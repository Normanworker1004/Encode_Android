package com.sweetwater.encore.take_a_photo.screens;

import android.net.Uri;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.view.LifecycleCameraController;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.tooling.preview.Preview;
import coil.request.ImageRequest;
import com.sweetwater.encore.R;
import com.sweetwater.encore.take_a_photo.state.TakeAPhotoCaptureState;
import com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoCaptureViewModel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u00b5\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\t2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a8\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012H\u0007\u001a\b\u0010\u001c\u001a\u00020\u0001H\u0007\u00a8\u0006\u001d"}, d2 = {"TakeAPhotoCaptureContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "tag", "", "takeAPhotoCaptureState", "Lcom/sweetwater/encore/take_a_photo/state/TakeAPhotoCaptureState;", "handleImageCaptured", "Lkotlin/Function1;", "Landroid/net/Uri;", "Lkotlin/ParameterName;", "name", "uri", "handleCaptureError", "Landroidx/camera/core/ImageCaptureException;", "newError", "clearCapturedImage", "Lkotlin/Function0;", "uploadToGDS", "showCameraFeatures", "onKeyboardTextChanged", "text", "TakeAPhotoCaptureScreen", "viewModel", "Lcom/sweetwater/encore/take_a_photo/viewmodels/TakeAPhotoCaptureViewModel;", "onReturnToScanUPC", "onWorkflowComplete", "TakeAPhotoCaptureScreenPreview", "app_debug"})
public final class TakeAPhotoCaptureScreenKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void TakeAPhotoCaptureScreenPreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TakeAPhotoCaptureScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoCaptureViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onReturnToScanUPC, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onWorkflowComplete) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TakeAPhotoCaptureContent(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    java.lang.String tag, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.take_a_photo.state.TakeAPhotoCaptureState takeAPhotoCaptureState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.net.Uri, kotlin.Unit> handleImageCaptured, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super androidx.camera.core.ImageCaptureException, kotlin.Unit> handleCaptureError, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> clearCapturedImage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> uploadToGDS, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> showCameraFeatures, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onKeyboardTextChanged) {
    }
}