package com.example.wikiapp.aasplit

import com.example.handler.AASplitHandler
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.model.UserInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AASplitFragmentViewModel @Inject constructor() : ViewModel(), AASplitHandler {

    override val userInfoList = mutableStateListOf<UserInfo>()

    override fun onAddPersonClicked(userInfo: UserInfo) {
        var total = 0f
        runCatching {
            userInfo.spending.split(",").forEach {
                total += it.toFloat()
            }
        }
        userInfo.totalSpend = total
        userInfoList.add(userInfo)
    }

    override fun onCalculateClicked() {
        var total = 0f
        userInfoList.forEach {
            total += it.totalSpend
        }
        val average = total / userInfoList.size
        userInfoList.map {
            it.copy(balance = (average - it.totalSpend).toString())
        }
    }

    override fun onClearClicked() {
        userInfoList.clear()
    }

}