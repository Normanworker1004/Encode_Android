package com.sweetwater.encore.recounts.viewmodels;

import android.content.Context;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository;
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
public final class RecountsChooseZoneViewModel_Factory implements Factory<RecountsChooseZoneViewModel> {
  private final Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider;

  private final Provider<IInventoryRepository> inventoryRepositoryProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<Context> contextProvider;

  public RecountsChooseZoneViewModel_Factory(
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<IInventoryRepository> inventoryRepositoryProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
    this.getEmployeeLoginDetailsUseCaseProvider = getEmployeeLoginDetailsUseCaseProvider;
    this.inventoryRepositoryProvider = inventoryRepositoryProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public RecountsChooseZoneViewModel get() {
    return newInstance(getEmployeeLoginDetailsUseCaseProvider.get(), inventoryRepositoryProvider.get(), ioDispatcherProvider.get(), contextProvider.get());
  }

  public static RecountsChooseZoneViewModel_Factory create(
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<IInventoryRepository> inventoryRepositoryProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
    return new RecountsChooseZoneViewModel_Factory(getEmployeeLoginDetailsUseCaseProvider, inventoryRepositoryProvider, ioDispatcherProvider, contextProvider);
  }

  public static RecountsChooseZoneViewModel newInstance(
      GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase,
      IInventoryRepository inventoryRepository, CoroutineDispatcher ioDispatcher, Context context) {
    return new RecountsChooseZoneViewModel(getEmployeeLoginDetailsUseCase, inventoryRepository, ioDispatcher, context);
  }
}
