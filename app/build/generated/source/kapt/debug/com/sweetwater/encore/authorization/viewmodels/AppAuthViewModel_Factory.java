package com.sweetwater.encore.authorization.viewmodels;

import android.content.Context;
import com.sweetwater.encore.authorization.data.AppLoginStatusStorage;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.authorization.usecases.LoginEmployeeUseCase;
import com.sweetwater.encore.authorization.usecases.LogoutEmployeeUseCase;
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
public final class AppAuthViewModel_Factory implements Factory<AppAuthViewModel> {
  private final Provider<LoginEmployeeUseCase> loginEmployeeUseCaseProvider;

  private final Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider;

  private final Provider<LogoutEmployeeUseCase> logoutEmployeeUseCaseProvider;

  private final Provider<AppLoginStatusStorage> appAuthStatusStorageProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<Context> contextProvider;

  public AppAuthViewModel_Factory(Provider<LoginEmployeeUseCase> loginEmployeeUseCaseProvider,
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<LogoutEmployeeUseCase> logoutEmployeeUseCaseProvider,
      Provider<AppLoginStatusStorage> appAuthStatusStorageProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
    this.loginEmployeeUseCaseProvider = loginEmployeeUseCaseProvider;
    this.getEmployeeLoginDetailsUseCaseProvider = getEmployeeLoginDetailsUseCaseProvider;
    this.logoutEmployeeUseCaseProvider = logoutEmployeeUseCaseProvider;
    this.appAuthStatusStorageProvider = appAuthStatusStorageProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public AppAuthViewModel get() {
    return newInstance(loginEmployeeUseCaseProvider.get(), getEmployeeLoginDetailsUseCaseProvider.get(), logoutEmployeeUseCaseProvider.get(), appAuthStatusStorageProvider.get(), ioDispatcherProvider.get(), contextProvider.get());
  }

  public static AppAuthViewModel_Factory create(
      Provider<LoginEmployeeUseCase> loginEmployeeUseCaseProvider,
      Provider<GetEmployeeLoginDetailsUseCase> getEmployeeLoginDetailsUseCaseProvider,
      Provider<LogoutEmployeeUseCase> logoutEmployeeUseCaseProvider,
      Provider<AppLoginStatusStorage> appAuthStatusStorageProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider, Provider<Context> contextProvider) {
    return new AppAuthViewModel_Factory(loginEmployeeUseCaseProvider, getEmployeeLoginDetailsUseCaseProvider, logoutEmployeeUseCaseProvider, appAuthStatusStorageProvider, ioDispatcherProvider, contextProvider);
  }

  public static AppAuthViewModel newInstance(LoginEmployeeUseCase loginEmployeeUseCase,
      GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase,
      LogoutEmployeeUseCase logoutEmployeeUseCase, AppLoginStatusStorage appAuthStatusStorage,
      CoroutineDispatcher ioDispatcher, Context context) {
    return new AppAuthViewModel(loginEmployeeUseCase, getEmployeeLoginDetailsUseCase, logoutEmployeeUseCase, appAuthStatusStorage, ioDispatcher, context);
  }
}
