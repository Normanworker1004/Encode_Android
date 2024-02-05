package com.sweetwater.encore.ui.theme

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalConfiguration

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ProvideDimens(
    dimensions: Dimensions,
    typography: com.sweetwater.encore.ui.theme.Typography,
    content: @Composable () -> Unit
) {

    val dimensionSet = remember {
        dimensions
    }

    val typographySet = remember {
        typography
    }

    CompositionLocalProvider(
        LocalAppDimensSm provides dimensionSet,
        LocalAppDimensSw360 provides dimensionSet,
        LocalAppTypography provides typographySet,
        LocalAppTypographySw360 provides typographySet,
        content = content
    )
}

private val LocalAppDimensSm = staticCompositionLocalOf {
    smallDimensions
}

private val LocalAppDimensSw360 = staticCompositionLocalOf {
    DimensionsSw360
}

private val LocalAppTypography = staticCompositionLocalOf {
    smallTypography
}

private val LocalAppTypographySw360 = staticCompositionLocalOf {
    TypographySw360
}

@Composable
fun SweetWaterTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val configuration = LocalConfiguration.current

    if (configuration.screenWidthDp <= 360) {
        Log.d("TAG", "AppTheme: Screen Width Dp is Less than or Equal to ${configuration.screenWidthDp}")
    } else {
        Log.d("TAG", "AppTheme: Screen Width Dp is ${configuration.screenWidthDp}")
    }

    val dimensions = if (configuration.screenWidthDp <= 360) smallDimensions else DimensionsSw360
    val typography = if (configuration.screenWidthDp <= 360) smallTypography else TypographySw360


    ProvideDimens(
        dimensions = dimensions,
        typography = typography
    ) {
        MaterialTheme(
            colors = colors,
            typography = fontTypography,
            shapes = Shapes,
            content = content
        )
    }

}

object AppTheme {
    val dimens: Dimensions
        @Composable
        get() = LocalAppDimensSm.current

    val typo: com.sweetwater.encore.ui.theme.Typography
        @Composable
        get() = LocalAppTypography.current
}

val Dimens: Dimensions
    @Composable
    get() = AppTheme.dimens

val Typo: com.sweetwater.encore.ui.theme.Typography
    @Composable
    get() = AppTheme.typo
