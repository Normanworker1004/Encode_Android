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

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/core_components/CameraUIAction;", "", "()V", "OnCameraClick", "Lcom/sweetwater/encore/core_components/CameraUIAction$OnCameraClick;", "app_debug"})
public abstract class CameraUIAction {
    
    private CameraUIAction() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/sweetwater/encore/core_components/CameraUIAction$OnCameraClick;", "Lcom/sweetwater/encore/core_components/CameraUIAction;", "()V", "app_debug"})
    public static final class OnCameraClick extends com.sweetwater.encore.core_components.CameraUIAction {
        @org.jetbrains.annotations.NotNull
        public static final com.sweetwater.encore.core_components.CameraUIAction.OnCameraClick INSTANCE = null;
        
        private OnCameraClick() {
            super();
        }
    }
}