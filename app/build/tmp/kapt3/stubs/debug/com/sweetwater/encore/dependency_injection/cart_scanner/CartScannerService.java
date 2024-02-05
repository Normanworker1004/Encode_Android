package com.sweetwater.encore.dependency_injection.cart_scanner;

import androidx.compose.ui.text.input.KeyboardType;
import com.google.gson.Gson;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError;
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions;
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.DecodedCartMessage;
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.ScannerTopicMessage;
import com.sweetwater.encore.dependency_injection.mqtt.IMqttService;
import java.nio.charset.StandardCharsets;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00100\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0019\u00101\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J\u0019\u00103\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J\u0011\u00104\u001a\u00020\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00105J\u0011\u00106\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00105R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R5\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R5\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0010X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u001fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150\u001fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00067"}, d2 = {"Lcom/sweetwater/encore/dependency_injection/cart_scanner/CartScannerService;", "Lcom/sweetwater/encore/dependency_injection/cart_scanner/ICartScannerService;", "mqttService", "Lcom/sweetwater/encore/dependency_injection/mqtt/IMqttService;", "(Lcom/sweetwater/encore/dependency_injection/mqtt/IMqttService;)V", "_cartIdentifier", "", "_currentInstructions", "Lcom/sweetwater/encore/dependency_injection/cart_scanner/dto/CartScannerScreenInstructions;", "cartIdentifier", "getCartIdentifier", "()Ljava/lang/String;", "currentInstructions", "getCurrentInstructions", "()Lcom/sweetwater/encore/dependency_injection/cart_scanner/dto/CartScannerScreenInstructions;", "onError", "Lkotlin/Function1;", "Lcom/sweetwater/encore/dependency_injection/cart_scanner/dto/CartError;", "Lkotlin/ParameterName;", "name", "error", "", "getOnError", "()Lkotlin/jvm/functions/Function1;", "setOnError", "(Lkotlin/jvm/functions/Function1;)V", "onInstructions", "instructions", "getOnInstructions", "setOnInstructions", "onRegistered", "Lkotlin/Function0;", "getOnRegistered", "()Lkotlin/jvm/functions/Function0;", "setOnRegistered", "(Lkotlin/jvm/functions/Function0;)V", "onUnregistered", "getOnUnregistered", "setOnUnregistered", "handleErrorMessage", "Lcom/sweetwater/encore/dependency_injection/cart_scanner/dto/DecodedCartMessage;", "scannerTopicMessage", "Lcom/sweetwater/encore/dependency_injection/cart_scanner/dto/ScannerTopicMessage;", "handleInstructMessage", "handleMqttMessagesFromScannerTopic", "message", "Lcom/hivemq/client/mqtt/mqtt5/message/publish/Mqtt5Publish;", "handleRegisterMessage", "handleUnregisterMessage", "registerCart", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessageToCart", "subscribeToScannersTopic", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterCart", "app_debug"})
public final class CartScannerService implements com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService {
    private final com.sweetwater.encore.dependency_injection.mqtt.IMqttService mqttService = null;
    private com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions _currentInstructions;
    private java.lang.String _cartIdentifier = "";
    @org.jetbrains.annotations.NotNull
    private kotlin.jvm.functions.Function1<? super com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions, kotlin.Unit> onInstructions;
    @org.jetbrains.annotations.NotNull
    private kotlin.jvm.functions.Function0<kotlin.Unit> onUnregistered;
    @org.jetbrains.annotations.NotNull
    private kotlin.jvm.functions.Function0<kotlin.Unit> onRegistered;
    @org.jetbrains.annotations.NotNull
    private kotlin.jvm.functions.Function1<? super com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError, kotlin.Unit> onError;
    
    @javax.inject.Inject
    public CartScannerService(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.mqtt.IMqttService mqttService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions getCurrentInstructions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getCartIdentifier() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.jvm.functions.Function1<com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions, kotlin.Unit> getOnInstructions() {
        return null;
    }
    
    @java.lang.Override
    public void setOnInstructions(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.jvm.functions.Function0<kotlin.Unit> getOnUnregistered() {
        return null;
    }
    
    @java.lang.Override
    public void setOnUnregistered(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.jvm.functions.Function0<kotlin.Unit> getOnRegistered() {
        return null;
    }
    
    @java.lang.Override
    public void setOnRegistered(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.jvm.functions.Function1<com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError, kotlin.Unit> getOnError() {
        return null;
    }
    
    @java.lang.Override
    public void setOnError(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object sendMessageToCart(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object registerCart(@org.jetbrains.annotations.NotNull
    java.lang.String cartIdentifier, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object unregisterCart(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object subscribeToScannersTopic(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final com.sweetwater.encore.dependency_injection.cart_scanner.dto.DecodedCartMessage handleMqttMessagesFromScannerTopic(com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish message) {
        return null;
    }
    
    private final com.sweetwater.encore.dependency_injection.cart_scanner.dto.DecodedCartMessage handleRegisterMessage(com.sweetwater.encore.dependency_injection.cart_scanner.dto.ScannerTopicMessage scannerTopicMessage) {
        return null;
    }
    
    private final com.sweetwater.encore.dependency_injection.cart_scanner.dto.DecodedCartMessage handleUnregisterMessage(com.sweetwater.encore.dependency_injection.cart_scanner.dto.ScannerTopicMessage scannerTopicMessage) {
        return null;
    }
    
    private final com.sweetwater.encore.dependency_injection.cart_scanner.dto.DecodedCartMessage handleErrorMessage(com.sweetwater.encore.dependency_injection.cart_scanner.dto.ScannerTopicMessage scannerTopicMessage) {
        return null;
    }
    
    private final com.sweetwater.encore.dependency_injection.cart_scanner.dto.DecodedCartMessage handleInstructMessage(com.sweetwater.encore.dependency_injection.cart_scanner.dto.ScannerTopicMessage scannerTopicMessage) {
        return null;
    }
}