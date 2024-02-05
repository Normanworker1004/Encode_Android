package com.sweetwater.encore.take_a_photo.viewmodels;

import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class TakeAPhotoScanUPCViewModel_Factory implements Factory<TakeAPhotoScanUPCViewModel> {
  private final Provider<IBarcodeScanner> barcodeScannerProvider;

  public TakeAPhotoScanUPCViewModel_Factory(Provider<IBarcodeScanner> barcodeScannerProvider) {
    this.barcodeScannerProvider = barcodeScannerProvider;
  }

  @Override
  public TakeAPhotoScanUPCViewModel get() {
    return newInstance(barcodeScannerProvider.get());
  }

  public static TakeAPhotoScanUPCViewModel_Factory create(
      Provider<IBarcodeScanner> barcodeScannerProvider) {
    return new TakeAPhotoScanUPCViewModel_Factory(barcodeScannerProvider);
  }

  public static TakeAPhotoScanUPCViewModel newInstance(IBarcodeScanner barcodeScanner) {
    return new TakeAPhotoScanUPCViewModel(barcodeScanner);
  }
}
