package com.sweetwater.encore.core_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
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

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 360,
    heightDp = 640
)
@Composable
private fun CustomAlertDialogPreview() {
    KeyboardDialog(
        show = true,
        dialogTitle = "Please enter the product UPC/serial number.",
        inputHintText = "Barcode",
        onDismiss = {},
        onConfirm = {},
    )
}

@Composable
fun KeyboardDialog(
    show: Boolean,
    dialogTitle: String,
    inputHintText: String,
    keyboardType: KeyboardType = KeyboardType.Email,
    onDismiss: () -> Unit,
    onConfirm: (inputTextString: String) -> Unit,
    ) {

    var enteredTextInput by remember {
        mutableStateOf("")
    }

    val focusRequester = remember { FocusRequester() }

    if (show) {

        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }


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
            ) {

                Column(
                    modifier = Modifier
                        .background(Color(0xFFFEF7FF))

                ) {

                    Spacer(modifier = Modifier.height(AppTheme.dimens.gridItem_2))

                    BasicTextLabel(
                        modifier = Modifier.padding(start = 12.dp),
                        text = stringResource(R.string.core_components_manual_entry_label),
                        textColor = Color.Black,
                        fontSize = AppTheme.typo.textSize_18.value.toInt(),
                        fontWeight = FontWeight.Bold,
                        shadow = Shadow.None
                    )

                    Spacer(modifier = Modifier.height(AppTheme.dimens.paddingSmall))

                    BasicTextLabel(
                        modifier = Modifier
                            .padding(start = 12.dp),
                        text = dialogTitle,
                        textAlign = TextAlign.Start,
                        textColor = Color(0xFF757575),
                        fontSize = AppTheme.typo.textSize_12.value.toInt(),
                        fontWeight = FontWeight.Normal,
                        shadow = Shadow.None,
                    )

                        Box {
                            TextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 0.dp, end = 10.dp, top = 0.dp, bottom = 0.dp)
                                    .focusRequester(focusRequester)
                                    .drawBehind {
                                       drawLine(
                                           color = Color(0xFF6750A4),
                                           start = Offset(32f, size.height - 15),
                                           end = Offset(size.width - 10, size.height - 15),
                                           strokeWidth = 2.dp.toPx()
                                       )
                                    },
                                value = enteredTextInput,
                                onValueChange = {
                                    enteredTextInput = it
                                },
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.Transparent,
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
                                    fontSize = AppTheme.typo.textSize_11,
                                    textAlign = TextAlign.Start
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = keyboardType,
                                    imeAction = ImeAction.Done
                                ),

                            )

                            if (enteredTextInput.isEmpty()) {
                                Box(
                                    modifier = Modifier.align(alignment = Alignment.CenterStart)
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .padding(
                                                start = 16.dp,
                                                top = AppTheme.dimens.gridItem_1,
                                                bottom = AppTheme.dimens.gridItem_1,
                                                end = AppTheme.dimens.gridItem_1
                                            ),
                                        text = if (enteredTextInput.isEmpty()) inputHintText else "",
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

                    Row(
                        modifier = Modifier
                            .width(IntrinsicSize.Min)
                            .align(alignment = Alignment.End)
                            .padding(
                                start = 0.dp,
                                top = 0.dp,
                                bottom = 0.dp,
                                end = 20.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .height(AppTheme.dimens.buttonLarge)
                                .width(IntrinsicSize.Min)
                                .weight(0.5F)
                                .clickable(onClick = {
                                    enteredTextInput = ""
                                    onDismiss()
                                }),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            BasicTextLabel(
                                text = stringResource(R.string.core_components_cancel_button),
                                textColor = Color(0xFF6750A4),
                                fontSize = AppTheme.typo.textSize_10.value.toInt(),
                                fontWeight = FontWeight.Bold,
                                shadow = Shadow.None,
                                onLabelTapped = {
                                    enteredTextInput = ""
                                    onDismiss()
                                }
                            )
                        }

                        Box(
                            modifier = Modifier
                                .height(AppTheme.dimens.buttonLarge)
                                .width(IntrinsicSize.Min)
                                .weight(0.5F)
                                .clickable(
                                    onClick = {
                                        onConfirm(enteredTextInput)
                                        enteredTextInput = ""
                                    }
                                ),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            BasicTextLabel(
                                modifier = Modifier.padding(end = 10.dp),
                                text = stringResource(R.string.core_components_ok_button),
                                textColor = Color(0xFF6750A4),
                                fontSize = AppTheme.typo.textSize_10.value.toInt(),
                                fontWeight = FontWeight.Bold,
                                shadow = Shadow.None,
                                onLabelTapped = {
                                    onConfirm(enteredTextInput)
                                    enteredTextInput = ""
                                }
                            )
                        }

                    }
                }
            }

        }
    }
}