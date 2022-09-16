package com.example.wikiapp

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class HomeFragmentArgs(
  public val userName: String?
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("userName", this.userName)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("userName", this.userName)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): HomeFragmentArgs {
      bundle.setClassLoader(HomeFragmentArgs::class.java.classLoader)
      val __userName : String?
      if (bundle.containsKey("userName")) {
        __userName = bundle.getString("userName")
      } else {
        throw IllegalArgumentException("Required argument \"userName\" is missing and does not have an android:defaultValue")
      }
      return HomeFragmentArgs(__userName)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): HomeFragmentArgs {
      val __userName : String?
      if (savedStateHandle.contains("userName")) {
        __userName = savedStateHandle["userName"]
      } else {
        throw IllegalArgumentException("Required argument \"userName\" is missing and does not have an android:defaultValue")
      }
      return HomeFragmentArgs(__userName)
    }
  }
}
