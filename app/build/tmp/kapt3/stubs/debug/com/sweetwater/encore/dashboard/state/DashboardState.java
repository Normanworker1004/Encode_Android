package com.sweetwater.encore.dashboard.state;

import com.sweetwater.encore.authorization.data.model.login.response.UserInfo;
import com.sweetwater.encore.dashboard.data.WorkflowIcon;
import com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarState;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \'2\u00020\u0001:\u0001\'BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003JU\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\t\u0010&\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0012R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006("}, d2 = {"Lcom/sweetwater/encore/dashboard/state/DashboardState;", "", "isLoading", "", "userData", "Lcom/sweetwater/encore/authorization/data/model/login/response/UserInfo;", "error", "", "topAppBarState", "Lcom/sweetwater/encore/dashboard/topappbar/presentation/TopAppBarState;", "workflowIcons", "", "Lcom/sweetwater/encore/dashboard/data/WorkflowIcon;", "isSideMenuToggled", "versionName", "(ZLcom/sweetwater/encore/authorization/data/model/login/response/UserInfo;Ljava/lang/String;Lcom/sweetwater/encore/dashboard/topappbar/presentation/TopAppBarState;Ljava/util/List;ZLjava/lang/String;)V", "getError", "()Ljava/lang/String;", "()Z", "getTopAppBarState", "()Lcom/sweetwater/encore/dashboard/topappbar/presentation/TopAppBarState;", "getUserData", "()Lcom/sweetwater/encore/authorization/data/model/login/response/UserInfo;", "getVersionName", "getWorkflowIcons", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_debug"})
public final class DashboardState {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull
    private final com.sweetwater.encore.authorization.data.model.login.response.UserInfo userData = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String error = null;
    @org.jetbrains.annotations.NotNull
    private final com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarState topAppBarState = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.sweetwater.encore.dashboard.data.WorkflowIcon> workflowIcons = null;
    private final boolean isSideMenuToggled = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String versionName = null;
    @org.jetbrains.annotations.NotNull
    public static final com.sweetwater.encore.dashboard.state.DashboardState.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.dashboard.state.DashboardState copy(boolean isLoading, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.data.model.login.response.UserInfo userData, @org.jetbrains.annotations.NotNull
    java.lang.String error, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarState topAppBarState, @org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.dashboard.data.WorkflowIcon> workflowIcons, boolean isSideMenuToggled, @org.jetbrains.annotations.NotNull
    java.lang.String versionName) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public DashboardState(boolean isLoading, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.data.model.login.response.UserInfo userData, @org.jetbrains.annotations.NotNull
    java.lang.String error, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarState topAppBarState, @org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.dashboard.data.WorkflowIcon> workflowIcons, boolean isSideMenuToggled, @org.jetbrains.annotations.NotNull
    java.lang.String versionName) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.authorization.data.model.login.response.UserInfo component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.authorization.data.model.login.response.UserInfo getUserData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarState component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarState getTopAppBarState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.sweetwater.encore.dashboard.data.WorkflowIcon> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.sweetwater.encore.dashboard.data.WorkflowIcon> getWorkflowIcons() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean isSideMenuToggled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getVersionName() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/sweetwater/encore/dashboard/state/DashboardState$Companion;", "", "()V", "initialState", "Lcom/sweetwater/encore/dashboard/state/DashboardState;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sweetwater.encore.dashboard.state.DashboardState initialState() {
            return null;
        }
    }
}