package com.sweetwater.encore.dependency_injection;

import com.sweetwater.encore.dependency_injection.mqtt.IMqttService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AppModule_ProvideMqttServiceFactory implements Factory<IMqttService> {
  @Override
  public IMqttService get() {
    return provideMqttService();
  }

  public static AppModule_ProvideMqttServiceFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static IMqttService provideMqttService() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMqttService());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideMqttServiceFactory INSTANCE = new AppModule_ProvideMqttServiceFactory();
  }
}
