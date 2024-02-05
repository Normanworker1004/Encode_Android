package com.sweetwater.encore.dependency_injection;

import com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService;
import com.sweetwater.encore.dependency_injection.mqtt.IMqttService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideCartScannerServiceFactory implements Factory<ICartScannerService> {
  private final Provider<IMqttService> mqttServiceProvider;

  public AppModule_ProvideCartScannerServiceFactory(Provider<IMqttService> mqttServiceProvider) {
    this.mqttServiceProvider = mqttServiceProvider;
  }

  @Override
  public ICartScannerService get() {
    return provideCartScannerService(mqttServiceProvider.get());
  }

  public static AppModule_ProvideCartScannerServiceFactory create(
      Provider<IMqttService> mqttServiceProvider) {
    return new AppModule_ProvideCartScannerServiceFactory(mqttServiceProvider);
  }

  public static ICartScannerService provideCartScannerService(IMqttService mqttService) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideCartScannerService(mqttService));
  }
}
