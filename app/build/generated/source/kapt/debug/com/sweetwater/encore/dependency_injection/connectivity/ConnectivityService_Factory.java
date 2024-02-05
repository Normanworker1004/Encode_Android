package com.sweetwater.encore.dependency_injection.connectivity;

import android.content.Context;
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
public final class ConnectivityService_Factory implements Factory<ConnectivityService> {
  private final Provider<Context> contextProvider;

  public ConnectivityService_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ConnectivityService get() {
    return newInstance(contextProvider.get());
  }

  public static ConnectivityService_Factory create(Provider<Context> contextProvider) {
    return new ConnectivityService_Factory(contextProvider);
  }

  public static ConnectivityService newInstance(Context context) {
    return new ConnectivityService(context);
  }
}
