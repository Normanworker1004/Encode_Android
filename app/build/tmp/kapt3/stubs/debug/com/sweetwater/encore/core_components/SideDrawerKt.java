package com.sweetwater.encore.core_components;

import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.tooling.preview.Preview;
import com.sweetwater.encore.BuildConfig;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.data.model.login.response.UserInfo;
import com.sweetwater.encore.authorization.state.AppAuthState;
import com.sweetwater.encore.helpers.enums.CampusId;
import com.sweetwater.encore.ui.theme.AppTheme;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aB\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\b\u0010\n\u001a\u00020\u0001H\u0007\u00a8\u0006\u000b"}, d2 = {"SideDrawer", "", "isOpen", "", "appAuthState", "Lcom/sweetwater/encore/authorization/state/AppAuthState;", "onToggleSideMenu", "Lkotlin/Function0;", "onDismissSideMenu", "onLogoutAction", "SideDrawerPreview", "app_debug"})
public final class SideDrawerKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview(name = "Side Nav Drawer")
    public static final void SideDrawerPreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SideDrawer(boolean isOpen, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.state.AppAuthState appAuthState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onToggleSideMenu, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissSideMenu, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onLogoutAction) {
    }
}