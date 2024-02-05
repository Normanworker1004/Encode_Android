package com.sweetwater.encore.recounts.screens;

import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.tooling.preview.Preview;
import com.sweetwater.encore.R;
import com.sweetwater.encore.recounts.data.dto.RecountProductDto;
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto;
import com.sweetwater.encore.recounts.state.RecountsScanUPCState;
import com.sweetwater.encore.recounts.viewmodels.RecountsScanUPCViewModel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ax\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\b\u0010\u0010\u001a\u00020\u0001H\u0007\u001a`\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u000726\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0015H\u0007\u00a8\u0006\u001a"}, d2 = {"RecountsScanUPCContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lcom/sweetwater/encore/recounts/state/RecountsScanUPCState;", "onBackEvent", "Lkotlin/Function0;", "onProductClicked", "onKeyboardConfirm", "Lkotlin/Function1;", "", "onKeyboardToggled", "", "onErrorEvent", "onRecountComplete", "RecountsScanUPCPreview", "RecountsScanUPCScreen", "viewModel", "Lcom/sweetwater/encore/recounts/viewmodels/RecountsScanUPCViewModel;", "onReturnToScanLocation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "locationName", "force", "app_debug"})
public final class RecountsScanUPCScreenKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void RecountsScanUPCPreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RecountsScanUPCScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.recounts.viewmodels.RecountsScanUPCViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onReturnToScanLocation, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> onRecountComplete) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RecountsScanUPCContent(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.recounts.state.RecountsScanUPCState state, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackEvent, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onProductClicked, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onKeyboardConfirm, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onKeyboardToggled, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onErrorEvent, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onRecountComplete) {
    }
}