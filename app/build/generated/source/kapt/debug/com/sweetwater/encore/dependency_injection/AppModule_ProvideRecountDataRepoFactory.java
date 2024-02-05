package com.sweetwater.encore.dependency_injection;

import androidx.datastore.core.DataStore;
import com.sweetwater.encore.RecountsData;
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository;
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
public final class AppModule_ProvideRecountDataRepoFactory implements Factory<IRecountsRepository> {
  private final Provider<DataStore<RecountsData>> recountsDataStoreProvider;

  public AppModule_ProvideRecountDataRepoFactory(
      Provider<DataStore<RecountsData>> recountsDataStoreProvider) {
    this.recountsDataStoreProvider = recountsDataStoreProvider;
  }

  @Override
  public IRecountsRepository get() {
    return provideRecountDataRepo(recountsDataStoreProvider.get());
  }

  public static AppModule_ProvideRecountDataRepoFactory create(
      Provider<DataStore<RecountsData>> recountsDataStoreProvider) {
    return new AppModule_ProvideRecountDataRepoFactory(recountsDataStoreProvider);
  }

  public static IRecountsRepository provideRecountDataRepo(
      DataStore<RecountsData> recountsDataStore) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideRecountDataRepo(recountsDataStore));
  }
}
