package com.sweetwater.encore;

import com.sweetwater.encore.authorization.data.AppLoginStatusStorage;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class SweetWaterActivity_MembersInjector implements MembersInjector<SweetWaterActivity> {
  private final Provider<AppLoginStatusStorage> storageProvider;

  public SweetWaterActivity_MembersInjector(Provider<AppLoginStatusStorage> storageProvider) {
    this.storageProvider = storageProvider;
  }

  public static MembersInjector<SweetWaterActivity> create(
      Provider<AppLoginStatusStorage> storageProvider) {
    return new SweetWaterActivity_MembersInjector(storageProvider);
  }

  @Override
  public void injectMembers(SweetWaterActivity instance) {
    injectStorage(instance, storageProvider.get());
  }

  @InjectedFieldSignature("com.sweetwater.encore.SweetWaterActivity.storage")
  public static void injectStorage(SweetWaterActivity instance, AppLoginStatusStorage storage) {
    instance.storage = storage;
  }
}
