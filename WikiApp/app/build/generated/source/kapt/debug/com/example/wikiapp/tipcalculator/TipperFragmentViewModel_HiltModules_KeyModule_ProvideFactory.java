// Generated by Dagger (https://dagger.dev).
package com.example.wikiapp.tipcalculator;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class TipperFragmentViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static TipperFragmentViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(TipperFragmentViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final TipperFragmentViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new TipperFragmentViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}