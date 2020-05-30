package com.example.scenedemo.bottombar.view

import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import com.bytedance.scene.ktx.activityViewModels
import com.example.scenedemo.R
import com.example.scenedemo.base.BaseScene
import com.example.scenedemo.chat.viewmodel.ChatViewModel
import com.example.scenedemo.reward.viewmodel.RewardViewModel


class BottomBarScene : BaseScene() {

    private var vReward: Button? = null
    private var vSend: Button? = null

    private val mRewardViewModel: RewardViewModel by activityViewModels()
    private val mChatViewModel: ChatViewModel by activityViewModels()


    override fun onInflaterViewId(): Int {
        return R.layout.layout_bottom_bar
    }

    override fun onBindView(view: View?) {
        vReward = findViewById(R.id.vReward)
        vSend = findViewById(R.id.vSend)
        vReward?.setOnClickListener {
            mRewardViewModel.setShowReward(true)
        }

        vSend?.setOnClickListener {
            mChatViewModel.sendMsg("enene")
        }
    }

    override fun bindObserver() {
        mRewardViewModel.getRewardData().observe(this, Observer {

        })
    }

}