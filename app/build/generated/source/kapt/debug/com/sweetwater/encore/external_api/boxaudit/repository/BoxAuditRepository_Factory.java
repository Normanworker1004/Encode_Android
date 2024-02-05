package com.sweetwater.encore.external_api.boxaudit.repository;

import android.content.Context;
import com.sweetwater.encore.external_api.boxaudit.remote.BoxAuditAPI;
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
public final class BoxAuditRepository_Factory implements Factory<BoxAuditRepository> {
  private final Provider<BoxAuditAPI> boxAuditAPIProvider;

  private final Provider<Context> contextProvider;

  public BoxAuditRepository_Factory(Provider<BoxAuditAPI> boxAuditAPIProvider,
      Provider<Context> contextProvider) {
    this.boxAuditAPIProvider = boxAuditAPIProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public BoxAuditRepository get() {
    return newInstance(boxAuditAPIProvider.get(), contextProvider.get());
  }

  public static BoxAuditRepository_Factory create(Provider<BoxAuditAPI> boxAuditAPIProvider,
      Provider<Context> contextProvider) {
    return new BoxAuditRepository_Factory(boxAuditAPIProvider, contextProvider);
  }

  public static BoxAuditRepository newInstance(BoxAuditAPI boxAuditAPI, Context context) {
    return new BoxAuditRepository(boxAuditAPI, context);
  }
}
