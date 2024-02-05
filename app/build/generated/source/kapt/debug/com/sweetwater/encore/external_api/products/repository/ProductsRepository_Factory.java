package com.sweetwater.encore.external_api.products.repository;

import android.content.Context;
import com.sweetwater.encore.external_api.products.remote.ProductsAPI;
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
public final class ProductsRepository_Factory implements Factory<ProductsRepository> {
  private final Provider<ProductsAPI> productsAPIProvider;

  private final Provider<Context> contextProvider;

  public ProductsRepository_Factory(Provider<ProductsAPI> productsAPIProvider,
      Provider<Context> contextProvider) {
    this.productsAPIProvider = productsAPIProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public ProductsRepository get() {
    return newInstance(productsAPIProvider.get(), contextProvider.get());
  }

  public static ProductsRepository_Factory create(Provider<ProductsAPI> productsAPIProvider,
      Provider<Context> contextProvider) {
    return new ProductsRepository_Factory(productsAPIProvider, contextProvider);
  }

  public static ProductsRepository newInstance(ProductsAPI productsAPI, Context context) {
    return new ProductsRepository(productsAPI, context);
  }
}
