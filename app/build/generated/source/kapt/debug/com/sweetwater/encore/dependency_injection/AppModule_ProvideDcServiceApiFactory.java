package com.sweetwater.encore.dependency_injection;

import com.sweetwater.encore.external_api.dcservice.remote.DcServiceAPI;
import com.sweetwater.encore.utilities.AuthToken;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class AppModule_ProvideDcServiceApiFactory implements Factory<DcServiceAPI> {
  private final Provider<AuthToken> authTokenProvider;

  public AppModule_ProvideDcServiceApiFactory(Provider<AuthToken> authTokenProvider) {
    this.authTokenProvider = authTokenProvider;
  }

  @Override
  public DcServiceAPI get() {
    return provideDcServiceApi(authTokenProvider.get());
  }

  public static AppModule_ProvideDcServiceApiFactory create(Provider<AuthToken> authTokenProvider) {
    return new AppModule_ProvideDcServiceApiFactory(authTokenProvider);
  }

  public static DcServiceAPI provideDcServiceApi(AuthToken authToken) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDcServiceApi(authToken));
  }
}
