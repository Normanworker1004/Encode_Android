package com.sweetwater.encore.recounts.data.serializer;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sweetwater.encore.RecountsData;
import java.io.InputStream;
import java.io.OutputStream;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/sweetwater/encore/recounts/data/serializer/RecountsDataSerializer;", "Landroidx/datastore/core/Serializer;", "Lcom/sweetwater/encore/RecountsData;", "()V", "defaultValue", "getDefaultValue", "()Lcom/sweetwater/encore/RecountsData;", "readFrom", "input", "Ljava/io/InputStream;", "(Ljava/io/InputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeTo", "", "t", "output", "Ljava/io/OutputStream;", "(Lcom/sweetwater/encore/RecountsData;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RecountsDataSerializer implements androidx.datastore.core.Serializer<com.sweetwater.encore.RecountsData> {
    @org.jetbrains.annotations.NotNull
    public static final com.sweetwater.encore.recounts.data.serializer.RecountsDataSerializer INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static final com.sweetwater.encore.RecountsData defaultValue = null;
    
    private RecountsDataSerializer() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.sweetwater.encore.RecountsData getDefaultValue() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object readFrom(@org.jetbrains.annotations.NotNull
    java.io.InputStream input, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sweetwater.encore.RecountsData> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object writeTo(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.RecountsData t, @org.jetbrains.annotations.NotNull
    java.io.OutputStream output, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}