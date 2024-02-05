package com.sweetwater.encore.core_components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sweetwater.encore.R

@Preview
@Composable
fun MessageBoxPreview() {
    MessageBox(title= "Error", message = "This is a message") {
    }
}


@Composable
fun MessageBox(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    onDismiss: () -> Unit
) {
    AlertDialog(
        modifier = modifier.padding(4.dp),
        onDismissRequest = onDismiss,
        title = {
            Text(text = title)
        },
        text = {
            Text(text = message)
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text(
                    text = stringResource(id = R.string.core_components_ok_button), style = TextStyle(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    )
}