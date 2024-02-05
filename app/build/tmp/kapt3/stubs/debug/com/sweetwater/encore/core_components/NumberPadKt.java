package com.sweetwater.encore.core_components;

import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.tooling.preview.Preview;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.data.enums.SignInMode;
import com.sweetwater.encore.authorization.data.model.login.request.LoginRequest;
import com.sweetwater.encore.authorization.AppAuthEvent;
import com.sweetwater.encore.authorization.LoginUIEvent;
import com.sweetwater.encore.authorization.state.LoginUIState;
import com.sweetwater.encore.ui.theme.AppTheme;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a8\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a\b\u0010\f\u001a\u00020\u0001H\u0007\u001a>\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\b\u00a8\u0006\u000f"}, d2 = {"NumButton", "", "numberGridPositionIndex", "", "NumberPad", "loginUIState", "Lcom/sweetwater/encore/authorization/state/LoginUIState;", "loginUIEvent", "Lkotlin/Function1;", "Lcom/sweetwater/encore/authorization/LoginUIEvent;", "appAuthEvent", "Lcom/sweetwater/encore/authorization/AppAuthEvent;", "NumberPadPreview", "numPadActionHandler", "gridIndex", "app_debug"})
public final class NumberPadKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void NumberPadPreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void NumberPad(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.state.LoginUIState loginUIState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.authorization.LoginUIEvent, kotlin.Unit> loginUIEvent, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.authorization.AppAuthEvent, kotlin.Unit> appAuthEvent) {
    }
    
    public static final void numPadActionHandler(int gridIndex, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.authorization.LoginUIEvent, kotlin.Unit> loginUIEvent, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.state.LoginUIState loginUIState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.authorization.AppAuthEvent, kotlin.Unit> appAuthEvent) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void NumButton(int numberGridPositionIndex) {
    }
}