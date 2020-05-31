package com.example.scenedemo.room.view.reward

import com.example.scenedemo.room.view.reward.model.RewardBean
import io.reactivex.Observable

interface RewardContract {

    interface IRepository {
        fun reqRewardData() : Observable<RewardBean>?
    }
}