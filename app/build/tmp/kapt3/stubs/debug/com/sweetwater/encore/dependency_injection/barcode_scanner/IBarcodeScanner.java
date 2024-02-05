package com.sweetwater.encore.dependency_injection.barcode_scanner;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R3\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;", "", "onBarcodeScanned", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "barcode", "", "getOnBarcodeScanned", "()Lkotlin/jvm/functions/Function1;", "setOnBarcodeScanned", "(Lkotlin/jvm/functions/Function1;)V", "app_debug"})
public abstract interface IBarcodeScanner {
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnBarcodeScanned();
    
    public abstract void setOnBarcodeScanned(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0);
}