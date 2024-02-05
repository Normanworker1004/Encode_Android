package com.sweetwater.encore.authorization.usecases;

import android.content.Context;
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository;
import com.sweetwater.encore.external_api.dcservice.remote.DcServiceAPI;
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
public final class LoginEmployeeUseCase_Factory implements Factory<LoginEmployeeUseCase> {
  private final Provider<DcServiceAPI> apiProvider;

  private final Provider<IUserInfoRepository> userInfoRepositoryProvider;

  private final Provider<Context> contextProvider;

  public LoginEmployeeUseCase_Factory(Provider<DcServiceAPI> apiProvider,
      Provider<IUserInfoRepository> userInfoRepositoryProvider, Provider<Context> contextProvider) {
    this.apiProvider = apiProvider;
    this.userInfoRepositoryProvider = userInfoRepositoryProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public LoginEmployeeUseCase get() {
    return newInstance(apiProvider.get(), userInfoRepositoryProvider.get(), contextProvider.get());
  }

  public static LoginEmployeeUseCase_Factory create(Provider<DcServiceAPI> apiProvider,
      Provider<IUserInfoRepository> userInfoRepositoryProvider, Provider<Context> contextProvider) {
    return new LoginEmployeeUseCase_Factory(apiProvider, userInfoRepositoryProvider, contextProvider);
  }

  public static LoginEmployeeUseCase newInstance(DcServiceAPI api,
      IUserInfoRepository userInfoRepository, Context context) {
    return new LoginEmployeeUseCase(api, userInfoRepository, context);
  }
}
