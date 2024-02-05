package com.sweetwater.encore.dashboard.viewmodels

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.data.model.login.response.UserInfo
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase
import com.sweetwater.encore.dashboard.DashboardUIEvent
import com.sweetwater.encore.dashboard.SoundEvent
import com.sweetwater.encore.dashboard.data.WorkflowIcon
import com.sweetwater.encore.dashboard.state.DashboardState
import com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarEvent
import com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarState
import com.sweetwater.encore.dependency_injection.sound.ISoundService
import com.sweetwater.encore.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    val context: Context,
    private val getEmployeeLoginDetailsUseCase: GetEmployeeLoginDetailsUseCase,
    private val soundService: ISoundService,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _dashboardState = mutableStateOf(
        DashboardState(
            isSideMenuToggled = false,
            userData = UserInfo.initialState(),
            topAppBarState = TopAppBarState(
                topBarMenuLabel = "",
                barCodeIcon = -1,
                profileIcon = ""
            ),
        )
    )

    val dashboardState: State<DashboardState> = _dashboardState

    private val _versionName = "v{BuildConfig.VERSION_NAME}"

    init {
        setIconsAndVersion()
    }

    fun onEvent(event: DashboardUIEvent) {
        when (event) {
            is DashboardUIEvent.FetchUserInfo -> {
                fetchUserInfo()
            }

            is DashboardUIEvent.ToggleSideMenu -> {
                _dashboardState.value = dashboardState.value.copy(
                    isSideMenuToggled = !dashboardState.value.isSideMenuToggled
                )
            }

            is DashboardUIEvent.ClearError -> {
                _dashboardState.value = dashboardState.value.copy(
                    error = ""
                )
            }

            is DashboardUIEvent.PlaySoundEvent -> {
                when (event.soundEvent) {
                    SoundEvent.PlayNegativeFeedbackSound -> soundService.playNegativeFeedbackSound()
                    SoundEvent.PlayPositiveFeedbackSound -> soundService.playPositiveFeedbackSound()
                }
            }

            is DashboardUIEvent.TopBarEvent -> {
                when (event.topAppBarEvent) {
                    is TopAppBarEvent.ToggleBarCodeIcon -> {
                        _dashboardState.value = dashboardState.value.copy(
                            topAppBarState = TopAppBarState(
                                topBarMenuLabel = dashboardState.value.topAppBarState.topBarMenuLabel,
                                barCodeIcon = if (dashboardState.value.topAppBarState.barCodeIcon == -1) R.drawable.qr_code_2_24 else -1,
                                profileIcon = dashboardState.value.userData.icon
                            )
                        )

                    }

                    is TopAppBarEvent.ToggleMenuIcon -> {
                        _dashboardState.value = dashboardState.value.copy(
                            isSideMenuToggled = !dashboardState.value.isSideMenuToggled
                        )
                    }

                    is TopAppBarEvent.ToggleProfileIcon -> {
                        _dashboardState.value = dashboardState.value.copy(
                            topAppBarState = TopAppBarState(
                                isTopBarMenuIconToggled = !dashboardState.value.topAppBarState.isTopBarMenuIconToggled,
                                topBarMenuLabel = dashboardState.value.topAppBarState.topBarMenuLabel,
                                barCodeIcon = dashboardState.value.topAppBarState.barCodeIcon,
                                profileIcon = dashboardState.value.userData.icon
                            )
                        )
                    }

                    is TopAppBarEvent.ToggleTopBarMenuLabel -> {
                        _dashboardState.value = dashboardState.value.copy(
                            topAppBarState = TopAppBarState(
                                topBarMenuLabel = event.topAppBarEvent.topBarMenuLabel,
                                barCodeIcon = dashboardState.value.topAppBarState.barCodeIcon,
                                profileIcon = dashboardState.value.userData.icon
                            )
                        )
                    }
                }
            }

            else -> {}
        }
    }

    private fun setIconsAndVersion() {
        val workflowIcons = mutableListOf(
            WorkflowIcon(
                iconId = R.drawable.counts,
                title = context.getString(R.string.dashboard_cycle_count_title)
            ),
            WorkflowIcon(
                iconId = R.drawable.recounts,
                title = context.getString(R.string.dashboard_product_recount_title)
            ),
            WorkflowIcon(
                iconId = R.drawable.qr_code_ryan,
                title = context.getString(R.string.dashboard_pickmod_scanner_title)
            ),
            WorkflowIcon(
                iconId = R.drawable.blackcamera,
                title = context.getString(R.string.take_a_photo_title)
            ),
            WorkflowIcon(
                iconId = R.drawable.box_audit_icon,
                title = context.getString(R.string.dashboard_box_audit_title)
            ),
//            WorkflowIcon(
//                iconId = R.drawable.baseline_all_inbox_24,
//                title = context.getString(R.string.dashboard_receive_po_title)
//            ),
//            WorkflowIcon(
//                iconId = R.drawable.baseline_all_inbox_24,
//                title = context.getString(R.string.dashboard_receive_by_item_title)
//            ),
//            WorkflowIcon(
//                iconId = R.drawable.baseline_all_inbox_24,
//                title = context.getString(R.string.dashboard_customer_pickup_title)
//            ),
//            WorkflowIcon(
//                iconId = R.drawable.baseline_all_inbox_24,
//                title =  context.getString(R.string.dashboard_nonconpicking_title)
//            ),
//            WorkflowIcon(
//                iconId = R.drawable.baseline_all_inbox_24,
//                title = context.getString(R.string.dashboard_admin_moves_title)
//            ),
        )

        _dashboardState.value = dashboardState.value.copy(
            workflowIcons = workflowIcons, versionName = _versionName
        )
    }

    private fun fetchUserInfo() {
        try {
            viewModelScope.launch {
                getEmployeeLoginDetailsUseCase().flowOn(ioDispatcher).collectLatest {
                    when (it) {
                        is Resource.Error -> {
                            _dashboardState.value = dashboardState.value.copy(
                                userData = UserInfo.initialState(), error = ""
                            )
                        }

                        is Resource.Loading -> {
                            _dashboardState.value = dashboardState.value.copy(
                                isLoading = it.isLoading
                            )
                        }

                        is Resource.Success -> {
                            _dashboardState.value = dashboardState.value.copy(
                                userData = it.data!!, error = ""
                            )
                        }
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("AppViewModel", "Fetch User : Error: ", e)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "Dashboard ViewModel Cleared")
    }
}