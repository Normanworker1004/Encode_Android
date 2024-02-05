package com.sweetwater.encore.authorization.screens;

import androidx.compose.animation.ExperimentalAnimationApi;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.data.enums.SignInMode;
import com.sweetwater.encore.authorization.data.model.login.request.LoginRequest;
import com.sweetwater.encore.authorization.AppAuthEvent;
import com.sweetwater.encore.authorization.state.AppAuthState;
import com.sweetwater.encore.authorization.LoginUIEvent;
import com.sweetwater.encore.authorization.state.LoginUIState;
import com.sweetwater.encore.ui.theme.AppTheme;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001af\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001aB\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u00a8\u0006\u0011"}, d2 = {"LoginScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "loginUIEvent", "Lkotlin/Function1;", "Lcom/sweetwater/encore/authorization/LoginUIEvent;", "loginUIState", "Lcom/sweetwater/encore/authorization/state/LoginUIState;", "appAuthEvent", "Lcom/sweetwater/encore/authorization/AppAuthEvent;", "appAuthState", "Lcom/sweetwater/encore/authorization/state/AppAuthState;", "onLogin", "Lkotlin/Function0;", "onExitApp", "OtpViewWithNumPad", "app_debug"})
public final class LoginScreenKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.animation.ExperimentalAnimationApi
    public static final void LoginScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.authorization.LoginUIEvent, kotlin.Unit> loginUIEvent, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.state.LoginUIState loginUIState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.authorization.AppAuthEvent, kotlin.Unit> appAuthEvent, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.state.AppAuthState appAuthState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onLogin, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onExitApp) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalAnimationApi.class})
    public static final void OtpViewWithNumPad(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.state.LoginUIState loginUIState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.authorization.LoginUIEvent, kotlin.Unit> loginUIEvent, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.authorization.AppAuthEvent, kotlin.Unit> appAuthEvent) {
    }
}