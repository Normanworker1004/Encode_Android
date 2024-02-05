package com.sweetwater.encore.dashboard.topappbar.presentation;

import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/sweetwater/encore/dashboard/topappbar/presentation/TopAppBarViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_topAppBarState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/dashboard/topappbar/presentation/TopAppBarState;", "topAppBarState", "Landroidx/compose/runtime/State;", "getTopAppBarState", "()Landroidx/compose/runtime/State;", "onEvent", "", "event", "Lcom/sweetwater/encore/dashboard/topappbar/presentation/TopAppBarEvent;", "app_debug"})
public final class TopAppBarViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.compose.runtime.MutableState<com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarState> _topAppBarState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarState> topAppBarState = null;
    
    @javax.inject.Inject
    public TopAppBarViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarState> getTopAppBarState() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarEvent event) {
    }
}