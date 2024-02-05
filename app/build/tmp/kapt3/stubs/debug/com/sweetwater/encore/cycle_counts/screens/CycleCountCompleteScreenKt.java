package com.sweetwater.encore.cycle_counts.screens;

import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.tooling.preview.Preview;
import com.sweetwater.encore.R;
import com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\b\u0010\b\u001a\u00020\u0001H\u0007\u001a4\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u00a8\u0006\r"}, d2 = {"CycleCountCompleteContent", "", "locationName", "", "varianceReported", "", "onNavigateToScanLocation", "Lkotlin/Function0;", "CycleCountCompletePreview", "CycleCountCompleteScreen", "locationsList", "", "Lcom/sweetwater/encore/external_api/inventory/dto/response/AssignedLocationResponse;", "app_debug"})
public final class CycleCountCompleteScreenKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void CycleCountCompletePreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CycleCountCompleteScreen(@org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.external_api.inventory.dto.response.AssignedLocationResponse> locationsList, @org.jetbrains.annotations.NotNull
    java.lang.String locationName, boolean varianceReported, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToScanLocation) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CycleCountCompleteContent(@org.jetbrains.annotations.NotNull
    java.lang.String locationName, boolean varianceReported, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToScanLocation) {
    }
}