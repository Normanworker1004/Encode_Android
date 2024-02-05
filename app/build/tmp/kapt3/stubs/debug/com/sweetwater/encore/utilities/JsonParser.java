package com.sweetwater.encore.utilities;

import java.lang.reflect.Type;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a2\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00032\u0006\u0010\n\u001a\u0002H\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/sweetwater/encore/utilities/JsonParser;", "", "parseJson", "T", "json", "", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "toJson", "obj", "(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;", "app_debug"})
public abstract interface JsonParser {
    
    @org.jetbrains.annotations.Nullable
    public abstract <T extends java.lang.Object>T parseJson(@org.jetbrains.annotations.NotNull
    java.lang.String json, @org.jetbrains.annotations.NotNull
    java.lang.reflect.Type type);
    
    @org.jetbrains.annotations.Nullable
    public abstract <T extends java.lang.Object>java.lang.String toJson(T obj, @org.jetbrains.annotations.NotNull
    java.lang.reflect.Type type);
}