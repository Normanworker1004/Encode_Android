package com.sweetwater.encore.dashboard.viewmodels;

import android.content.Context;
import android.util.Log;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.data.model.login.response.UserInfo;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.dashboard.DashboardUIEvent;
import com.sweetwater.encore.dashboard.SoundEvent;
import com.sweetwater.encore.dashboard.data.WorkflowIcon;
import com.sweetwater.encore.dashboard.state.DashboardState;
import com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarEvent;
import com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarState;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.utilities.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineDispatcher;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0017H\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/sweetwater/encore/dashboard/viewmodels/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "getEmployeeLoginDetailsUseCase", "Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;", "soundService", "Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_dashboardState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/dashboard/state/DashboardState;", "_versionName", "", "getContext", "()Landroid/content/Context;", "dashboardState", "Landroidx/compose/runtime/State;", "getDashboardState", "()Landroidx/compose/runtime/State;", "fetchUserInfo", "", "onCleared", "onEvent", "event", "Lcom/sweetwater/encore/dashboard/DashboardUIEvent;", "setIconsAndVersion", "app_debug"})
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    private final com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase = null;
    private final com.sweetwater.encore.dependency_injection.sound.ISoundService soundService = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private final androidx.compose.runtime.MutableState<com.sweetwater.encore.dashboard.state.DashboardState> _dashboardState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.dashboard.state.DashboardState> dashboardState = null;
    private final java.lang.String _versionName = "v{BuildConfig.VERSION_NAME}";
    
    @javax.inject.Inject
    public DashboardViewModel(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.sound.ISoundService soundService, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.dashboard.state.DashboardState> getDashboardState() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dashboard.DashboardUIEvent event) {
    }
    
    private final void setIconsAndVersion() {
    }
    
    private final void fetchUserInfo() {
    }
    
    @java.lang.Override
    protected void onCleared() {
    }
}