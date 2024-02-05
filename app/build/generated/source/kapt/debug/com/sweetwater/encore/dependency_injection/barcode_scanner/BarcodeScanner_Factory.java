package com.sweetwater.encore.dependency_injection.barcode_scanner;

import android.content.Context;
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
public final class BarcodeScanner_Factory implements Factory<BarcodeScanner> {
  private final Provider<Context> contextProvider;

  public BarcodeScanner_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public BarcodeScanner get() {
    return newInstance(contextProvider.get());
  }

  public static BarcodeScanner_Factory create(Provider<Context> contextProvider) {
    return new BarcodeScanner_Factory(contextProvider);
  }

  public static BarcodeScanner newInstance(Context context) {
    return new BarcodeScanner(context);
  }
}
