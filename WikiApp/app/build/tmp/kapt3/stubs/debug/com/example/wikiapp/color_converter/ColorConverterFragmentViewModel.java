package com.example.wikiapp.color_converter;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010\r\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010 \u001a\u00020\u001e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0016R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR+\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\n\u00a8\u0006\""}, d2 = {"Lcom/example/wikiapp/color_converter/ColorConverterFragmentViewModel;", "Lcom/example/color_converter/ColorConverterHandler;", "Landroidx/lifecycle/ViewModel;", "()V", "<set-?>", "", "blueColorValue", "getBlueColorValue", "()I", "setBlueColorValue", "(I)V", "blueColorValue$delegate", "Landroidx/compose/runtime/MutableState;", "greenColorValue", "getGreenColorValue", "setGreenColorValue", "greenColorValue$delegate", "opacityLst", "", "", "opacityValue", "getOpacityValue", "setOpacityValue", "opacityValue$delegate", "redColorValue", "getRedColorValue", "setRedColorValue", "redColorValue$delegate", "convertRGBToHex", "onBlueColorValueChange", "", "onGreenColorValueChange", "onOpacityValueChange", "onRedColorValueChange", "app_debug"})
public final class ColorConverterFragmentViewModel extends androidx.lifecycle.ViewModel implements com.example.color_converter.ColorConverterHandler {
    private final java.util.List<java.lang.String> opacityLst = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState blueColorValue$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState redColorValue$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState greenColorValue$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState opacityValue$delegate = null;
    
    @javax.inject.Inject()
    public ColorConverterFragmentViewModel() {
        super();
    }
    
    @java.lang.Override()
    public int getBlueColorValue() {
        return 0;
    }
    
    @java.lang.Override()
    public void setBlueColorValue(int p0) {
    }
    
    @java.lang.Override()
    public int getRedColorValue() {
        return 0;
    }
    
    @java.lang.Override()
    public void setRedColorValue(int p0) {
    }
    
    @java.lang.Override()
    public int getGreenColorValue() {
        return 0;
    }
    
    @java.lang.Override()
    public void setGreenColorValue(int p0) {
    }
    
    @java.lang.Override()
    public int getOpacityValue() {
        return 0;
    }
    
    @java.lang.Override()
    public void setOpacityValue(int p0) {
    }
    
    @java.lang.Override()
    public void onRedColorValueChange(@org.jetbrains.annotations.Nullable()
    java.lang.String redColorValue) {
    }
    
    @java.lang.Override()
    public void onBlueColorValueChange(@org.jetbrains.annotations.Nullable()
    java.lang.String blueColorValue) {
    }
    
    @java.lang.Override()
    public void onGreenColorValueChange(@org.jetbrains.annotations.Nullable()
    java.lang.String greenColorValue) {
    }
    
    @java.lang.Override()
    public void onOpacityValueChange(@org.jetbrains.annotations.Nullable()
    java.lang.String opacityValue) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String convertRGBToHex() {
        return null;
    }
}