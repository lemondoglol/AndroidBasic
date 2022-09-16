package com.example.wikiapp.aasplit;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/example/wikiapp/aasplit/AASplitFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/example/handler/AASplitHandler;", "()V", "userInfoList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lcom/example/model/UserInfo;", "getUserInfoList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "onAddPersonClicked", "", "userInfo", "onCalculateClicked", "onClearClicked", "app_debug"})
public final class AASplitFragmentViewModel extends androidx.lifecycle.ViewModel implements com.example.handler.AASplitHandler {
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.snapshots.SnapshotStateList<com.example.model.UserInfo> userInfoList = null;
    
    @javax.inject.Inject()
    public AASplitFragmentViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.compose.runtime.snapshots.SnapshotStateList<com.example.model.UserInfo> getUserInfoList() {
        return null;
    }
    
    @java.lang.Override()
    public void onAddPersonClicked(@org.jetbrains.annotations.NotNull()
    com.example.model.UserInfo userInfo) {
    }
    
    @java.lang.Override()
    public void onCalculateClicked() {
    }
    
    @java.lang.Override()
    public void onClearClicked() {
    }
}