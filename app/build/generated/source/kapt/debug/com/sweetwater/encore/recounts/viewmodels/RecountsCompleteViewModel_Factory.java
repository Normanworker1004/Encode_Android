package com.sweetwater.encore.recounts.viewmodels;

import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository;
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
public final class RecountsCompleteViewModel_Factory implements Factory<RecountsCompleteViewModel> {
  private final Provider<IRecountsRepository> recountsDataStoreRepositoryProvider;

  public RecountsCompleteViewModel_Factory(
      Provider<IRecountsRepository> recountsDataStoreRepositoryProvider) {
    this.recountsDataStoreRepositoryProvider = recountsDataStoreRepositoryProvider;
  }

  @Override
  public RecountsCompleteViewModel get() {
    return newInstance(recountsDataStoreRepositoryProvider.get());
  }

  public static RecountsCompleteViewModel_Factory create(
      Provider<IRecountsRepository> recountsDataStoreRepositoryProvider) {
    return new RecountsCompleteViewModel_Factory(recountsDataStoreRepositoryProvider);
  }

  public static RecountsCompleteViewModel newInstance(
      IRecountsRepository recountsDataStoreRepository) {
    return new RecountsCompleteViewModel(recountsDataStoreRepository);
  }
}
