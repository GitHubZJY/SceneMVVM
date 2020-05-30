package com.example.scenedemo.reward.view

import android.view.View
import androidx.lifecycle.Observer
import com.bytedance.scene.ktx.activityViewModels
import com.example.scenedemo.R
import com.example.scenedemo.base.BaseScene
import com.example.scenedemo.reward.viewmodel.RewardViewModel


class RewardScene : BaseScene() {

    private val mRewardViewModel: RewardViewModel by activityViewModels()

    override fun onInflaterViewId(): Int {
        return R.layout.layout_reward
    }

    override fun onBindView(view: View?) {

    }

    override fun bindObserver() {
        mRewardViewModel.getRewardData().observe(this, Observer {

        })
    }

}