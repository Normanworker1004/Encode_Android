package com.sweetwater.encore.authorization.usecases;

import android.content.Context;
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class GetEmployeeLoginDetailsUseCase_Factory implements Factory<GetEmployeeLoginDetailsUseCase> {
  private final Provider<IUserInfoRepository> userInfoRepositoryProvider;

  private final Provider<Context> contextProvider;

  public GetEmployeeLoginDetailsUseCase_Factory(
      Provider<IUserInfoRepository> userInfoRepositoryProvider, Provider<Context> contextProvider) {
    this.userInfoRepositoryProvider = userInfoRepositoryProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public GetEmployeeLoginDetailsUseCase get() {
    return newInstance(userInfoRepositoryProvider.get(), contextProvider.get());
  }

  public static GetEmployeeLoginDetailsUseCase_Factory create(
      Provider<IUserInfoRepository> userInfoRepositoryProvider, Provider<Context> contextProvider) {
    return new GetEmployeeLoginDetailsUseCase_Factory(userInfoRepositoryProvider, contextProvider);
  }

  public static GetEmployeeLoginDetailsUseCase newInstance(IUserInfoRepository userInfoRepository,
      Context context) {
    return new GetEmployeeLoginDetailsUseCase(userInfoRepository, context);
  }
}
