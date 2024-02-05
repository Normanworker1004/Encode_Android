package com.sweetwater.encore.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.sweetwater.encore.R

/* Basic navigation setup from Splash to Dashboard */
interface NavigationRoute {
    val route: String
    val titleResourceId: Int?
    val showNavBar: Boolean
    val showBackButton: Boolean
    val backButtonBehavior: String
}

val NavigationRoutes = listOf(
    Login,
    HomeMediator,
    Dashboard,
    CycleCountsChooseZone,
    CycleCountsScanLocation,
    CycleCountScanUpcs,
    CycleCountComplete,
    ProductRecountsChooseZone,
    ProductRecountsScanProduct,
    ProductRecountsScanLocation,
    ProductRecountsScanUPCs,
    ProductRecountsCountComplete,
    PickModScannerScanCartQR,
    PickModScannerCartScanner,
    TakeAPhotoScanUPC,
    TakeAPhotoCapture,
    TakeAPhotoComplete,
    BoxAuditScanTracking,
    BasicSplash
)

object Login : NavigationRoute {
    override val route = "sw_login"
    override val titleResourceId = null
    override val showNavBar = false
    override val showBackButton = false
    override val backButtonBehavior = "none"
}

object HomeMediator : NavigationRoute {
    override val route = "sw_home_mediator"
    override val titleResourceId = null
    override val showNavBar = false
    override val showBackButton = false
    override val backButtonBehavior = "none"
}

object Dashboard : NavigationRoute {
    override val route = "sw_dashboard"
    override val titleResourceId = R.string.dashboard_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = false
    override val backButtonBehavior = "none"
}

object CycleCountsChooseZone : NavigationRoute {
    override val route = "cycle_count_choose_zone"
    override val titleResourceId = R.string.cycle_count_choose_zone_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = true
    override val backButtonBehavior = "up"
}

object CycleCountsScanLocation : NavigationRoute {
    override val route = "cycle_count_scan_location"
    const val zoneIdArg = "zoneId"
    val routeWithArgs = "${route}/{${zoneIdArg}}"
    val arguments = listOf(
        navArgument(zoneIdArg) { type = NavType.IntType }
    )
    override val titleResourceId = R.string.cycle_count_scan_location_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = true
    override val backButtonBehavior = "up"
}

object CycleCountScanUpcs : NavigationRoute {
    override val route = "cycle_count_scan_upcs"
    const val locationName = "locationName"
    const val countRequestId = "countRequestId"
    val routeWithArgs = "${route}/{${locationName}}/{${countRequestId}}"
    val arguments = listOf(
        navArgument(locationName) { type = NavType.StringType },
        navArgument(countRequestId) { type = NavType.IntType },
    )
    override val titleResourceId = R.string.cycle_count_scan_upcs_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = true
    override val backButtonBehavior = "up"
}

object CycleCountComplete : NavigationRoute {
    override val route = "cycle_count_complete"
    const val varianceReported = "varianceReported"
    const val locationName = "locationName"
    val routeWithArgs = "${route}/{${varianceReported}}/{${locationName}}"
    val arguments = listOf(
        navArgument(varianceReported) { type = NavType.BoolType },
        navArgument(locationName) { type = NavType.StringType }
    )
    override val titleResourceId = R.string.cycle_count_count_complete_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = false
    override val backButtonBehavior = "none"
}

object ProductRecountsChooseZone : NavigationRoute {
    override val route = "product_recounts_choose_zone"
    override val titleResourceId = R.string.recounts_choose_zone_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = true
    override val backButtonBehavior = "up"
}

object BoxAuditScanTracking : NavigationRoute {
    override val route = "box_audit_scan_tracking"
    override val titleResourceId = R.string.box_audit_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = true
    override val backButtonBehavior = "up"
}

object ProductRecountsScanProduct : NavigationRoute {
    override val route = "product_recounts_scan_product"
    const val zoneIdArg = "zoneId"
    const val zoneNameArg = "zoneName"
    override val titleResourceId = R.string.recounts_product_recount_top_bar_menu_label
    override val showNavBar = true
    val routeWithArgs = "${route}/{${zoneIdArg}}/{${zoneNameArg}}"
    val arguments = listOf(
        navArgument(zoneIdArg) { type = NavType.IntType },
        navArgument(zoneNameArg) { type = NavType.StringType }
    )
    override val showBackButton = true
    override val backButtonBehavior = "up"
}

object ProductRecountsScanLocation : NavigationRoute {
    override val route = "product_recounts_scan_location"
    override val titleResourceId = R.string.recounts_scan_location_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = true
    override val backButtonBehavior = "up"
}

object ProductRecountsScanUPCs : NavigationRoute {
    override val route = "product_recounts_scan_upcs"
    override val titleResourceId = R.string.recounts_scan_upcs_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = true
    const val locationNameArg = "locationName"
    val routeWithArgs = "${route}/{${locationNameArg}}"
    val arguments = listOf(
        navArgument(locationNameArg) { type = NavType.StringType },
    )
    override val backButtonBehavior = "up"
}

object ProductRecountsCountComplete : NavigationRoute {
    override val route = "product_recounts_count_complete"
    override val titleResourceId = R.string.recounts_complete_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = true
    const val locationNameArg = "locationName"
    const val isForcedArg = "isForced"
    val routeWithArgs = "${route}/{${locationNameArg}}/{${isForcedArg}}"
    val arguments = listOf(
        navArgument(locationNameArg) { type = NavType.StringType },
        navArgument(isForcedArg) { type = NavType.BoolType }
    )
    override val backButtonBehavior = "up"
}

object PickModScannerScanCartQR : NavigationRoute {
    override val route = "pick_mod_scanner_scan_cart_qr"
    override val titleResourceId = R.string.pickmod_scanner_scan_cart_qr_code_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = true
    override val backButtonBehavior = "up"

}

object PickModScannerCartScanner : NavigationRoute {
    override val route = "pick_mod_cart_scanner"
    override val titleResourceId = R.string.pickmod_scanner_cart_scanner_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = true
    override val backButtonBehavior = "dashboard"
}

object TakeAPhotoScanUPC : NavigationRoute {
    override val route = "take_a_photo_scan_upc"
    override val titleResourceId = R.string.take_a_photo_scan_upc_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = true
    override val backButtonBehavior = "up"

}

object TakeAPhotoCapture : NavigationRoute {
    override val route = "take_a_photo_capture"
    const val tagText = "tagText"
    override val titleResourceId = R.string.take_a_photo_capture_image_top_bar_menu_label
    override val showNavBar = true
    override val showBackButton = true
    val routeWithArgs = "${route}/{${tagText}}"
    val arguments = listOf(
        navArgument(tagText) { type = NavType.StringType }
    )
    override val backButtonBehavior = "up"

}

object TakeAPhotoComplete : NavigationRoute {
    override val route = "take_a_photo_complete"
    override val titleResourceId = R.string.take_a_photo_upload_complete
    override val showNavBar = true
    override val showBackButton = true
    override val backButtonBehavior = "dashboard"
}

object BasicSplash : NavigationRoute {
    override val route = "basic_splash"
    override val titleResourceId = null
    override val showNavBar = false
    override val showBackButton = false
    override val backButtonBehavior = "none"

}