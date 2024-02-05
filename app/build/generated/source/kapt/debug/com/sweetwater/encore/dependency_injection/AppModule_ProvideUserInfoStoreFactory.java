package com.sweetwater.encore.dependency_injection;

import android.content.Context;
import androidx.datastore.core.DataStore;
import com.sweetwater.encore.UserInfoMessage;
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
public final class AppModule_ProvideUserInfoStoreFactory implements Factory<DataStore<UserInfoMessage>> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideUserInfoStoreFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public DataStore<UserInfoMessage> get() {
    return provideUserInfoStore(contextProvider.get());
  }

  public static AppModule_ProvideUserInfoStoreFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideUserInfoStoreFactory(contextProvider);
  }

  public static DataStore<UserInfoMessage> provideUserInfoStore(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideUserInfoStore(context));
  }
}
