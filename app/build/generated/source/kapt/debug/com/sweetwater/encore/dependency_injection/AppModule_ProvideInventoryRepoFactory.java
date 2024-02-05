package com.sweetwater.encore.dependency_injection;

import android.content.Context;
import com.sweetwater.encore.external_api.inventory.remote.InventoryAPI;
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository;
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
public final class AppModule_ProvideInventoryRepoFactory implements Factory<IInventoryRepository> {
  private final Provider<InventoryAPI> inventoryAPIProvider;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideInventoryRepoFactory(Provider<InventoryAPI> inventoryAPIProvider,
      Provider<Context> contextProvider) {
    this.inventoryAPIProvider = inventoryAPIProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public IInventoryRepository get() {
    return provideInventoryRepo(inventoryAPIProvider.get(), contextProvider.get());
  }

  public static AppModule_ProvideInventoryRepoFactory create(
      Provider<InventoryAPI> inventoryAPIProvider, Provider<Context> contextProvider) {
    return new AppModule_ProvideInventoryRepoFactory(inventoryAPIProvider, contextProvider);
  }

  public static IInventoryRepository provideInventoryRepo(InventoryAPI inventoryAPI,
      Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideInventoryRepo(inventoryAPI, context));
  }
}
