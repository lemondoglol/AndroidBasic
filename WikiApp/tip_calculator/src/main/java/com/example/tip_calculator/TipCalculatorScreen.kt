package com.example.tip_calculator

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.tip_calculator.handler.TipCalculatorHandler

@Composable
fun TipCalculatorScreen(
    modifier: Modifier = Modifier,
    eventHandler: TipCalculatorHandler
) {
    Column(modifier = modifier) {
        TotalBillSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            total = eventHandler.total,
            onTotalChanged = eventHandler::onTotalChanged
        )

        TipSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            tipPercent = eventHandler.tipPercentage,
            onTipPercentChanged = eventHandler::onTipPercentageChanged
        )

        NumberOfPeopleSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            numberOfPeople = eventHandler.numberOfPeople,
            onNumberOfPeopleChanged = eventHandler::onNumberOfPeopleChanged
        )

        EachPaySection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            tipTotal = eventHandler.tipTotal,
            eachPersonPay = eventHandler.eachPersonPay
        )
    }
}

@Composable
private fun TotalBillSection(
    modifier: Modifier = Modifier,
    total: Double,
    onTotalChanged: (String) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = if (total != 0.0) total.toString() else "",
            onValueChange = {
                onTotalChanged(it)
            },
            label = { Text("Total Bill") },
            placeholder = { Text(text = "Enter your total bill here:") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
private fun TipSection(
    modifier: Modifier = Modifier,
    tipPercent: Int,
    onTipPercentChanged: (Int) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = { onTipPercentChanged(tipPercent - 1) }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_remove_24),
                contentDescription = null
            )
        }

        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = "$tipPercent%",
            onValueChange = {
                onTipPercentChanged(it.toInt())
            },
            label = { Text("Tip %") },
            readOnly = true
        )

        Button(onClick = { onTipPercentChanged(tipPercent + 1) }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_add_24),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun NumberOfPeopleSection(
    modifier: Modifier = Modifier,
    numberOfPeople: Int,
    onNumberOfPeopleChanged: (Int) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = { onNumberOfPeopleChanged(numberOfPeople - 1) }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_remove_24),
                contentDescription = null
            )
        }

        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = numberOfPeople.toString(),
            onValueChange = {
                onNumberOfPeopleChanged(it.toInt())
            },
            label = { Text("Number Of People: ") },
            readOnly = true
        )

        Button(onClick = { onNumberOfPeopleChanged(numberOfPeople + 1) }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_add_24),
                contentDescription = null
            )
        }
    }
}

@Composable
fun EachPaySection(
    modifier: Modifier = Modifier,
    tipTotal: Double,
    eachPersonPay: Double
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Tip $tipTotal")
        Text(text = "Each Person Pay: $eachPersonPay")
    }
}