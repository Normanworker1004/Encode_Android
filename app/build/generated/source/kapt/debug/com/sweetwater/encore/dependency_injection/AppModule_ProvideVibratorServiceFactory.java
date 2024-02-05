package com.sweetwater.encore.dependency_injection;

import android.content.Context;
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService;
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
public final class AppModule_ProvideVibratorServiceFactory implements Factory<IVibratorService> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideVibratorServiceFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public IVibratorService get() {
    return provideVibratorService(contextProvider.get());
  }

  public static AppModule_ProvideVibratorServiceFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideVibratorServiceFactory(contextProvider);
  }

  public static IVibratorService provideVibratorService(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideVibratorService(context));
  }
}
