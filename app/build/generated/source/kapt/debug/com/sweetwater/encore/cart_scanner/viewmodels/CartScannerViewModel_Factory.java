package com.sweetwater.encore.cart_scanner.viewmodels;

import android.content.Context;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService;
import com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class CartScannerViewModel_Factory implements Factory<CartScannerViewModel> {
  private final Provider<Context> contextProvider;

  private final Provider<ICartScannerService> cartScannerServiceProvider;

  private final Provider<IBarcodeScanner> barcodeScannerProvider;

  private final Provider<IConnectivityService> connectivityServiceProvider;

  private final Provider<ISoundService> soundServiceProvider;

  private final Provider<IVibratorService> vibratorServiceProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  public CartScannerViewModel_Factory(Provider<Context> contextProvider,
      Provider<ICartScannerService> cartScannerServiceProvider,
      Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<IConnectivityService> connectivityServiceProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<IVibratorService> vibratorServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    this.contextProvider = contextProvider;
    this.cartScannerServiceProvider = cartScannerServiceProvider;
    this.barcodeScannerProvider = barcodeScannerProvider;
    this.connectivityServiceProvider = connectivityServiceProvider;
    this.soundServiceProvider = soundServiceProvider;
    this.vibratorServiceProvider = vibratorServiceProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
  }

  @Override
  public CartScannerViewModel get() {
    return newInstance(contextProvider.get(), cartScannerServiceProvider.get(), barcodeScannerProvider.get(), connectivityServiceProvider.get(), soundServiceProvider.get(), vibratorServiceProvider.get(), ioDispatcherProvider.get());
  }

  public static CartScannerViewModel_Factory create(Provider<Context> contextProvider,
      Provider<ICartScannerService> cartScannerServiceProvider,
      Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<IConnectivityService> connectivityServiceProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<IVibratorService> vibratorServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    return new CartScannerViewModel_Factory(contextProvider, cartScannerServiceProvider, barcodeScannerProvider, connectivityServiceProvider, soundServiceProvider, vibratorServiceProvider, ioDispatcherProvider);
  }

  public static CartScannerViewModel newInstance(Context context,
      ICartScannerService cartScannerService, IBarcodeScanner barcodeScanner,
      IConnectivityService connectivityService, ISoundService soundService,
      IVibratorService vibratorService, CoroutineDispatcher ioDispatcher) {
    return new CartScannerViewModel(context, cartScannerService, barcodeScanner, connectivityService, soundService, vibratorService, ioDispatcher);
  }
}
