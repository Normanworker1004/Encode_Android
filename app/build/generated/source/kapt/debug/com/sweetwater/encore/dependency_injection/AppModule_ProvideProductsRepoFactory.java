package com.sweetwater.encore.dependency_injection;

import android.content.Context;
import com.sweetwater.encore.external_api.products.remote.ProductsAPI;
import com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository;
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
public final class AppModule_ProvideProductsRepoFactory implements Factory<IProductsRepository> {
  private final Provider<ProductsAPI> productsAPIProvider;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideProductsRepoFactory(Provider<ProductsAPI> productsAPIProvider,
      Provider<Context> contextProvider) {
    this.productsAPIProvider = productsAPIProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public IProductsRepository get() {
    return provideProductsRepo(productsAPIProvider.get(), contextProvider.get());
  }

  public static AppModule_ProvideProductsRepoFactory create(
      Provider<ProductsAPI> productsAPIProvider, Provider<Context> contextProvider) {
    return new AppModule_ProvideProductsRepoFactory(productsAPIProvider, contextProvider);
  }

  public static IProductsRepository provideProductsRepo(ProductsAPI productsAPI, Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideProductsRepo(productsAPI, context));
  }
}
