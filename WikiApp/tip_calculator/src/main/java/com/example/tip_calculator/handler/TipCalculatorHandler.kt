package com.example.tip_calculator.handler

interface TipCalculatorHandler {
    var total: Double
    var numberOfPeople: Int
    var tipPercentage: Int
    var tipTotal: Double
    var eachPersonPay: Double

    fun onTotalChanged(total: String)
    fun onTipPercentageChanged(tip: Int)
    fun onNumberOfPeopleChanged(people: Int)
}
