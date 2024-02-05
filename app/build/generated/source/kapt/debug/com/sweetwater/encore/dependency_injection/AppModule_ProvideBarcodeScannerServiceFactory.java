package com.sweetwater.encore.dependency_injection;

import android.content.Context;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_ProvideBarcodeScannerServiceFactory implements Factory<IBarcodeScanner> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideBarcodeScannerServiceFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public IBarcodeScanner get() {
    return provideBarcodeScannerService(contextProvider.get());
  }

  public static AppModule_ProvideBarcodeScannerServiceFactory create(
      Provider<Context> contextProvider) {
    return new AppModule_ProvideBarcodeScannerServiceFactory(contextProvider);
  }

  public static IBarcodeScanner provideBarcodeScannerService(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideBarcodeScannerService(context));
  }
}
