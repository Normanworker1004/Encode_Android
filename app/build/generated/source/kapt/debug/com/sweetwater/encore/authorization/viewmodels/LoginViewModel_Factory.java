package com.sweetwater.encore.authorization.viewmodels;

import androidx.lifecycle.SavedStateHandle;
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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public LoginViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(savedStateHandleProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<SavedStateHandle> savedStateHandleProvider) {
    return new LoginViewModel_Factory(savedStateHandleProvider);
  }

  public static LoginViewModel newInstance(SavedStateHandle savedStateHandle) {
    return new LoginViewModel(savedStateHandle);
  }
}
