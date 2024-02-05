package com.sweetwater.encore.dependency_injection;

import android.content.Context;
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository;
import com.sweetwater.encore.authorization.usecases.LoginEmployeeUseCase;
import com.sweetwater.encore.external_api.dcservice.remote.DcServiceAPI;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_ProvideLoginEmployeeUseCaseFactory implements Factory<LoginEmployeeUseCase> {
  private final Provider<DcServiceAPI> apiProvider;

  private final Provider<IUserInfoRepository> userInfoRepositoryImplProvider;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideLoginEmployeeUseCaseFactory(Provider<DcServiceAPI> apiProvider,
      Provider<IUserInfoRepository> userInfoRepositoryImplProvider,
      Provider<Context> contextProvider) {
    this.apiProvider = apiProvider;
    this.userInfoRepositoryImplProvider = userInfoRepositoryImplProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public LoginEmployeeUseCase get() {
    return provideLoginEmployeeUseCase(apiProvider.get(), userInfoRepositoryImplProvider.get(), contextProvider.get());
  }

  public static AppModule_ProvideLoginEmployeeUseCaseFactory create(
      Provider<DcServiceAPI> apiProvider,
      Provider<IUserInfoRepository> userInfoRepositoryImplProvider,
      Provider<Context> contextProvider) {
    return new AppModule_ProvideLoginEmployeeUseCaseFactory(apiProvider, userInfoRepositoryImplProvider, contextProvider);
  }

  public static LoginEmployeeUseCase provideLoginEmployeeUseCase(DcServiceAPI api,
      IUserInfoRepository userInfoRepositoryImpl, Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideLoginEmployeeUseCase(api, userInfoRepositoryImpl, context));
  }
}
