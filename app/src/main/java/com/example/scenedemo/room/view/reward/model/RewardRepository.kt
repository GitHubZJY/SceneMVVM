package com.example.scenedemo.room.view.reward.model

import android.os.Looper
import com.example.scenedemo.room.view.reward.RewardContract
import io.reactivex.Observable
import kotlinx.coroutines.delay
import java.util.*
import java.util.logging.Handler

class RewardRepository : RewardContract.IRepository{

    override fun reqRewardData() : Observable<RewardBean>?{
        return null
    }
}