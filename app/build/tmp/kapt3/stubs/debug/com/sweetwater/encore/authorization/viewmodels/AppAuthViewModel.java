package com.sweetwater.encore.authorization.viewmodels;

import android.content.Context;
import android.util.Log;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.BuildConfig;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.AppAuthEvent;
import com.sweetwater.encore.authorization.data.AppLoginStatusStorage;
import com.sweetwater.encore.authorization.data.enums.SignInMode;
import com.sweetwater.encore.authorization.data.model.login.request.LoginRequest;
import com.sweetwater.encore.authorization.data.model.login.response.UserInfo;
import com.sweetwater.encore.authorization.data.model.logout.request.LogoutRequest;
import com.sweetwater.encore.authorization.state.AppAuthState;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.authorization.usecases.LoginEmployeeUseCase;
import com.sweetwater.encore.authorization.usecases.LogoutEmployeeUseCase;
import com.sweetwater.encore.utilities.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineDispatcher;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ&\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190#H\u0002J\u001e\u0010$\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190#H\u0002J\u001e\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190#H\u0002R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082D\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/sweetwater/encore/authorization/viewmodels/AppAuthViewModel;", "Landroidx/lifecycle/ViewModel;", "loginEmployeeUseCase", "Lcom/sweetwater/encore/authorization/usecases/LoginEmployeeUseCase;", "getEmployeeLoginDetailsUseCase", "Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;", "logoutEmployeeUseCase", "Lcom/sweetwater/encore/authorization/usecases/LogoutEmployeeUseCase;", "appAuthStatusStorage", "Lcom/sweetwater/encore/authorization/data/AppLoginStatusStorage;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "context", "Landroid/content/Context;", "(Lcom/sweetwater/encore/authorization/usecases/LoginEmployeeUseCase;Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;Lcom/sweetwater/encore/authorization/usecases/LogoutEmployeeUseCase;Lcom/sweetwater/encore/authorization/data/AppLoginStatusStorage;Lkotlinx/coroutines/CoroutineDispatcher;Landroid/content/Context;)V", "_appAuthState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/authorization/state/AppAuthState;", "_versionName", "", "appAuthState", "Landroidx/compose/runtime/State;", "getAppAuthState", "()Landroidx/compose/runtime/State;", "fetchAppInfo", "", "onEvent", "event", "Lcom/sweetwater/encore/authorization/AppAuthEvent;", "signIn", "loginRequest", "Lcom/sweetwater/encore/authorization/data/model/login/request/LoginRequest;", "signInMode", "Lcom/sweetwater/encore/authorization/data/enums/SignInMode;", "onSignInSuccess", "Lkotlin/Function0;", "signInEmployee", "signOut", "logoutRequest", "Lcom/sweetwater/encore/authorization/data/model/logout/request/LogoutRequest;", "onSignOutSuccess", "app_debug"})
public final class AppAuthViewModel extends androidx.lifecycle.ViewModel {
    private final com.sweetwater.encore.authorization.usecases.LoginEmployeeUseCase loginEmployeeUseCase = null;
    private final com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase = null;
    private final com.sweetwater.encore.authorization.usecases.LogoutEmployeeUseCase logoutEmployeeUseCase = null;
    private final com.sweetwater.encore.authorization.data.AppLoginStatusStorage appAuthStatusStorage = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private final android.content.Context context = null;
    private final androidx.compose.runtime.MutableState<com.sweetwater.encore.authorization.state.AppAuthState> _appAuthState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.authorization.state.AppAuthState> appAuthState = null;
    private final java.lang.String _versionName = "v1.0.10";
    
    @javax.inject.Inject
    public AppAuthViewModel(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.usecases.LoginEmployeeUseCase loginEmployeeUseCase, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.usecases.LogoutEmployeeUseCase logoutEmployeeUseCase, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.data.AppLoginStatusStorage appAuthStatusStorage, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.authorization.state.AppAuthState> getAppAuthState() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.AppAuthEvent event) {
    }
    
    private final void signIn(com.sweetwater.encore.authorization.data.model.login.request.LoginRequest loginRequest, com.sweetwater.encore.authorization.data.enums.SignInMode signInMode, kotlin.jvm.functions.Function0<kotlin.Unit> onSignInSuccess) {
    }
    
    private final void signInEmployee(com.sweetwater.encore.authorization.data.model.login.request.LoginRequest loginRequest, kotlin.jvm.functions.Function0<kotlin.Unit> onSignInSuccess) {
    }
    
    private final void fetchAppInfo() {
    }
    
    private final void signOut(com.sweetwater.encore.authorization.data.model.logout.request.LogoutRequest logoutRequest, kotlin.jvm.functions.Function0<kotlin.Unit> onSignOutSuccess) {
    }
}