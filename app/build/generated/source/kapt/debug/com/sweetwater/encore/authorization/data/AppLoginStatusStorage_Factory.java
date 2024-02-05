package com.sweetwater.encore.authorization.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class AppLoginStatusStorage_Factory implements Factory<AppLoginStatusStorage> {
  @Override
  public AppLoginStatusStorage get() {
    return newInstance();
  }

  public static AppLoginStatusStorage_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AppLoginStatusStorage newInstance() {
    return new AppLoginStatusStorage();
  }

  private static final class InstanceHolder {
    private static final AppLoginStatusStorage_Factory INSTANCE = new AppLoginStatusStorage_Factory();
  }
}
