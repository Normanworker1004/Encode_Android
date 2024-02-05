package com.sweetwater.encore.recounts.viewmodels;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService;
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
public final class RecountsScanUPCViewModel_Factory implements Factory<RecountsScanUPCViewModel> {
  private final Provider<IBarcodeScanner> barcodeScannerProvider;

  private final Provider<IRecountsRepository> recountsDataRepositoryProvider;

  private final Provider<ISoundService> soundServiceProvider;

  private final Provider<IVibratorService> vibratorServiceProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<IInventoryRepository> inventoryRepositoryProvider;

  private final Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<Context> contextProvider;

  public RecountsScanUPCViewModel_Factory(Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<IRecountsRepository> recountsDataRepositoryProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<IVibratorService> vibratorServiceProvider,
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<IInventoryRepository> inventoryRepositoryProvider,
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
    this.barcodeScannerProvider = barcodeScannerProvider;
    this.recountsDataRepositoryProvider = recountsDataRepositoryProvider;
    this.soundServiceProvider = soundServiceProvider;
    this.vibratorServiceProvider = vibratorServiceProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.inventoryRepositoryProvider = inventoryRepositoryProvider;
    this.getEmployeeLoginDetailsUseCaseProvider = getEmployeeLoginDetailsUseCaseProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public RecountsScanUPCViewModel get() {
    return newInstance(barcodeScannerProvider.get(), recountsDataRepositoryProvider.get(), soundServiceProvider.get(), vibratorServiceProvider.get(), savedStateHandleProvider.get(), inventoryRepositoryProvider.get(), getEmployeeLoginDetailsUseCaseProvider.get(), ioDispatcherProvider.get(), contextProvider.get());
  }

  public static RecountsScanUPCViewModel_Factory create(
      Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<IRecountsRepository> recountsDataRepositoryProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<IVibratorService> vibratorServiceProvider,
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<IInventoryRepository> inventoryRepositoryProvider,
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
    return new RecountsScanUPCViewModel_Factory(barcodeScannerProvider, recountsDataRepositoryProvider, soundServiceProvider, vibratorServiceProvider, savedStateHandleProvider, inventoryRepositoryProvider, getEmployeeLoginDetailsUseCaseProvider, ioDispatcherProvider, contextProvider);
  }

  public static RecountsScanUPCViewModel newInstance(IBarcodeScanner barcodeScanner,
      IRecountsRepository recountsDataRepository, ISoundService soundService,
      IVibratorService vibratorService, SavedStateHandle savedStateHandle,
      IInventoryRepository inventoryRepository,
      GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase,
      CoroutineDispatcher ioDispatcher, Context context) {
    return new RecountsScanUPCViewModel(barcodeScanner, recountsDataRepository, soundService, vibratorService, savedStateHandle, inventoryRepository, getEmployeeLoginDetailsUseCase, ioDispatcher, context);
  }
}
