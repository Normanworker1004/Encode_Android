package com.sweetwater.encore

import android.R
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.datadog.android.Datadog
import com.datadog.android.DatadogSite
import com.datadog.android.core.configuration.Configuration
import com.datadog.android.core.configuration.Credentials
import com.datadog.android.privacy.TrackingConsent
import com.datadog.android.rum.GlobalRum
import com.datadog.android.rum.RumMonitor
import com.datadog.android.rum.tracking.ActivityViewTrackingStrategy
import com.sweetwater.encore.authorization.data.AppLoginStatusStorage
import com.sweetwater.encore.navigation.AppNavController
import com.sweetwater.encore.ui.theme.SweetWaterTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SweetWaterActivity : ComponentActivity() {

    @Inject
    lateinit var storage: AppLoginStatusStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SweetWaterTheme {

                AppNavController(
                    authLoginStatusStorage = storage,
                    onExitApp = {
                        finishAffinity()
                    }
                )
            }
        }

        hideSystemUI()
        configureRumMonitoring()
        requestCameraPermission()
    }

    override fun onResume() {
        super.onResume()

        hideSystemUI()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        hideSystemUI()
    }

    // Function to hide NavigationBar
    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window,
            window.decorView.findViewById(R.id.content)).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())

            // When the screen is swiped up at the bottom
            // of the application, the navigationBar shall
            // appear for some time
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    private fun configureRumMonitoring() {
        val clientToken = BuildConfig.DATADOG_CLIENT_TOKEN;
        val applicationId = BuildConfig.DATADOG_APPLICATION_ID;

        val environmentName = BuildConfig.DATADOG_ENV;
        val appVariantName = "Encore - Android"

        val configuration = Configuration.Builder(
            rumEnabled = true,
            crashReportsEnabled = true,
            logsEnabled = true,
            tracesEnabled = true
        )
            .trackInteractions()
            .trackLongTasks(250L)
            .useViewTrackingStrategy(ActivityViewTrackingStrategy(trackExtras = true))
            .useSite(DatadogSite.US1)
            .trackBackgroundRumEvents(true)
            .build()
        val credentials = Credentials(clientToken,environmentName,appVariantName,applicationId)
        Datadog.initialize(this, credentials, configuration, TrackingConsent.GRANTED)
        GlobalRum.registerIfAbsent(RumMonitor.Builder().build())
    }

    val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            Log.i("Camera", "Permission granted")
        } else {
            Log.i("Camera", "Permission denied")
        }
    }

    fun requestCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CAMERA
                    ) == PackageManager.PERMISSION_GRANTED -> {
                        Log.i("Camera", "Permission previously granted")
                    }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                android.Manifest.permission.CAMERA
            ) -> Log.i("Camera", "Show camera permimssion dialog")

            else -> requestPermissionLauncher.launch(android.Manifest.permission.CAMERA)
        }
    }
}