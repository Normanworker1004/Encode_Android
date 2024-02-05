package com.sweetwater.encore.take_a_photo.viewmodels;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.external_api.gds.repository.GDSRepository;
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
public final class TakeAPhotoCaptureViewModel_Factory implements Factory<TakeAPhotoCaptureViewModel> {
  private final Provider<Context> contextProvider;

  private final Provider<GDSRepository> gdsRepositoryProvider;

  private final Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider;

  private final Provider<ISoundService> soundServiceProvider;

  private final Provider<IBarcodeScanner> barcodeScannerProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public TakeAPhotoCaptureViewModel_Factory(Provider<Context> contextProvider,
      Provider<GDSRepository> gdsRepositoryProvider,
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.contextProvider = contextProvider;
    this.gdsRepositoryProvider = gdsRepositoryProvider;
    this.getEmployeeLoginDetailsUseCaseProvider = getEmployeeLoginDetailsUseCaseProvider;
    this.soundServiceProvider = soundServiceProvider;
    this.barcodeScannerProvider = barcodeScannerProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public TakeAPhotoCaptureViewModel get() {
    return newInstance(contextProvider.get(), gdsRepositoryProvider.get(), getEmployeeLoginDetailsUseCaseProvider.get(), soundServiceProvider.get(), barcodeScannerProvider.get(), ioDispatcherProvider.get(), savedStateHandleProvider.get());
  }

  public static TakeAPhotoCaptureViewModel_Factory create(Provider<Context> contextProvider,
      Provider<GDSRepository> gdsRepositoryProvider,
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new TakeAPhotoCaptureViewModel_Factory(contextProvider, gdsRepositoryProvider, getEmployeeLoginDetailsUseCaseProvider, soundServiceProvider, barcodeScannerProvider, ioDispatcherProvider, savedStateHandleProvider);
  }

  public static TakeAPhotoCaptureViewModel newInstance(Context context, GDSRepository gdsRepository,
      GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase, ISoundService soundService,
      IBarcodeScanner barcodeScanner, CoroutineDispatcher ioDispatcher,
      SavedStateHandle savedStateHandle) {
    return new TakeAPhotoCaptureViewModel(context, gdsRepository, getEmployeeLoginDetailsUseCase, soundService, barcodeScanner, ioDispatcher, savedStateHandle);
  }
}
