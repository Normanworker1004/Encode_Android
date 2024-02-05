package com.sweetwater.encore.dependency_injection;

import android.content.Context;
import androidx.datastore.core.DataStore;
import com.sweetwater.encore.RecountsData;
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
public final class AppModule_ProvideRecountsDataStoreFactory implements Factory<DataStore<RecountsData>> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideRecountsDataStoreFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public DataStore<RecountsData> get() {
    return provideRecountsDataStore(contextProvider.get());
  }

  public static AppModule_ProvideRecountsDataStoreFactory create(
      Provider<Context> contextProvider) {
    return new AppModule_ProvideRecountsDataStoreFactory(contextProvider);
  }

  public static DataStore<RecountsData> provideRecountsDataStore(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideRecountsDataStore(context));
  }
}
