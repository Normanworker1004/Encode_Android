package com.sweetwater.encore.utilities;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class Logger_Factory implements Factory<Logger> {
  @Override
  public Logger get() {
    return newInstance();
  }

  public static Logger_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Logger newInstance() {
    return new Logger();
  }

  private static final class InstanceHolder {
    private static final Logger_Factory INSTANCE = new Logger_Factory();
  }
}
