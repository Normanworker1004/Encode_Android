package com.sweetwater.encore.box_audit.screens;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.sweetwater.encore.R;
import com.sweetwater.encore.box_audit.BoxAuditUIEvent;
import com.sweetwater.encore.box_audit.state.BoxAuditScanTrackingState;
import com.sweetwater.encore.box_audit.viewmodels.BoxAuditScanTrackingViewModel;
import com.sweetwater.encore.ui.theme.AppTheme;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a(\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007\u001ab\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0003\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\"\u001a;\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0013H\u0003\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\'\u0010(\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"BoxAuditScanTrackingContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lcom/sweetwater/encore/box_audit/state/BoxAuditScanTrackingState;", "boxAuditUIEvent", "Lkotlin/Function1;", "Lcom/sweetwater/encore/box_audit/BoxAuditUIEvent;", "BoxAuditScanTrackingScreen", "onBackEvent", "Lkotlin/Function0;", "viewModel", "Lcom/sweetwater/encore/box_audit/viewmodels/BoxAuditScanTrackingViewModel;", "CustomTab", "selectedItemIndex", "", "items", "", "", "tabWidth", "Landroidx/compose/ui/unit/Dp;", "onClick", "Lkotlin/ParameterName;", "name", "index", "CustomTab-2lqI77k", "(ILjava/util/List;Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function1;)V", "MyTabIndicator", "indicatorWidth", "indicatorOffset", "indicatorColor", "Landroidx/compose/ui/graphics/Color;", "MyTabIndicator-y62ob04", "(FFJ)V", "MyTabItem", "isSelected", "", "text", "MyTabItem-d8LSEHM", "(ZLkotlin/jvm/functions/Function0;FLjava/lang/String;)V", "app_debug"})
public final class ScanTrackingScreenKt {
    
    @androidx.compose.runtime.Composable
    public static final void BoxAuditScanTrackingScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackEvent, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.box_audit.viewmodels.BoxAuditScanTrackingViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void BoxAuditScanTrackingContent(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.box_audit.state.BoxAuditScanTrackingState state, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.box_audit.BoxAuditUIEvent, kotlin.Unit> boxAuditUIEvent) {
    }
}