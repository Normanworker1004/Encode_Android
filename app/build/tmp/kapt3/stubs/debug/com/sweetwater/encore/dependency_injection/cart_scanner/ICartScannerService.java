package com.sweetwater.encore.dependency_injection.cart_scanner;

import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError;
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u0019\u0010\"\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J\u0011\u0010&\u001a\u00020\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR3\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R3\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00100\u000bX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u001aX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u001aX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Lcom/sweetwater/encore/dependency_injection/cart_scanner/ICartScannerService;", "", "cartIdentifier", "", "getCartIdentifier", "()Ljava/lang/String;", "currentInstructions", "Lcom/sweetwater/encore/dependency_injection/cart_scanner/dto/CartScannerScreenInstructions;", "getCurrentInstructions", "()Lcom/sweetwater/encore/dependency_injection/cart_scanner/dto/CartScannerScreenInstructions;", "onError", "Lkotlin/Function1;", "Lcom/sweetwater/encore/dependency_injection/cart_scanner/dto/CartError;", "Lkotlin/ParameterName;", "name", "error", "", "getOnError", "()Lkotlin/jvm/functions/Function1;", "setOnError", "(Lkotlin/jvm/functions/Function1;)V", "onInstructions", "instructions", "getOnInstructions", "setOnInstructions", "onRegistered", "Lkotlin/Function0;", "getOnRegistered", "()Lkotlin/jvm/functions/Function0;", "setOnRegistered", "(Lkotlin/jvm/functions/Function0;)V", "onUnregistered", "getOnUnregistered", "setOnUnregistered", "registerCart", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessageToCart", "message", "unregisterCart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ICartScannerService {
    
    @org.jetbrains.annotations.Nullable
    public abstract com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions getCurrentInstructions();
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getCartIdentifier();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlin.jvm.functions.Function1<com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions, kotlin.Unit> getOnInstructions();
    
    public abstract void setOnInstructions(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions, kotlin.Unit> p0);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlin.jvm.functions.Function0<kotlin.Unit> getOnUnregistered();
    
    public abstract void setOnUnregistered(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> p0);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlin.jvm.functions.Function0<kotlin.Unit> getOnRegistered();
    
    public abstract void setOnRegistered(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> p0);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlin.jvm.functions.Function1<com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError, kotlin.Unit> getOnError();
    
    public abstract void setOnError(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError, kotlin.Unit> p0);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object sendMessageToCart(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object registerCart(@org.jetbrains.annotations.NotNull
    java.lang.String cartIdentifier, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object unregisterCart(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}