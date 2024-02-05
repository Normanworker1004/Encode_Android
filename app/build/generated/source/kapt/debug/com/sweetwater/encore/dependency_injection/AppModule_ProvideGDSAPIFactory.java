package com.sweetwater.encore.dependency_injection;

import com.sweetwater.encore.external_api.gds.remote.GDSAPI;
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
public final class AppModule_ProvideGDSAPIFactory implements Factory<GDSAPI> {
  @Override
  public GDSAPI get() {
    return provideGDSAPI();
  }

  public static AppModule_ProvideGDSAPIFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GDSAPI provideGDSAPI() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideGDSAPI());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideGDSAPIFactory INSTANCE = new AppModule_ProvideGDSAPIFactory();
  }
}
