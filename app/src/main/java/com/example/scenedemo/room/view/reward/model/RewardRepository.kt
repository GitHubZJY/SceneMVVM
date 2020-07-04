package com.example.scenedemo.room.view.reward.model

import android.util.Log
import com.example.scenedemo.consts.AppConstants
import kotlinx.coroutines.delay

class RewardRepository {

    suspend fun reqRewardData(): MutableList<String> {
        Log.d(AppConstants.LOG_TAG, "开始请求礼物数据")
        delay(2000)
        Log.d(AppConstants.LOG_TAG, "结束请求礼物数据")
        val list = mutableListOf<String>()
        list.add("飞机")
        list.add("火箭")
        list.add("万花筒")
        list.add("小红花")
        return list
    }
}