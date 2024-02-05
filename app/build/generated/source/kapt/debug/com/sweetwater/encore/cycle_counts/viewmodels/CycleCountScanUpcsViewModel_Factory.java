package com.sweetwater.encore.cycle_counts.viewmodels;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService;
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository;
import com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository;
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
public final class CycleCountScanUpcsViewModel_Factory implements Factory<CycleCountScanUpcsViewModel> {
  private final Provider<IInventoryRepository> inventoryRepositoryProvider;

  private final Provider<IProductsRepository> productsRepositoryProvider;

  private final Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider;

  private final Provider<IBarcodeScanner> barcodeScannerProvider;

  private final Provider<ISoundService> soundServiceProvider;

  private final Provider<IVibratorService> vibratorServiceProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<Context> contextProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public CycleCountScanUpcsViewModel_Factory(
      Provider<IInventoryRepository> inventoryRepositoryProvider,
      Provider<IProductsRepository> productsRepositoryProvider,
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<IVibratorService> vibratorServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.inventoryRepositoryProvider = inventoryRepositoryProvider;
    this.productsRepositoryProvider = productsRepositoryProvider;
    this.getEmployeeLoginDetailsUseCaseProvider = getEmployeeLoginDetailsUseCaseProvider;
    this.barcodeScannerProvider = barcodeScannerProvider;
    this.soundServiceProvider = soundServiceProvider;
    this.vibratorServiceProvider = vibratorServiceProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.contextProvider = contextProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public CycleCountScanUpcsViewModel get() {
    return newInstance(inventoryRepositoryProvider.get(), productsRepositoryProvider.get(), getEmployeeLoginDetailsUseCaseProvider.get(), barcodeScannerProvider.get(), soundServiceProvider.get(), vibratorServiceProvider.get(), ioDispatcherProvider.get(), contextProvider.get(), savedStateHandleProvider.get());
  }

  public static CycleCountScanUpcsViewModel_Factory create(
      Provider<IInventoryRepository> inventoryRepositoryProvider,
      Provider<IProductsRepository> productsRepositoryProvider,
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<IVibratorService> vibratorServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new CycleCountScanUpcsViewModel_Factory(inventoryRepositoryProvider, productsRepositoryProvider, getEmployeeLoginDetailsUseCaseProvider, barcodeScannerProvider, soundServiceProvider, vibratorServiceProvider, ioDispatcherProvider, contextProvider, savedStateHandleProvider);
  }

  public static CycleCountScanUpcsViewModel newInstance(IInventoryRepository inventoryRepository,
      IProductsRepository productsRepository,
      GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase, IBarcodeScanner barcodeScanner,
      ISoundService soundService, IVibratorService vibratorService,
      CoroutineDispatcher ioDispatcher, Context context, SavedStateHandle savedStateHandle) {
    return new CycleCountScanUpcsViewModel(inventoryRepository, productsRepository, getEmployeeLoginDetailsUseCase, barcodeScanner, soundService, vibratorService, ioDispatcher, context, savedStateHandle);
  }
}
