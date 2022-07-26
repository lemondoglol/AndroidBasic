package com.example.color_converter

interface ColorConverterHandler {
    var redColorValue: Int
    var greenColorValue: Int
    var blueColorValue: Int
    var opacityValue: Int

    fun onRedColorValueChange(redColorValue: String?)
    fun onBlueColorValueChange(blueColorValue: String?)
    fun onGreenColorValueChange(greenColorValue: String?)
    fun onOpacityValueChange(opacityValue: String?)
    fun convertRGBToHex(): String
}