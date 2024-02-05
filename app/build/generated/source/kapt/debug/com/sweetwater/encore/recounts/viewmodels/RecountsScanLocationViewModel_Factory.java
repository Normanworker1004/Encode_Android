package com.sweetwater.encore.recounts.viewmodels;

import android.content.Context;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
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
public final class RecountsScanLocationViewModel_Factory implements Factory<RecountsScanLocationViewModel> {
  private final Provider<IBarcodeScanner> barcodeScannerProvider;

  private final Provider<IRecountsRepository> recountsDataRepositoryProvider;

  private final Provider<IInventoryRepository> inventoryRepositoryProvider;

  private final Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<Context> contextProvider;

  public RecountsScanLocationViewModel_Factory(Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<IRecountsRepository> recountsDataRepositoryProvider,
      Provider<IInventoryRepository> inventoryRepositoryProvider,
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
    this.barcodeScannerProvider = barcodeScannerProvider;
    this.recountsDataRepositoryProvider = recountsDataRepositoryProvider;
    this.inventoryRepositoryProvider = inventoryRepositoryProvider;
    this.getEmployeeLoginDetailsUseCaseProvider = getEmployeeLoginDetailsUseCaseProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public RecountsScanLocationViewModel get() {
    return newInstance(barcodeScannerProvider.get(), recountsDataRepositoryProvider.get(), inventoryRepositoryProvider.get(), getEmployeeLoginDetailsUseCaseProvider.get(), ioDispatcherProvider.get(), contextProvider.get());
  }

  public static RecountsScanLocationViewModel_Factory create(
      Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<IRecountsRepository> recountsDataRepositoryProvider,
      Provider<IInventoryRepository> inventoryRepositoryProvider,
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
    return new RecountsScanLocationViewModel_Factory(barcodeScannerProvider, recountsDataRepositoryProvider, inventoryRepositoryProvider, getEmployeeLoginDetailsUseCaseProvider, ioDispatcherProvider, contextProvider);
  }

  public static RecountsScanLocationViewModel newInstance(IBarcodeScanner barcodeScanner,
      IRecountsRepository recountsDataRepository, IInventoryRepository inventoryRepository,
      GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase,
      CoroutineDispatcher ioDispatcher, Context context) {
    return new RecountsScanLocationViewModel(barcodeScanner, recountsDataRepository, inventoryRepository, getEmployeeLoginDetailsUseCase, ioDispatcher, context);
  }
}
