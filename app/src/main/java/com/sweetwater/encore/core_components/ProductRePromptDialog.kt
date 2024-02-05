package com.sweetwater.encore.core_components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.sweetwater.encore.R
import com.sweetwater.encore.ui.theme.AppTheme
import com.sweetwater.encore.ui.theme.dismissRed
import com.sweetwater.encore.ui.theme.textFieldBackground

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 360,
    heightDp = 640
)
@Composable
private fun ProductRePromptDialogPreview() {
    ProductRePromptDialog(
        show = true,
        dialogTitle = "Please enter the product UPC/serial number.",
        inputText = "",
        inputHintText = "Enter Serial",
        onInputTextChanged = {},
        onDismiss = {},
        onConfirm = {},
        onWindowActive = {}
    )
}

@Composable
fun ProductRePromptDialog(
    show: Boolean,
    dialogTitle: String,
    inputText: String,
    inputHintText: String,
    onInputTextChanged: (inputTextString: String) -> Unit,
    onWindowActive: (visible: Boolean) -> Unit,
    onDismiss: () -> Unit,
    onConfirm: (inputTextString: String) -> Unit,
) {

    var enteredTextInput by remember {
        mutableStateOf("")
    }

    if (show) {

        onWindowActive(true)

        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {

            Card(
                modifier = Modifier
                    .padding(12.dp),
                shape = RoundedCornerShape(18.dp)
            ) {

                Column(
                    modifier = Modifier
                        .background(
                            color = textFieldBackground
                        )
                ) {

                    Spacer(modifier = Modifier.height(AppTheme.dimens.gridItem_2))

                    BasicTextLabel(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = stringResource(R.string.core_components_manual_entry_label),
                        fontSize = AppTheme.typo.textSize_16.value.toInt(),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(0.dp))

                    BasicTextLabel(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(horizontal = AppTheme.dimens.gridItem_2, vertical = 4.dp),
                        text = dialogTitle,
                        fontSize = AppTheme.typo.textSize_12.value.toInt(),
                        fontWeight = FontWeight.Normal
                    )

                    Spacer(modifier = Modifier.height(AppTheme.dimens.paddingLarge))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 0.dp, horizontal = AppTheme.dimens.gridItem_2)
                            .border(
                                width = (0.5).dp,
                                color = Color(0xCBE7E9F1),
                                shape = RoundedCornerShape(12.dp)
                            ),
                        shape = RoundedCornerShape(12.dp),
                        backgroundColor = Color(0xFF1C1C1E)
                    ) {

                        Box {

                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 0.dp, horizontal = 0.dp),
                                value = inputText,
                                onValueChange = {
                                    enteredTextInput = it
                                    onInputTextChanged(enteredTextInput)
                                },
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color(0xFF1C1C1E),
                                    cursorColor = Color(0xFF4B67F4),
                                    disabledTextColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Transparent
                                ),
                                visualTransformation = VisualTransformation.None,
                                maxLines = 1,
                                singleLine = true,
                                textStyle = TextStyle(
                                    color = Color(0xFFEBE4E4),
                                    fontSize = AppTheme.typo.textSize_10
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Email,
                                    imeAction = ImeAction.Done
                                ),
                            )

                            if (inputText.isEmpty()) {
                                Box(
                                    modifier = Modifier.align(alignment = Alignment.CenterStart)
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .padding(
                                                start = 18.dp,
                                                top = AppTheme.dimens.gridItem_1,
                                                bottom = AppTheme.dimens.gridItem_1,
                                                end = AppTheme.dimens.gridItem_1
                                            ),
                                        text = if (inputText.isEmpty()) inputHintText else "",
                                        textAlign = TextAlign.Start,
                                        style = TextStyle(
                                            color = Color(0xFF727272).copy(
                                                alpha = 1f
                                            ),
                                            fontSize = AppTheme.typo.textSize_11
                                        )
                                    )
                                }
                            }

                        }
                    }

                    Spacer(modifier = Modifier.height(AppTheme.dimens.gridItem_3))

                    Spacer(
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(color = Color(0xFF594F62))
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(alignment = Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .height(AppTheme.dimens.buttonLarge)
                                .width(0.dp)
                                .weight(1F)
                                .clickable {
                                    onConfirm(enteredTextInput)
                                    enteredTextInput = "" // Reset the input text state.
                                },
                            contentAlignment = Alignment.Center
                        ) {

                            BasicTextLabel(
                                text = stringResource(R.string.core_components_enter_button),
                                textColor = Color(0xFF2196F3),
                                fontSize = AppTheme.typo.textSize_12.value.toInt(),
                                onLabelTapped = {
                                    onConfirm(enteredTextInput)
                                    enteredTextInput = "" // Reset the input text state.
                                }
                            )

                        }

                        Spacer(
                            modifier = Modifier
                                .width(2.dp)
                                .height(AppTheme.dimens.buttonLarge)
                                .background(color = Color(0xFF594F62))
                        )

                        Box(
                            modifier = Modifier
                                .width(0.dp)
                                .weight(1F)
                                .height(AppTheme.dimens.buttonLarge)
                                .clickable {
                                    onDismiss()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            BasicTextLabel(
                                text = stringResource(R.string.core_components_cancel_button),
                                textColor = dismissRed,
                                fontSize = AppTheme.typo.textSize_12.value.toInt(),
                                onLabelTapped = {
                                    onDismiss()
                                }
                            )
                        }
                    }
                }
            }

        }
    } else {
        // Do nothing.
    }
}