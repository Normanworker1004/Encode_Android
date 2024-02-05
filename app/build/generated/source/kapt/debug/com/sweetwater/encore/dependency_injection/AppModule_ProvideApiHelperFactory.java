package com.sweetwater.encore.dependency_injection;

import com.sweetwater.encore.utilities.ApiHelper;
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
public final class AppModule_ProvideApiHelperFactory implements Factory<ApiHelper> {
  @Override
  public ApiHelper get() {
    return provideApiHelper();
  }

  public static AppModule_ProvideApiHelperFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ApiHelper provideApiHelper() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideApiHelper());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideApiHelperFactory INSTANCE = new AppModule_ProvideApiHelperFactory();
  }
}
