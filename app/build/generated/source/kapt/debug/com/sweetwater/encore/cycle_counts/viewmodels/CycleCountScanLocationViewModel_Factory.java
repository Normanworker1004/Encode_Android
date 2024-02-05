package com.sweetwater.encore.cycle_counts.viewmodels;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
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
public final class CycleCountScanLocationViewModel_Factory implements Factory<CycleCountScanLocationViewModel> {
  private final Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider;

  private final Provider<IInventoryRepository> inventoryRepositoryProvider;

  private final Provider<IBarcodeScanner> barcodeScannerProvider;

  private final Provider<ISoundService> soundServiceProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<Context> contextProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public CycleCountScanLocationViewModel_Factory(
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<IInventoryRepository> inventoryRepositoryProvider,
      Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getEmployeeLoginDetailsUseCaseProvider = getEmployeeLoginDetailsUseCaseProvider;
    this.inventoryRepositoryProvider = inventoryRepositoryProvider;
    this.barcodeScannerProvider = barcodeScannerProvider;
    this.soundServiceProvider = soundServiceProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.contextProvider = contextProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public CycleCountScanLocationViewModel get() {
    return newInstance(getEmployeeLoginDetailsUseCaseProvider.get(), inventoryRepositoryProvider.get(), barcodeScannerProvider.get(), soundServiceProvider.get(), ioDispatcherProvider.get(), contextProvider.get(), savedStateHandleProvider.get());
  }

  public static CycleCountScanLocationViewModel_Factory create(
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<IInventoryRepository> inventoryRepositoryProvider,
      Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new CycleCountScanLocationViewModel_Factory(getEmployeeLoginDetailsUseCaseProvider, inventoryRepositoryProvider, barcodeScannerProvider, soundServiceProvider, ioDispatcherProvider, contextProvider, savedStateHandleProvider);
  }

  public static CycleCountScanLocationViewModel newInstance(
      GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase,
      IInventoryRepository inventoryRepository, IBarcodeScanner barcodeScanner,
      ISoundService soundService, CoroutineDispatcher ioDispatcher, Context context,
      SavedStateHandle savedStateHandle) {
    return new CycleCountScanLocationViewModel(getEmployeeLoginDetailsUseCase, inventoryRepository, barcodeScanner, soundService, ioDispatcher, context, savedStateHandle);
  }
}
