package com.example.scenedemo.room.view.reward.view

import android.view.View
import androidx.lifecycle.Observer
import com.example.scenedemo.R
import com.example.scenedemo.room.view.BaseRoomScene


class RewardScene : BaseRoomScene() {

    override fun onInflaterViewId(): Int {
        return R.layout.layout_reward
    }

    override fun onBindView(view: View?) {

    }

    override fun setData() {
        mRewardViewModel.initRewardData()
    }

    override fun bindObserver() {
        mRewardViewModel.getRewardData().observe(this, Observer {

        })
    }

}