package com.example.scenedemo.bottombar.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import com.bytedance.scene.interfaces.PushOptions
import com.bytedance.scene.ktx.activityViewModels
import com.bytedance.scene.ui.template.AppCompatScene
import com.example.scenedemo.R
import com.example.scenedemo.chat.viewmodel.ChatViewModel
import com.example.scenedemo.reward.view.RewardScene
import com.example.scenedemo.reward.viewmodel.RewardViewModel


class BottomBarScene : AppCompatScene() {

    private var vReward: Button? = null
    private var vSend: Button? = null

    private val mRewardViewModel: RewardViewModel by activityViewModels()
    private val mChatViewModel: ChatViewModel by activityViewModels()


    override fun onCreateContentView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_bottom_bar, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setToolbarVisible(false)
        setStatusBarVisible(false)

        vReward = findViewById(R.id.vReward)
        vSend = findViewById(R.id.vSend)
        vReward?.setOnClickListener {
            mRewardViewModel.setShowReward(true)
        }

        vSend?.setOnClickListener {
            mChatViewModel.sendMsg("enene")
        }

        mRewardViewModel.getRewardData().observe(this, Observer {

        })
    }

}