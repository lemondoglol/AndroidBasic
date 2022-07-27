package com.example.color_converter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class, androidx.compose.ui.ExperimentalComposeUiApi::class)
@Composable
fun ColorConverterScreen(
    modifier: Modifier = Modifier,
    handler: ColorConverterHandler,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ColorPickSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            handler = handler
        )
        EditableExposedDropdownMenuSample(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onValueChanged = handler::onOpacityValueChange,
            selectedOptionText = handler.opacityValue.toString(),
            optionList = (0..20).map { (it * 5).toString() }
        )
        Text(text = handler.convertRGBToHex())
    }

}

@Composable
fun ColorPickSection(
    modifier: Modifier = Modifier,
    handler: ColorConverterHandler,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ColorPickSection(
            colorValue = handler.redColorValue,
            onColorValueChanged = handler::onRedColorValueChange,
            labelText = stringResource(id = R.string.red_color_place_holder),
            placeHolderText = stringResource(id = R.string.red_color_place_holder_hint)
        )
        ColorPickSection(
            colorValue = handler.greenColorValue,
            onColorValueChanged = handler::onGreenColorValueChange,
            labelText = stringResource(id = R.string.green_color_place_holder),
            placeHolderText = stringResource(id = R.string.green_color_place_holder_hint)
        )
        ColorPickSection(
            colorValue = handler.blueColorValue,
            onColorValueChanged = handler::onBlueColorValueChange,
            labelText = stringResource(id = R.string.blue_color_place_holder),
            placeHolderText = stringResource(id = R.string.blue_color_place_holder_hint)
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun ColorPickSection(
    modifier: Modifier = Modifier,
    colorValue: Int,
    onColorValueChanged: (String?) -> Unit,
    labelText: String,
    placeHolderText: String,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val keyboardController = LocalSoftwareKeyboardController.current

        OutlinedTextField(
            value = colorValue.toString(),
            onValueChange = {
                onColorValueChanged(it)
            },
            label = { Text(labelText) },
            placeholder = { Text(text = placeHolderText) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { keyboardController?.hide() }
            )
        )
    }
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun EditableExposedDropdownMenuSample(
    modifier: Modifier = Modifier,
    selectedOptionText: String,
    onValueChanged: (String) -> Unit,
    optionList: List<String>,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var expanded by remember { mutableStateOf(false) }
        ExposedDropdownMenuBox(
            modifier = Modifier.clickable { expanded = true },
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = selectedOptionText,
                readOnly = true,
                onValueChange = { onValueChanged(it) },
                label = { Text(stringResource(R.string.opacity)) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                optionList.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            onValueChanged(selectionOption)
                            expanded = false
                        }
                    ) {
                        Text(text = selectionOption)
                    }
                }
            }
        }
    }
}
