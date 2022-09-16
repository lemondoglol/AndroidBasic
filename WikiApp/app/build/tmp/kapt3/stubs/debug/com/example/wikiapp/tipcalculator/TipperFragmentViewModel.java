package com.example.wikiapp.tipcalculator;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\rH\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020&H\u0016J\b\u0010\'\u001a\u00020!H\u0002R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R+\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR+\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\f\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\n\u00a8\u0006("}, d2 = {"Lcom/example/wikiapp/tipcalculator/TipperFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/example/tip_calculator/handler/TipCalculatorHandler;", "()V", "<set-?>", "", "eachPersonPay", "getEachPersonPay", "()D", "setEachPersonPay", "(D)V", "eachPersonPay$delegate", "Landroidx/compose/runtime/MutableState;", "", "numberOfPeople", "getNumberOfPeople", "()I", "setNumberOfPeople", "(I)V", "numberOfPeople$delegate", "tipPercentage", "getTipPercentage", "setTipPercentage", "tipPercentage$delegate", "tipTotal", "getTipTotal", "setTipTotal", "tipTotal$delegate", "total", "getTotal", "setTotal", "total$delegate", "onNumberOfPeopleChanged", "", "people", "onTipPercentageChanged", "tip", "onTotalChanged", "", "reCalculate", "app_debug"})
public final class TipperFragmentViewModel extends androidx.lifecycle.ViewModel implements com.example.tip_calculator.handler.TipCalculatorHandler {
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState total$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState numberOfPeople$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState tipPercentage$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState tipTotal$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState eachPersonPay$delegate = null;
    
    @javax.inject.Inject()
    public TipperFragmentViewModel() {
        super();
    }
    
    @java.lang.Override()
    public double getTotal() {
        return 0.0;
    }
    
    @java.lang.Override()
    public void setTotal(double p0) {
    }
    
    @java.lang.Override()
    public int getNumberOfPeople() {
        return 0;
    }
    
    @java.lang.Override()
    public void setNumberOfPeople(int p0) {
    }
    
    @java.lang.Override()
    public int getTipPercentage() {
        return 0;
    }
    
    @java.lang.Override()
    public void setTipPercentage(int p0) {
    }
    
    @java.lang.Override()
    public double getTipTotal() {
        return 0.0;
    }
    
    @java.lang.Override()
    public void setTipTotal(double p0) {
    }
    
    @java.lang.Override()
    public double getEachPersonPay() {
        return 0.0;
    }
    
    @java.lang.Override()
    public void setEachPersonPay(double p0) {
    }
    
    @java.lang.Override()
    public void onTotalChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String total) {
    }
    
    @java.lang.Override()
    public void onTipPercentageChanged(int tip) {
    }
    
    @java.lang.Override()
    public void onNumberOfPeopleChanged(int people) {
    }
    
    private final void reCalculate() {
    }
}