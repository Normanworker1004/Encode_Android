package com.sweetwater.encore.dependency_injection.barcode_scanner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import com.cipherlab.barcode.GeneralString;
import com.cipherlab.barcode.ReaderManager;
import com.cipherlab.barcode.decoder.BcReaderType;
import com.cipherlab.barcode.decoder.Enable_State;
import com.cipherlab.barcode.decoder.IlluminationPowerLevel;
import com.cipherlab.barcode.decoderparams.NotificationParams;
import com.cipherlab.barcode.decoderparams.UserPreference;
import com.cipherlab.barcodebase.ReaderCallback;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R5\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/sweetwater/encore/dependency_injection/barcode_scanner/BarcodeScanner;", "Lcom/cipherlab/barcodebase/ReaderCallback;", "Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dataReceiver", "Landroid/content/BroadcastReceiver;", "onBarcodeScanned", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "barcode", "", "getOnBarcodeScanned", "()Lkotlin/jvm/functions/Function1;", "setOnBarcodeScanned", "(Lkotlin/jvm/functions/Function1;)V", "readerCallback", "readerManager", "Lcom/cipherlab/barcode/ReaderManager;", "asBinder", "Landroid/os/IBinder;", "onDecodeComplete", "decodedText", "app_debug"})
public final class BarcodeScanner implements com.cipherlab.barcodebase.ReaderCallback, com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner {
    private com.cipherlab.barcode.ReaderManager readerManager;
    private com.cipherlab.barcodebase.ReaderCallback readerCallback;
    private final android.content.BroadcastReceiver dataReceiver = null;
    @org.jetbrains.annotations.NotNull
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onBarcodeScanned;
    
    @javax.inject.Inject
    public BarcodeScanner(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnBarcodeScanned() {
        return null;
    }
    
    @java.lang.Override
    public void setOnBarcodeScanned(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.os.IBinder asBinder() {
        return null;
    }
    
    @java.lang.Override
    public void onDecodeComplete(@org.jetbrains.annotations.Nullable
    java.lang.String decodedText) {
    }
}