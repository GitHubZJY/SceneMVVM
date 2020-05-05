package com.example.scenedemo.reward

import com.example.scenedemo.reward.model.RewardBean
import io.reactivex.Observable

interface RewardContract {

    interface IRepository {
        fun reqRewardData() : Observable<RewardBean>?
    }
}