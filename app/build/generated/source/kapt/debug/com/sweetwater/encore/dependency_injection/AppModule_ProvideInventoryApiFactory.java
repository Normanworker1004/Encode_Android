package com.sweetwater.encore.dependency_injection;

import com.sweetwater.encore.external_api.inventory.remote.InventoryAPI;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AppModule_ProvideInventoryApiFactory implements Factory<InventoryAPI> {
  @Override
  public InventoryAPI get() {
    return provideInventoryApi();
  }

  public static AppModule_ProvideInventoryApiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static InventoryAPI provideInventoryApi() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideInventoryApi());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideInventoryApiFactory INSTANCE = new AppModule_ProvideInventoryApiFactory();
  }
}
