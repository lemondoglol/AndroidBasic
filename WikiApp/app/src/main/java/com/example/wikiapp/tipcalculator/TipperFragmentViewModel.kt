package com.example.wikiapp.tipcalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.tip_calculator.handler.TipCalculatorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TipperFragmentViewModel @Inject constructor(

) : ViewModel(), TipCalculatorHandler {

    override var total by mutableStateOf(0.0)

    override var numberOfPeople by mutableStateOf(1)

    override var tipPercentage by mutableStateOf(15)

    override var tipTotal by mutableStateOf(0.0)

    override var eachPersonPay by mutableStateOf(0.0)


    override fun onTotalChanged(total: String) {
        if (total.trim().isNotBlank()) {
            this.total = total.trim().toDouble()
            reCalculate()
        }
    }

    override fun onTipPercentageChanged(tip: Int) {
        tipPercentage = tip
        reCalculate()
    }

    override fun onNumberOfPeopleChanged(people: Int) {
        numberOfPeople = people
        reCalculate()
    }

    private fun reCalculate() {
        if (total != 0.0) {
            tipTotal = total * tipPercentage / 100
            eachPersonPay = (total + tipTotal) / numberOfPeople
        }
    }
}