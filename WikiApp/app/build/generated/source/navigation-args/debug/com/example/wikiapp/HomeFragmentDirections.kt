package com.example.wikiapp

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToTipperFragment(
    public val tipPercentage: Int = 15
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_tipperFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("tipPercentage", this.tipPercentage)
        return result
      }
  }

  public companion object {
    public fun actionHomeFragmentToTipperFragment(tipPercentage: Int = 15): NavDirections =
        ActionHomeFragmentToTipperFragment(tipPercentage)

    public fun actionHomeFragmentToAASplitFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_AASplitFragment)

    public fun actionHomeFragmentToClinicianSaverFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_clinicianSaverFragment)

    public fun actionHomeFragmentToColorConverterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_colorConverterFragment)
  }
}
