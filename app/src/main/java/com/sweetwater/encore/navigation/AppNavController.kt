package com.sweetwater.encore.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sweetwater.encore.R
import com.sweetwater.encore.authorization.AppAuthEvent
import com.sweetwater.encore.authorization.data.AppLoginStatusStorage
import com.sweetwater.encore.authorization.data.model.logout.request.LogoutRequest
import com.sweetwater.encore.authorization.screens.LoginScreen
import com.sweetwater.encore.authorization.viewmodels.AppAuthViewModel
import com.sweetwater.encore.authorization.viewmodels.LoginViewModel
import com.sweetwater.encore.box_audit.screens.BoxAuditScanTrackingScreen
import com.sweetwater.encore.box_audit.viewmodels.BoxAuditScanTrackingViewModel
import com.sweetwater.encore.cart_scanner.screens.CartScannerScreen
import com.sweetwater.encore.cart_scanner.screens.ScanCartQrCodeScreen
import com.sweetwater.encore.cart_scanner.viewmodels.CartScannerViewModel
import com.sweetwater.encore.cart_scanner.viewmodels.ScanCartQrCodeViewModel
import com.sweetwater.encore.core_components.BasicSplashScreen
import com.sweetwater.encore.core_components.SideDrawer
import com.sweetwater.encore.core_components.TopAppBarScreen
import com.sweetwater.encore.cycle_counts.screens.CycleCountChooseZoneScreen
import com.sweetwater.encore.cycle_counts.screens.CycleCountCompleteScreen
import com.sweetwater.encore.cycle_counts.screens.CycleCountScanLocationScreen
import com.sweetwater.encore.cycle_counts.screens.CycleCountScanUpcsScreen
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountChooseZoneViewModel
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanLocationViewModel
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanUpcsViewModel
import com.sweetwater.encore.dashboard.DashboardUIEvent
import com.sweetwater.encore.dashboard.screens.DashboardUI
import com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarEvent
import com.sweetwater.encore.dashboard.viewmodels.DashboardViewModel
import com.sweetwater.encore.recounts.screens.RecountsChooseZoneScreen
import com.sweetwater.encore.recounts.screens.RecountsCompleteScreen
import com.sweetwater.encore.recounts.screens.RecountsScanLocationScreen
import com.sweetwater.encore.recounts.screens.RecountsScanProductScreen
import com.sweetwater.encore.recounts.screens.RecountsScanUPCScreen
import com.sweetwater.encore.recounts.viewmodels.RecountsChooseZoneViewModel
import com.sweetwater.encore.recounts.viewmodels.RecountsCompleteViewModel
import com.sweetwater.encore.recounts.viewmodels.RecountsScanLocationViewModel
import com.sweetwater.encore.recounts.viewmodels.RecountsScanProductViewModel
import com.sweetwater.encore.recounts.viewmodels.RecountsScanUPCViewModel
import com.sweetwater.encore.take_a_photo.screens.TakeAPhotoCaptureScreen
import com.sweetwater.encore.take_a_photo.screens.TakeAPhotoCompleteScreen
import com.sweetwater.encore.take_a_photo.screens.TakeAPhotoScanUPCScreen
import com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoCaptureViewModel
import com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoScanUPCViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavController(
    authLoginStatusStorage: AppLoginStatusStorage,
    onExitApp: () -> Unit,
    navController: NavHostController = rememberNavController()
) {
    val appAuthViewModel = hiltViewModel<AppAuthViewModel>()
    val appAuthState = appAuthViewModel.appAuthState.value

    val dashboardViewModel: DashboardViewModel = hiltViewModel()
    val dashboardState = dashboardViewModel.dashboardState.value

    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentRoute = currentDestination?.route?.substringBefore("/")
    val currentScreen = NavigationRoutes.find { it.route == currentRoute } ?: HomeMediator

    var topAppBarBackButtonBehavior = if (currentScreen.backButtonBehavior == "dashboard") {
        { navController.navigateToMostRecentCopyOf(Dashboard.route) }
    } else {
        { navController.navigateUp() }
    }

    if (currentScreen.route == PickModScannerScanCartQR.route) {
        val scanCartQrCode = remember(currentBackStack) {
            navController.getBackStackEntry(PickModScannerScanCartQR.route)
        }
        val scanCartQrCodeViewModel = hiltViewModel<ScanCartQrCodeViewModel>(scanCartQrCode)

        topAppBarBackButtonBehavior = {
            scanCartQrCodeViewModel.onBack()
            navController.navigateUp()
        }
    }

    if (currentScreen.route == PickModScannerCartScanner.route) {
        val cartScanner = remember(currentBackStack) {
            navController.getBackStackEntry(PickModScannerCartScanner.route)
        }
        val cartScannerViewModel = hiltViewModel<CartScannerViewModel>(cartScanner)

        topAppBarBackButtonBehavior = {
            cartScannerViewModel.onBack()
            navController.popBackStack(Dashboard.route, inclusive = false)
        }
    }

    val onToggleSideMenu = {
        (dashboardViewModel::onEvent)(DashboardUIEvent.TopBarEvent(TopAppBarEvent.ToggleProfileIcon))
        (appAuthViewModel::onEvent)(
            AppAuthEvent.ClearErrors
        )
    }

    val onLogoutAction = {
        (appAuthViewModel::onEvent)(
            AppAuthEvent.SignOut(LogoutRequest(
                employeeNumber = appAuthState.userData.employeeNumber,
            ), onSignOutSuccess = {
                navController.navigateSingleTopTo(Login.route)
            })
        )

        (appAuthViewModel::onEvent)(
            AppAuthEvent.ClearErrors
        )
    }

    Scaffold(topBar = {
        TopAppBarScreen(
            appAuthState = appAuthState,
            onToggleSideMenu = { onToggleSideMenu() },
            currentScreen = currentScreen,
            onBackButtonPressed = { topAppBarBackButtonBehavior() },
        )
    }) {
        Image(
            painter = painterResource(id = R.drawable.encore_bg),
            contentDescription = stringResource(id = R.string.login_background_encore_image_content_description),
            contentScale = ContentScale.FillBounds
        )

        NavHost(
            navController = navController, startDestination = HomeMediator.route
        ) {

            composable(route = HomeMediator.route) {
                HomeMediator(authLoginStatusStorage = authLoginStatusStorage,
                    onLoggedIn = { navController.navigateSingleTopTo(Dashboard.route) },
                    onLoggedOut = { navController.navigateSingleTopTo(Login.route) },
                    onLoginUndetermined = { navController.navigateSingleTopTo(BasicSplash.route) })
            }

            composable(route = Login.route) {
                val loginViewModel = hiltViewModel<LoginViewModel>()
                val loginUiState = loginViewModel.loginState.value

                LoginScreen(
                    loginUIEvent = loginViewModel::onEvent,
                    loginUIState = loginUiState,
                    appAuthEvent = appAuthViewModel::onEvent,
                    appAuthState = appAuthState,
                    onLogin = {
                        navController.navigateToMostRecentCopyOf(HomeMediator.route)
                    },
                    onExitApp = onExitApp
                )
            }

            composable(route = Dashboard.route) {
                DashboardUI(
                    dashboardUiState = dashboardState,
                    dashboardUIEvent = dashboardViewModel::onEvent,
                    appAuthState = appAuthState,
                    onLoggedOut = {
                        navController.navigateToMostRecentCopyOf(HomeMediator.route)
                    },
                    onClickedProductRecounts = {
                        navController.navigateSingleTopTo(
                            ProductRecountsChooseZone.route
                        )
                    },
                    onClickedPickModScanner = {
                        navController.navigateSingleTopTo(
                            PickModScannerScanCartQR.route
                        )
                    },
                    onClickedTakeAPhoto = { navController.navigateSingleTopTo(TakeAPhotoScanUPC.route) },
                    onClickedCycleCounts = { navController.navigateSingleTopTo(CycleCountsChooseZone.route) },
                    onClickedBoxAudit = { navController.navigateSingleTopTo(BoxAuditScanTracking.route) },
                )
            }

            composable(
                route = CycleCountsChooseZone.route
            ) {
                val cycleCountChooseZoneViewModel: CycleCountChooseZoneViewModel = hiltViewModel()

                CycleCountChooseZoneScreen(viewModel = cycleCountChooseZoneViewModel,
                    onNavigateToScanLocation = { zoneId ->
                        navController.navigateSingleTopTo("${CycleCountsScanLocation.route}/$zoneId")
                    },
                    onBackEvent = { navController.navigateUp() })
            }


            composable(
                route = CycleCountsScanLocation.routeWithArgs,
                arguments = CycleCountsScanLocation.arguments
            ) {
                val cycleCountScanLocationViewModel: CycleCountScanLocationViewModel =
                    hiltViewModel()

                CycleCountScanLocationScreen(viewModel = cycleCountScanLocationViewModel,
                    onBackEvent = { navController.navigateUp() },
                    onNavigateToCycleCountScanUpcs = { locationName, countRequestId ->
                        navController.navigateSingleTopTo("${CycleCountScanUpcs.route}/$locationName/$countRequestId")
                    })
            }
            composable(
                route = CycleCountScanUpcs.routeWithArgs, arguments = CycleCountScanUpcs.arguments
            ) {
                val cycleCountScanUpcsViewModel: CycleCountScanUpcsViewModel = hiltViewModel()

                CycleCountScanUpcsScreen(viewModel = cycleCountScanUpcsViewModel,
                    onDoneButtonClicked = {},
                    onBackEvent = {
                        navController.navigateUp()
                    },
                    onComplete = { varianceReported, locationName ->
                        navController.navigateSingleTopTo("${CycleCountComplete.route}/$varianceReported/$locationName")
                    })
            }

            composable(
                route = CycleCountComplete.routeWithArgs, arguments = CycleCountComplete.arguments
            ) {
                val scanLocation = remember(currentBackStack) {
                    navController.getBackStackEntry(CycleCountsScanLocation.routeWithArgs)
                }
                val scanLocationViewModel =
                    hiltViewModel<CycleCountScanLocationViewModel>(scanLocation) // TODO: Don't provide another screen's state
                CycleCountCompleteScreen(locationName = it.arguments?.getString(CycleCountComplete.locationName)!!,
                    varianceReported = it.arguments?.getBoolean(CycleCountComplete.varianceReported)!!,
                    locationsList = scanLocationViewModel.cycleCountScanLocationState.value.assignedLocations,
                    onNavigateToScanLocation = {
                        navController.popBackStack(
                            CycleCountsScanLocation.routeWithArgs, inclusive = false
                        )
                    })
            }

            composable(route = ProductRecountsChooseZone.route) {
                val recountsChooseZoneViewModel: RecountsChooseZoneViewModel = hiltViewModel()

                RecountsChooseZoneScreen(
                    viewModel = recountsChooseZoneViewModel,
                    onBackEvent = { navController.navigateUp() },
                    onNavigateToScanProduct = { zoneId, zoneName ->
                        navController.navigateSingleTopTo(
                            "${ProductRecountsScanProduct.route}/$zoneId/$zoneName"
                        )
                    },
                )
            }

            composable(
                route = ProductRecountsScanProduct.routeWithArgs,
                arguments = ProductRecountsScanProduct.arguments
            ) {
                val recountsScanProductViewModel: RecountsScanProductViewModel = hiltViewModel()

                RecountsScanProductScreen(
                    onReturnToChooseZone = { navController.navigateUp() },
                    onProductClicked = {
                        navController.navigateSingleTopTo(ProductRecountsScanLocation.route)
                    },
                    viewModel = recountsScanProductViewModel
                )
            }

            composable(route = ProductRecountsScanLocation.route) {
                val recountsScanLocationViewModel: RecountsScanLocationViewModel = hiltViewModel()

                RecountsScanLocationScreen(viewModel = recountsScanLocationViewModel,
                    onReturnToScanProductScreen = { navController.navigateUp() },
                    onLocationSelected = { locationName ->
                        navController.navigateSingleTopTo("${ProductRecountsScanUPCs.route}/$locationName")
                    })
            }

            composable(
                route = ProductRecountsScanUPCs.routeWithArgs,
                arguments = ProductRecountsScanUPCs.arguments
            ) {
                val viewModel: RecountsScanUPCViewModel = hiltViewModel()
                RecountsScanUPCScreen(viewModel = viewModel,
                    onReturnToScanLocation = { navController.navigateUp() },
                    onRecountComplete = { locationName, wasForced ->
                        navController.navigateSingleTopTo("${ProductRecountsCountComplete.route}/${locationName}/${wasForced}")
                    })
            }

            composable(
                route = ProductRecountsCountComplete.routeWithArgs,
                arguments = ProductRecountsCountComplete.arguments
            ) {
                val locationName =
                    it.arguments?.getString(ProductRecountsCountComplete.locationNameArg)
                val isForced = it.arguments?.getBoolean(ProductRecountsCountComplete.isForcedArg)

                val viewModel: RecountsCompleteViewModel = hiltViewModel()

                RecountsCompleteScreen(viewModel = viewModel,
                    locationName = locationName!!,
                    varianceReported = isForced!!,
                    onNavigateToScanLocation = { outOfLocations ->
                        if (outOfLocations) {
                            navController.popBackStack(
                                ProductRecountsScanProduct.routeWithArgs, inclusive = false
                            )
                        } else {
                            navController.popBackStack(
                                ProductRecountsScanLocation.route, inclusive = false
                            )
                        }
                    })
            }


            composable(route = PickModScannerScanCartQR.route) {
                val scanCartQrCodeViewModel: ScanCartQrCodeViewModel = hiltViewModel()

                ScanCartQrCodeScreen(
                    viewModel = scanCartQrCodeViewModel,
                    onBack = {
                        navController.navigateUp()
                    },
                    onCartRegistered = {
                        navController.navigateSingleTopTo(PickModScannerCartScanner.route)
                    },
                )
            }

            composable(route = PickModScannerCartScanner.route) {
                val cartScannerViewModel: CartScannerViewModel = hiltViewModel()

                CartScannerScreen(
                    viewModel = cartScannerViewModel,
                    onBack = {
                        navController.popBackStack(Dashboard.route, inclusive = false)
                    },
                )
            }

            composable(route = TakeAPhotoScanUPC.route) {
                val takeAPhotoScanUPCViewModel: TakeAPhotoScanUPCViewModel = hiltViewModel()
                TakeAPhotoScanUPCScreen(viewModel = takeAPhotoScanUPCViewModel,
                    onReturnToDashboard = { navController.navigateSingleTopTo(Dashboard.route) },
                    onUPCScanned = {
                        val tagText = it
                        navController.navigateSingleTopTo("${TakeAPhotoCapture.route}/$tagText")
                    })
            }

            composable(
                route = TakeAPhotoCapture.routeWithArgs, arguments = TakeAPhotoCapture.arguments
            ) {
                val takeAPhotoCaptureViewModel: TakeAPhotoCaptureViewModel = hiltViewModel()

                TakeAPhotoCaptureScreen(viewModel = takeAPhotoCaptureViewModel,
                    onReturnToScanUPC = { navController.navigateSingleTopTo(TakeAPhotoScanUPC.route) },
                    onWorkflowComplete = { navController.navigateSingleTopTo(TakeAPhotoComplete.route) })
            }

            composable(route = TakeAPhotoComplete.route) {
                TakeAPhotoCompleteScreen(onReturnToDashboard = {
                    navController.navigateSingleTopTo(
                        Dashboard.route
                    )
                },
                    onTakeAnotherPhoto = { navController.navigateSingleTopTo(TakeAPhotoScanUPC.route) })
            }

            composable(route = BasicSplash.route) {
                BasicSplashScreen()
            }

            composable(route = BoxAuditScanTracking.route) {
                val boxAuditScanTrackingViewModel: BoxAuditScanTrackingViewModel = hiltViewModel()

                BoxAuditScanTrackingScreen(
                    viewModel = boxAuditScanTrackingViewModel,
                    onBackEvent = { navController.navigateUp() },
                )
            }
        }

        SideDrawer(isOpen = dashboardState.topAppBarState.isTopBarMenuIconToggled,
            appAuthState = appAuthState,
            onToggleSideMenu = onToggleSideMenu,
            onDismissSideMenu = onToggleSideMenu,
            onLogoutAction = {
                onLogoutAction()
                onToggleSideMenu()
            })
    }
}

fun NavHostController.navigateSingleTopTo(route: String) = this.navigate(route) {
    launchSingleTop = true
}

fun NavHostController.navigateToMostRecentCopyOf(route: String) = this.navigate(route) {
    this.popUpTo(route) {
        inclusive = false
    }
    launchSingleTop = true
}