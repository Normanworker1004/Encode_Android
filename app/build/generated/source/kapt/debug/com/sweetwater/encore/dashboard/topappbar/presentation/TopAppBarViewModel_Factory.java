package com.sweetwater.encore.dashboard.topappbar.presentation;

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
public final class TopAppBarViewModel_Factory implements Factory<TopAppBarViewModel> {
  @Override
  public TopAppBarViewModel get() {
    return newInstance();
  }

  public static TopAppBarViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static TopAppBarViewModel newInstance() {
    return new TopAppBarViewModel();
  }

  private static final class InstanceHolder {
    private static final TopAppBarViewModel_Factory INSTANCE = new TopAppBarViewModel_Factory();
  }
}
