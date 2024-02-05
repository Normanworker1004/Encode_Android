package com.sweetwater.encore.cart_scanner.state;

import androidx.compose.ui.graphics.painter.Painter;
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError;
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J?\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/sweetwater/encore/cart_scanner/state/CartScannerState;", "", "isKeyboardToggled", "", "cartError", "Lcom/sweetwater/encore/dependency_injection/cart_scanner/dto/CartError;", "instructions", "Lcom/sweetwater/encore/dependency_injection/cart_scanner/dto/CartScannerScreenInstructions;", "previewImage", "Landroidx/compose/ui/graphics/painter/Painter;", "isUnregistered", "(ZLcom/sweetwater/encore/dependency_injection/cart_scanner/dto/CartError;Lcom/sweetwater/encore/dependency_injection/cart_scanner/dto/CartScannerScreenInstructions;Landroidx/compose/ui/graphics/painter/Painter;Z)V", "getCartError", "()Lcom/sweetwater/encore/dependency_injection/cart_scanner/dto/CartError;", "getInstructions", "()Lcom/sweetwater/encore/dependency_injection/cart_scanner/dto/CartScannerScreenInstructions;", "()Z", "setUnregistered", "(Z)V", "getPreviewImage", "()Landroidx/compose/ui/graphics/painter/Painter;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
public final class CartScannerState {
    private final boolean isKeyboardToggled = false;
    @org.jetbrains.annotations.Nullable
    private final com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError cartError = null;
    @org.jetbrains.annotations.NotNull
    private final com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions instructions = null;
    @org.jetbrains.annotations.Nullable
    private final androidx.compose.ui.graphics.painter.Painter previewImage = null;
    private boolean isUnregistered;
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.cart_scanner.state.CartScannerState copy(boolean isKeyboardToggled, @org.jetbrains.annotations.Nullable
    com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError cartError, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions instructions, @org.jetbrains.annotations.Nullable
    androidx.compose.ui.graphics.painter.Painter previewImage, boolean isUnregistered) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public CartScannerState() {
        super();
    }
    
    public CartScannerState(boolean isKeyboardToggled, @org.jetbrains.annotations.Nullable
    com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError cartError, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions instructions, @org.jetbrains.annotations.Nullable
    androidx.compose.ui.graphics.painter.Painter previewImage, boolean isUnregistered) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean isKeyboardToggled() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError getCartError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions getInstructions() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.compose.ui.graphics.painter.Painter component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.compose.ui.graphics.painter.Painter getPreviewImage() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean isUnregistered() {
        return false;
    }
    
    public final void setUnregistered(boolean p0) {
    }
}