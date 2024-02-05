package com.sweetwater.encore.authorization.viewmodels;

import androidx.compose.runtime.State;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.authorization.LoginUIEvent;
import com.sweetwater.encore.authorization.state.LoginUIState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/sweetwater/encore/authorization/viewmodels/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)V", "_loginUIState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/authorization/state/LoginUIState;", "loginState", "Landroidx/compose/runtime/State;", "getLoginState", "()Landroidx/compose/runtime/State;", "onEvent", "", "event", "Lcom/sweetwater/encore/authorization/LoginUIEvent;", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.SavedStateHandle savedStateHandle = null;
    private final androidx.compose.runtime.MutableState<com.sweetwater.encore.authorization.state.LoginUIState> _loginUIState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.authorization.state.LoginUIState> loginState = null;
    
    @javax.inject.Inject
    public LoginViewModel(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.authorization.state.LoginUIState> getLoginState() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.LoginUIEvent event) {
    }
}