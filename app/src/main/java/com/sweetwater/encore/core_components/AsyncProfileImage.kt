package com.sweetwater.encore.core_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sweetwater.encore.R

@Composable
fun AsyncProfileImage(
    modifier: Modifier = Modifier,
    imageData: String,
    onTriggerSideMenu: () -> Unit
) {

//    GlideImage(
//        model = imageData,
//        contentDescription = stringResource(id = R.string.core_components_profile_image_content_description),
//        modifier = modifier
//            .padding(0.dp)
//            .clickable(onClick = onTriggerSideMenu)
//            .fillMaxSize(),
//        alignment = Alignment.Center,
//        contentScale = ContentScale.Fit
//    )

    AsyncImage(
        modifier = modifier
            .fillMaxSize()
            .padding(0.dp)
            .clickable(onClick = onTriggerSideMenu),
        model = imageData,
        contentDescription = stringResource(id = R.string.core_components_profile_image_content_description),
        contentScale = ContentScale.FillBounds,
        placeholder = painterResource(id = R.drawable.baseline_account_circle_24)
    )

}