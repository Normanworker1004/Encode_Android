package com.sweetwater.encore.recounts.screens;

import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.tooling.preview.Preview;
import com.sweetwater.encore.R;
import com.sweetwater.encore.recounts.data.dto.RecountProductDto;
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto;
import com.sweetwater.encore.recounts.state.RecountsScanProductState;
import com.sweetwater.encore.recounts.viewmodels.RecountsScanProductViewModel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a_\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\t2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\fH\u0007\u001a6\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u001a\b\u0010\u0014\u001a\u00020\u0001H\u0007\u00a8\u0006\u0015"}, d2 = {"RecountScanProductContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lcom/sweetwater/encore/recounts/state/RecountsScanProductState;", "zoneName", "", "onReturnToChooseZone", "Lkotlin/Function0;", "onClearError", "onProductClicked", "Lkotlin/Function1;", "Lcom/sweetwater/encore/recounts/data/dto/RecountRequestDto;", "Lkotlin/ParameterName;", "name", "recountRequest", "RecountsScanProductScreen", "viewModel", "Lcom/sweetwater/encore/recounts/viewmodels/RecountsScanProductViewModel;", "ScanProductScreenPreview", "app_debug"})
public final class RecountsScanProductScreenKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void ScanProductScreenPreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RecountsScanProductScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onReturnToChooseZone, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onProductClicked, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.recounts.viewmodels.RecountsScanProductViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RecountScanProductContent(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.recounts.state.RecountsScanProductState state, @org.jetbrains.annotations.NotNull
    java.lang.String zoneName, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onReturnToChooseZone, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClearError, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.recounts.data.dto.RecountRequestDto, kotlin.Unit> onProductClicked) {
    }
}