package com.sweetwater.encore.recounts.viewmodels;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository;
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

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
public final class RecountsScanProductViewModel_Factory implements Factory<RecountsScanProductViewModel> {
  private final Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider;

  private final Provider<IRecountsRepository> recountsDataRepositoryProvider;

  private final Provider<IInventoryRepository> inventoryRepositoryProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<Context> contextProvider;

  public RecountsScanProductViewModel_Factory(
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<IRecountsRepository> recountsDataRepositoryProvider,
      Provider<IInventoryRepository> inventoryRepositoryProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider,
      Provider<SavedStateHandle> savedStateHandleProvider, Provider<Context> contextProvider) {
    this.getEmployeeLoginDetailsUseCaseProvider = getEmployeeLoginDetailsUseCaseProvider;
    this.recountsDataRepositoryProvider = recountsDataRepositoryProvider;
    this.inventoryRepositoryProvider = inventoryRepositoryProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public RecountsScanProductViewModel get() {
    return newInstance(getEmployeeLoginDetailsUseCaseProvider.get(), recountsDataRepositoryProvider.get(), inventoryRepositoryProvider.get(), ioDispatcherProvider.get(), savedStateHandleProvider.get(), contextProvider.get());
  }

  public static RecountsScanProductViewModel_Factory create(
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<IRecountsRepository> recountsDataRepositoryProvider,
      Provider<IInventoryRepository> inventoryRepositoryProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider,
      Provider<SavedStateHandle> savedStateHandleProvider, Provider<Context> contextProvider) {
    return new RecountsScanProductViewModel_Factory(getEmployeeLoginDetailsUseCaseProvider, recountsDataRepositoryProvider, inventoryRepositoryProvider, ioDispatcherProvider, savedStateHandleProvider, contextProvider);
  }

  public static RecountsScanProductViewModel newInstance(
      GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase,
      IRecountsRepository recountsDataRepository, IInventoryRepository inventoryRepository,
      CoroutineDispatcher ioDispatcher, SavedStateHandle savedStateHandle, Context context) {
    return new RecountsScanProductViewModel(getEmployeeLoginDetailsUseCase, recountsDataRepository, inventoryRepository, ioDispatcher, savedStateHandle, context);
  }
}
