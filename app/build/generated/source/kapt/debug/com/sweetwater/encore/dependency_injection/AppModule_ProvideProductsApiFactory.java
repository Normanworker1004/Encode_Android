package com.sweetwater.encore.dependency_injection;

import com.sweetwater.encore.external_api.products.remote.ProductsAPI;
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
public final class AppModule_ProvideProductsApiFactory implements Factory<ProductsAPI> {
  @Override
  public ProductsAPI get() {
    return provideProductsApi();
  }

  public static AppModule_ProvideProductsApiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ProductsAPI provideProductsApi() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideProductsApi());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideProductsApiFactory INSTANCE = new AppModule_ProvideProductsApiFactory();
  }
}
