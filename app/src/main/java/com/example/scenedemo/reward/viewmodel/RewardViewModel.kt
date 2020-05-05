package com.example.scenedemo.reward.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.scenedemo.reward.RewardContract
import com.example.scenedemo.reward.model.RewardBean
import com.example.scenedemo.reward.model.RewardRepository


class RewardViewModel(application: Application) : AndroidViewModel(application) {

    private val mRewardData: MutableLiveData<RewardBean> by lazy(LazyThreadSafetyMode.NONE) {
        MutableLiveData<RewardBean>()
    }
    private val mShowReward: MutableLiveData<Boolean> by lazy(LazyThreadSafetyMode.NONE) {
        MutableLiveData<Boolean>()
    }

    private val mRepository: RewardContract.IRepository by lazy(LazyThreadSafetyMode.NONE) {
        RewardRepository()
    }

    public fun getRewardData(): MutableLiveData<RewardBean> {
        return mRewardData
    }

    public fun loadRewardData(){
        val dis = mRepository.reqRewardData()
    }

    public fun setRewardData(rewardBean: RewardBean) {
        mRewardData.value = rewardBean
    }

    public fun setShowReward(isShow: Boolean){
        mShowReward.value = isShow
    }

    public fun getShowReward(): MutableLiveData<Boolean> {
        return mShowReward
    }

    override fun onCleared() {
        super.onCleared()
    }
}