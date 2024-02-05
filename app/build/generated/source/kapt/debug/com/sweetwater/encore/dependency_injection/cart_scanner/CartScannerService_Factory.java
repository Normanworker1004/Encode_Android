package com.sweetwater.encore.dependency_injection.cart_scanner;

import com.sweetwater.encore.dependency_injection.mqtt.IMqttService;
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
public final class CartScannerService_Factory implements Factory<CartScannerService> {
  private final Provider<IMqttService> mqttServiceProvider;

  public CartScannerService_Factory(Provider<IMqttService> mqttServiceProvider) {
    this.mqttServiceProvider = mqttServiceProvider;
  }

  @Override
  public CartScannerService get() {
    return newInstance(mqttServiceProvider.get());
  }

  public static CartScannerService_Factory create(Provider<IMqttService> mqttServiceProvider) {
    return new CartScannerService_Factory(mqttServiceProvider);
  }

  public static CartScannerService newInstance(IMqttService mqttService) {
    return new CartScannerService(mqttService);
  }
}
