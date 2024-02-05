package com.sweetwater.encore.core_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sweetwater.encore.R

@Preview
@Composable
fun KeyboardIconPreview(
) {
    KeyboardIcon(onKeyboardToggled = {})
}

@Composable
fun KeyboardIcon(modifier: Modifier = Modifier, onKeyboardToggled: (Boolean) -> Unit) {
    Image(
        modifier = modifier
            .padding(8.dp)
            .clickable {
                onKeyboardToggled(true)
            },
        painter = painterResource(id = R.drawable.keyboard1x),
        contentDescription = stringResource(id = R.string.cycle_count_keyboard_toggle_content_description)
    )
}