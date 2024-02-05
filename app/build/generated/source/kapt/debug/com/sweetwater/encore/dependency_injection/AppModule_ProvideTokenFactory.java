package com.sweetwater.encore.dependency_injection;

import com.sweetwater.encore.utilities.AuthToken;
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
public final class AppModule_ProvideTokenFactory implements Factory<AuthToken> {
  @Override
  public AuthToken get() {
    return provideToken();
  }

  public static AppModule_ProvideTokenFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AuthToken provideToken() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideToken());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideTokenFactory INSTANCE = new AppModule_ProvideTokenFactory();
  }
}
