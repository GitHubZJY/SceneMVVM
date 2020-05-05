package com.example.scenedemo.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import com.bytedance.scene.group.GroupScene
import com.bytedance.scene.ktx.activityViewModels
import com.example.scenedemo.R
import com.example.scenedemo.bottombar.view.BottomBarScene
import com.example.scenedemo.chat.view.ChatScene
import com.example.scenedemo.mic.view.MicScene
import com.example.scenedemo.reward.view.RewardScene
import com.example.scenedemo.reward.viewmodel.RewardViewModel
import com.example.scenedemo.topbar.view.TopBarScene

class HomeScene : GroupScene() {

    private var vRoot: View? = null

    private val vRewardScene: RewardScene = RewardScene()
    private val vMicScene: MicScene = MicScene()
    private val vChatScene: ChatScene = ChatScene()
    private val vTopBarScene: TopBarScene = TopBarScene()
    private val vBottomScene: BottomBarScene = BottomBarScene()

    private val mRewardViewModel: RewardViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedInstanceState: Bundle?
    ): ViewGroup {
        return inflater.inflate(R.layout.layout_home, null, false) as ConstraintLayout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vRoot = findViewById(R.id.root_view)

        add(R.id.top_container, vTopBarScene, "TopBar")
        add(R.id.reward_container, vRewardScene, "Reward")
        add(R.id.mic_container, vMicScene, "MicList")
        add(R.id.chat_container, vChatScene, "ChatList")
        add(R.id.bottom_container, vBottomScene, "Bottom")


        hide(vRewardScene)
        vRoot?.setOnClickListener {
            mRewardViewModel.setShowReward(false)
        }

        vRewardScene.view.setOnClickListener {

        }

        mRewardViewModel.getShowReward().observe(this, Observer { isShow ->
            if (isShow) {
                show(vRewardScene, R.anim.base_slide_bottom_up)
            } else {
                hide(vRewardScene, R.anim.base_slide_bottom_down)
            }
        })
    }

}