package com.sweetwater.encore.dependency_injection;

import androidx.datastore.core.DataStore;
import com.sweetwater.encore.UserInfoMessage;
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class AppModule_ProvideUserInfoRepoFactory implements Factory<IUserInfoRepository> {
  private final Provider<DataStore<UserInfoMessage>> userInfoDatastoreProvider;

  public AppModule_ProvideUserInfoRepoFactory(
      Provider<DataStore<UserInfoMessage>> userInfoDatastoreProvider) {
    this.userInfoDatastoreProvider = userInfoDatastoreProvider;
  }

  @Override
  public IUserInfoRepository get() {
    return provideUserInfoRepo(userInfoDatastoreProvider.get());
  }

  public static AppModule_ProvideUserInfoRepoFactory create(
      Provider<DataStore<UserInfoMessage>> userInfoDatastoreProvider) {
    return new AppModule_ProvideUserInfoRepoFactory(userInfoDatastoreProvider);
  }

  public static IUserInfoRepository provideUserInfoRepo(
      DataStore<UserInfoMessage> userInfoDatastore) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideUserInfoRepo(userInfoDatastore));
  }
}
