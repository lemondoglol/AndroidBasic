package com.example.wikiapp.tipcalculator

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class TipperFragmentArgs(
  public val tipPercentage: Int = 15
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("tipPercentage", this.tipPercentage)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("tipPercentage", this.tipPercentage)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): TipperFragmentArgs {
      bundle.setClassLoader(TipperFragmentArgs::class.java.classLoader)
      val __tipPercentage : Int
      if (bundle.containsKey("tipPercentage")) {
        __tipPercentage = bundle.getInt("tipPercentage")
      } else {
        __tipPercentage = 15
      }
      return TipperFragmentArgs(__tipPercentage)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): TipperFragmentArgs {
      val __tipPercentage : Int?
      if (savedStateHandle.contains("tipPercentage")) {
        __tipPercentage = savedStateHandle["tipPercentage"]
        if (__tipPercentage == null) {
          throw IllegalArgumentException("Argument \"tipPercentage\" of type integer does not support null values")
        }
      } else {
        __tipPercentage = 15
      }
      return TipperFragmentArgs(__tipPercentage)
    }
  }
}
