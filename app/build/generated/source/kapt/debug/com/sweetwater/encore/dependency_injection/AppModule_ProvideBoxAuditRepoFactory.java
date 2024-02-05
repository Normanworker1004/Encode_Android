package com.sweetwater.encore.dependency_injection;

import android.content.Context;
import com.sweetwater.encore.external_api.boxaudit.remote.BoxAuditAPI;
import com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository;
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
public final class AppModule_ProvideBoxAuditRepoFactory implements Factory<IBoxAuditRepository> {
  private final Provider<BoxAuditAPI> boxAuditAPIProvider;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideBoxAuditRepoFactory(Provider<BoxAuditAPI> boxAuditAPIProvider,
      Provider<Context> contextProvider) {
    this.boxAuditAPIProvider = boxAuditAPIProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public IBoxAuditRepository get() {
    return provideBoxAuditRepo(boxAuditAPIProvider.get(), contextProvider.get());
  }

  public static AppModule_ProvideBoxAuditRepoFactory create(
      Provider<BoxAuditAPI> boxAuditAPIProvider, Provider<Context> contextProvider) {
    return new AppModule_ProvideBoxAuditRepoFactory(boxAuditAPIProvider, contextProvider);
  }

  public static IBoxAuditRepository provideBoxAuditRepo(BoxAuditAPI boxAuditAPI, Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideBoxAuditRepo(boxAuditAPI, context));
  }
}
