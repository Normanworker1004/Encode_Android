package com.sweetwater.encore.external_api.gds.repository;

import android.content.Context;
import com.sweetwater.encore.external_api.gds.remote.GDSAPI;
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
public final class GDSRepository_Factory implements Factory<GDSRepository> {
  private final Provider<GDSAPI> gdsAPIProvider;

  private final Provider<Context> contextProvider;

  public GDSRepository_Factory(Provider<GDSAPI> gdsAPIProvider, Provider<Context> contextProvider) {
    this.gdsAPIProvider = gdsAPIProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public GDSRepository get() {
    return newInstance(gdsAPIProvider.get(), contextProvider.get());
  }

  public static GDSRepository_Factory create(Provider<GDSAPI> gdsAPIProvider,
      Provider<Context> contextProvider) {
    return new GDSRepository_Factory(gdsAPIProvider, contextProvider);
  }

  public static GDSRepository newInstance(GDSAPI gdsAPI, Context context) {
    return new GDSRepository(gdsAPI, context);
  }
}
