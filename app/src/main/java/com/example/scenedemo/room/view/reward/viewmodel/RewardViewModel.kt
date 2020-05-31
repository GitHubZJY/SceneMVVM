package com.example.scenedemo.room.view.reward.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.scenedemo.room.view.reward.RewardContract
import com.example.scenedemo.room.view.reward.model.RewardBean
import com.example.scenedemo.room.view.reward.model.RewardRepository


class RewardViewModel(application: Application) : AndroidViewModel(application) {

    private val mRewardData: MutableLiveData<RewardBean> by lazy(LazyThreadSafetyMode.NONE) {
        MutableLiveData<RewardBean>()
    }

    private val mRepository: RewardContract.IRepository by lazy(LazyThreadSafetyMode.NONE) {
        RewardRepository()
    }

    public fun getRewardData(): MutableLiveData<RewardBean> {
        return mRewardData
    }

    override fun onCleared() {
        super.onCleared()
    }
}