package com.example.wikiapp.color_converter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.color_converter.ColorConverterHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ColorConverterFragmentViewModel @Inject constructor(

) : ColorConverterHandler, ViewModel() {
    private val opacityLst = listOf("00", "0D", "1A", "26", "33", "40", "4D", "59", "66", "73", "80", "8C", "99", "A6", "B3", "BF", "CC", "D9", "E6", "F2", "FF")

    override var blueColorValue by mutableStateOf(0)
    override var redColorValue by mutableStateOf(0)
    override var greenColorValue by mutableStateOf(0)
    override var opacityValue by mutableStateOf(100)

    override fun onRedColorValueChange(redColorValue: String?) {
        when (redColorValue.isNullOrBlank()) {
            true -> this.redColorValue = 0
            false -> {
                kotlin.runCatching {
                    redColorValue.toInt().also {
                        if (it >= 255) {
                            this.redColorValue = 255
                        } else {
                            this.redColorValue = it
                        }
                    }
                }.onFailure {
                    this.redColorValue = 0
                }
            }
        }
    }

    override fun onBlueColorValueChange(blueColorValue: String?) {
        when (blueColorValue.isNullOrBlank()) {
            true -> this.blueColorValue = 0
            false -> {
                kotlin.runCatching {
                    blueColorValue.toInt().also {
                        if (it >= 255) {
                            this.blueColorValue = 255
                        } else {
                            this.blueColorValue = it
                        }
                    }
                }.onFailure {
                    this.blueColorValue = 0
                }
            }
        }
    }

    override fun onGreenColorValueChange(greenColorValue: String?) {
        when (greenColorValue.isNullOrBlank()) {
            true -> this.greenColorValue = 0
            false -> {
                kotlin.runCatching {
                    greenColorValue.toInt().also {
                        if (it >= 255) {
                            this.greenColorValue = 255
                        } else {
                            this.greenColorValue = it
                        }
                    }
                }.onFailure {
                    this.greenColorValue = 0
                }
            }
        }
    }

    override fun onOpacityValueChange(opacityValue: String?) {
        opacityValue?.let {
            if (it.isNotBlank()) {
                this.opacityValue = it.toInt()
            }
        }
    }

    override fun convertRGBToHex(): String {
        return String.format(
            "#%s%02x%02x%02x",
            opacityLst[opacityValue / 5],
            redColorValue,
            greenColorValue,
            blueColorValue
        )
    }

}