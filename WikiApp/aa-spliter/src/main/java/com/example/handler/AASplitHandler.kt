package com.example.handler
import com.example.model.UserInfo

interface AASplitHandler {
    val userInfoList: List<UserInfo>
    fun onAddPersonClicked(userInfo: UserInfo)
    fun onCalculateClicked()
    fun onClearClicked()
}