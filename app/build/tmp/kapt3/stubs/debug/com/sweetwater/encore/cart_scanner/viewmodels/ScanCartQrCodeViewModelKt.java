package com.sweetwater.encore.cart_scanner.viewmodels;

import android.content.Context;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.R;
import com.sweetwater.encore.cart_scanner.state.ScanCartQrCodeState;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService;
import com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineDispatcher;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0002"}, d2 = {"UUID_LENGTH", "", "app_debug"})
public final class ScanCartQrCodeViewModelKt {
    private static final int UUID_LENGTH = 36;
}