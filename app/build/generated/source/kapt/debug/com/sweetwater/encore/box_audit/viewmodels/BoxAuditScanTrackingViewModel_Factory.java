package com.sweetwater.encore.box_audit.viewmodels;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository;
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
public final class BoxAuditScanTrackingViewModel_Factory implements Factory<BoxAuditScanTrackingViewModel> {
  private final Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider;

  private final Provider<IBoxAuditRepository> boxAuditRepositoryProvider;

  private final Provider<IBarcodeScanner> barcodeScannerProvider;

  private final Provider<ISoundService> soundServiceProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<Context> contextProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public BoxAuditScanTrackingViewModel_Factory(
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<IBoxAuditRepository> boxAuditRepositoryProvider,
      Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getEmployeeLoginDetailsUseCaseProvider = getEmployeeLoginDetailsUseCaseProvider;
    this.boxAuditRepositoryProvider = boxAuditRepositoryProvider;
    this.barcodeScannerProvider = barcodeScannerProvider;
    this.soundServiceProvider = soundServiceProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.contextProvider = contextProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public BoxAuditScanTrackingViewModel get() {
    return newInstance(getEmployeeLoginDetailsUseCaseProvider.get(), boxAuditRepositoryProvider.get(), barcodeScannerProvider.get(), soundServiceProvider.get(), ioDispatcherProvider.get(), contextProvider.get(), savedStateHandleProvider.get());
  }

  public static BoxAuditScanTrackingViewModel_Factory create(
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<IBoxAuditRepository> boxAuditRepositoryProvider,
      Provider<IBarcodeScanner> barcodeScannerProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new BoxAuditScanTrackingViewModel_Factory(getEmployeeLoginDetailsUseCaseProvider, boxAuditRepositoryProvider, barcodeScannerProvider, soundServiceProvider, ioDispatcherProvider, contextProvider, savedStateHandleProvider);
  }

  public static BoxAuditScanTrackingViewModel newInstance(
      GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase,
      IBoxAuditRepository boxAuditRepository, IBarcodeScanner barcodeScanner,
      ISoundService soundService, CoroutineDispatcher ioDispatcher, Context context,
      SavedStateHandle savedStateHandle) {
    return new BoxAuditScanTrackingViewModel(getEmployeeLoginDetailsUseCase, boxAuditRepository, barcodeScanner, soundService, ioDispatcher, context, savedStateHandle);
  }
}
