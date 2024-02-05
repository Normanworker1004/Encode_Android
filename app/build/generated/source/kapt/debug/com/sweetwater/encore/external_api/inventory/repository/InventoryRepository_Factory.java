package com.sweetwater.encore.external_api.inventory.repository;

import android.content.Context;
import com.sweetwater.encore.external_api.inventory.remote.InventoryAPI;
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
public final class InventoryRepository_Factory implements Factory<InventoryRepository> {
  private final Provider<InventoryAPI> inventoryAPIProvider;

  private final Provider<Context> contextProvider;

  public InventoryRepository_Factory(Provider<InventoryAPI> inventoryAPIProvider,
      Provider<Context> contextProvider) {
    this.inventoryAPIProvider = inventoryAPIProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public InventoryRepository get() {
    return newInstance(inventoryAPIProvider.get(), contextProvider.get());
  }

  public static InventoryRepository_Factory create(Provider<InventoryAPI> inventoryAPIProvider,
      Provider<Context> contextProvider) {
    return new InventoryRepository_Factory(inventoryAPIProvider, contextProvider);
  }

  public static InventoryRepository newInstance(InventoryAPI inventoryAPI, Context context) {
    return new InventoryRepository(inventoryAPI, context);
  }
}
