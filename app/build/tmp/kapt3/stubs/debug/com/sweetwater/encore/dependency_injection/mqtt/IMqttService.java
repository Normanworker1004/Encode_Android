package com.sweetwater.encore.dependency_injection.mqtt;

import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ!\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ<\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00070\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/sweetwater/encore/dependency_injection/mqtt/IMqttService;", "", "deviceIdentifier", "", "getDeviceIdentifier", "()Ljava/lang/String;", "connect", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnect", "publish", "topic", "message", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subscribe", "onMessageReceived", "Lkotlin/Function1;", "Lcom/hivemq/client/mqtt/mqtt5/message/publish/Mqtt5Publish;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface IMqttService {
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getDeviceIdentifier();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object connect(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object disconnect(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object subscribe(@org.jetbrains.annotations.NotNull
    java.lang.String topic, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish, kotlin.Unit> onMessageReceived, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object publish(@org.jetbrains.annotations.NotNull
    java.lang.String topic, @org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}