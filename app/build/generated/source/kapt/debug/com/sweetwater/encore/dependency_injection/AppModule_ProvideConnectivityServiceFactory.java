package com.sweetwater.encore.dependency_injection;

import android.content.Context;
import com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class AppModule_ProvideConnectivityServiceFactory implements Factory<IConnectivityService> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideConnectivityServiceFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public IConnectivityService get() {
    return provideConnectivityService(contextProvider.get());
  }

  public static AppModule_ProvideConnectivityServiceFactory create(
      Provider<Context> contextProvider) {
    return new AppModule_ProvideConnectivityServiceFactory(contextProvider);
  }

  public static IConnectivityService provideConnectivityService(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideConnectivityService(context));
  }
}
