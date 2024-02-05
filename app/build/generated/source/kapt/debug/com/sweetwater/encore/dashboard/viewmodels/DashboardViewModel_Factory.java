package com.sweetwater.encore.dashboard.viewmodels;

import android.content.Context;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
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
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<Context> contextProvider;

  private final Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider;

  private final Provider<ISoundService> soundServiceProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  public DashboardViewModel_Factory(Provider<Context> contextProvider,
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    this.contextProvider = contextProvider;
    this.getEmployeeLoginDetailsUseCaseProvider = getEmployeeLoginDetailsUseCaseProvider;
    this.soundServiceProvider = soundServiceProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(contextProvider.get(), getEmployeeLoginDetailsUseCaseProvider.get(), soundServiceProvider.get(), ioDispatcherProvider.get());
  }

  public static DashboardViewModel_Factory create(Provider<Context> contextProvider,
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<ISoundService> soundServiceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    return new DashboardViewModel_Factory(contextProvider, getEmployeeLoginDetailsUseCaseProvider, soundServiceProvider, ioDispatcherProvider);
  }

  public static DashboardViewModel newInstance(Context context,
      GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase, ISoundService soundService,
      CoroutineDispatcher ioDispatcher) {
    return new DashboardViewModel(context, getEmployeeLoginDetailsUseCase, soundService, ioDispatcher);
  }
}
