package com.example.scenedemo.room.view.reward.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.scenedemo.consts.AppConstants.Companion.LOG_TAG
import com.example.scenedemo.room.view.reward.model.RewardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RewardViewModel(application: Application) : AndroidViewModel(application) {

    private val mRewardData: MutableLiveData<MutableList<String>> by lazy(LazyThreadSafetyMode.NONE) {
        MutableLiveData<MutableList<String>>()
    }

    private val mRepository: RewardRepository by lazy(LazyThreadSafetyMode.NONE) {
        RewardRepository()
    }

    fun getRewardData(): MutableLiveData<MutableList<String>> {
        return mRewardData
    }

    fun setRewardData(list: MutableList<String>?) {
        mRewardData.value = list
    }

    fun initRewardData() {
        viewModelScope.launch(Dispatchers.Default) {
            val task = async(Dispatchers.IO) {
                mRepository.reqRewardData()
            }
            Log.d(LOG_TAG, "等待请求")
            val result = task.await()
            withContext(Dispatchers.Main) {
                result.forEachIndexed { index, s ->
                    Log.d(LOG_TAG, "展示结果：$s")
                }
                setRewardData(result)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}