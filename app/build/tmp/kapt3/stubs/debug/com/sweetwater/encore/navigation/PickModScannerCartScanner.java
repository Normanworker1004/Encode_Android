package com.sweetwater.encore.navigation;

import androidx.navigation.NavType;
import com.sweetwater.encore.R;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/sweetwater/encore/navigation/PickModScannerCartScanner;", "Lcom/sweetwater/encore/navigation/NavigationRoute;", "()V", "backButtonBehavior", "", "getBackButtonBehavior", "()Ljava/lang/String;", "route", "getRoute", "showBackButton", "", "getShowBackButton", "()Z", "showNavBar", "getShowNavBar", "titleResourceId", "", "getTitleResourceId", "()Ljava/lang/Integer;", "app_debug"})
public final class PickModScannerCartScanner implements com.sweetwater.encore.navigation.NavigationRoute {
    @org.jetbrains.annotations.NotNull
    public static final com.sweetwater.encore.navigation.PickModScannerCartScanner INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String route = "pick_mod_cart_scanner";
    private static final int titleResourceId = com.sweetwater.encore.R.string.pickmod_scanner_cart_scanner_top_bar_menu_label;
    private static final boolean showNavBar = true;
    private static final boolean showBackButton = true;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String backButtonBehavior = "dashboard";
    
    private PickModScannerCartScanner() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getRoute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.Integer getTitleResourceId() {
        return null;
    }
    
    @java.lang.Override
    public boolean getShowNavBar() {
        return false;
    }
    
    @java.lang.Override
    public boolean getShowBackButton() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getBackButtonBehavior() {
        return null;
    }
}