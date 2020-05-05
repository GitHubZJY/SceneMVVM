package com.example.scenedemo.reward.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bytedance.scene.ktx.activityViewModels
import com.bytedance.scene.ui.template.AppCompatScene
import com.example.scenedemo.R
import com.example.scenedemo.reward.viewmodel.RewardViewModel


class RewardScene : AppCompatScene() {

    private val mRewardViewModel: RewardViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateContentView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_reward, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setToolbarVisible(false)
        setStatusBarVisible(false)

        mRewardViewModel.getRewardData().observe(this, Observer {

        })
    }

}