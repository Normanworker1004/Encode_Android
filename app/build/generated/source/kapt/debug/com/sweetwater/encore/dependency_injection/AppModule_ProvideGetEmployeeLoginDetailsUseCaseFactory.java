package com.sweetwater.encore.dependency_injection;

import android.content.Context;
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
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
public final class AppModule_ProvideGetEmployeeLoginDetailsUseCaseFactory implements Factory<GetEmployeeLoginDetailsUseCase> {
  private final Provider<IUserInfoRepository> userInfoRepositoryImplProvider;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideGetEmployeeLoginDetailsUseCaseFactory(
      Provider<IUserInfoRepository> userInfoRepositoryImplProvider,
      Provider<Context> contextProvider) {
    this.userInfoRepositoryImplProvider = userInfoRepositoryImplProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public GetEmployeeLoginDetailsUseCase get() {
    return provideGetEmployeeLoginDetailsUseCase(userInfoRepositoryImplProvider.get(), contextProvider.get());
  }

  public static AppModule_ProvideGetEmployeeLoginDetailsUseCaseFactory create(
      Provider<IUserInfoRepository> userInfoRepositoryImplProvider,
      Provider<Context> contextProvider) {
    return new AppModule_ProvideGetEmployeeLoginDetailsUseCaseFactory(userInfoRepositoryImplProvider, contextProvider);
  }

  public static GetEmployeeLoginDetailsUseCase provideGetEmployeeLoginDetailsUseCase(
      IUserInfoRepository userInfoRepositoryImpl, Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideGetEmployeeLoginDetailsUseCase(userInfoRepositoryImpl, context));
  }
}
