package com.sweetwater.encore.dependency_injection;

import com.sweetwater.encore.external_api.boxaudit.remote.BoxAuditAPI;
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
public final class AppModule_ProvideBoxAuditAPIFactory implements Factory<BoxAuditAPI> {
  @Override
  public BoxAuditAPI get() {
    return provideBoxAuditAPI();
  }

  public static AppModule_ProvideBoxAuditAPIFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BoxAuditAPI provideBoxAuditAPI() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideBoxAuditAPI());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideBoxAuditAPIFactory INSTANCE = new AppModule_ProvideBoxAuditAPIFactory();
  }
}
