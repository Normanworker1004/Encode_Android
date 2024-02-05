package com.sweetwater.encore.take_a_photo.screens;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.tooling.preview.Preview;
import com.sweetwater.encore.R;
import com.sweetwater.encore.take_a_photo.state.TakeAPhotoScanUPCState;
import com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoScanUPCViewModel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a`\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u00072!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001aM\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\b\u0010\u0016\u001a\u00020\u0001H\u0007\u00a8\u0006\u0017"}, d2 = {"TakeAPhotoScanUPCContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "takeAPhotoScanUPCState", "Lcom/sweetwater/encore/take_a_photo/state/TakeAPhotoScanUPCState;", "onKeyboardToggled", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isToggled", "onConfirmKeyboard", "", "text", "TakeAPhotoScanUPCScreen", "viewModel", "Lcom/sweetwater/encore/take_a_photo/viewmodels/TakeAPhotoScanUPCViewModel;", "onReturnToDashboard", "Lkotlin/Function0;", "onUPCScanned", "tagText", "TakeAPhotoScanUPCScreenPreview", "app_debug"})
public final class TakeAPhotoScanUPCScreenKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void TakeAPhotoScanUPCScreenPreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TakeAPhotoScanUPCScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoScanUPCViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onReturnToDashboard, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onUPCScanned) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TakeAPhotoScanUPCContent(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.take_a_photo.state.TakeAPhotoScanUPCState takeAPhotoScanUPCState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onKeyboardToggled, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onConfirmKeyboard) {
    }
}