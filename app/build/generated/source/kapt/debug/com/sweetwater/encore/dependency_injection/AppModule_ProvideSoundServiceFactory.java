package com.sweetwater.encore.dependency_injection;

import android.content.Context;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
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
public final class AppModule_ProvideSoundServiceFactory implements Factory<ISoundService> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideSoundServiceFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ISoundService get() {
    return provideSoundService(contextProvider.get());
  }

  public static AppModule_ProvideSoundServiceFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideSoundServiceFactory(contextProvider);
  }

  public static ISoundService provideSoundService(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSoundService(context));
  }
}
