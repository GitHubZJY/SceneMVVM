package com.example.scenedemo.home

import android.view.View
import androidx.lifecycle.Observer
import com.bytedance.scene.ktx.activityViewModels
import com.example.scenedemo.R
import com.example.scenedemo.base.BaseScene
import com.example.scenedemo.bottombar.view.BottomBarScene
import com.example.scenedemo.chat.view.ChatScene
import com.example.scenedemo.mic.view.MicScene
import com.example.scenedemo.reward.view.RewardScene
import com.example.scenedemo.reward.viewmodel.RewardViewModel
import com.example.scenedemo.topbar.view.TopBarScene

class HomeScene : BaseScene() {

    private var vRoot: View? = null

    private val vRewardScene: RewardScene = RewardScene()
    private val vMicScene: MicScene = MicScene()
    private val vChatScene: ChatScene = ChatScene()
    private val vTopBarScene: TopBarScene = TopBarScene()
    private val vBottomScene: BottomBarScene = BottomBarScene()

    private val mRewardViewModel: RewardViewModel by activityViewModels()

    override fun onInflaterViewId(): Int {
        return R.layout.layout_home
    }

    override fun onBindView(view: View?) {
        vRoot = view?.findViewById(R.id.root_view)

        addChildScene(R.id.top_container, vTopBarScene, false)
        addChildScene(R.id.reward_container, vRewardScene, true)
        addChildScene(R.id.mic_container, vMicScene, false)
        addChildScene(R.id.chat_container, vChatScene, false)
        addChildScene(R.id.bottom_container, vBottomScene, false)

        vRoot?.setOnClickListener {
            mRewardViewModel.setShowReward(false)
        }

        vRewardScene.view.setOnClickListener {

        }
    }

    override fun bindObserver() {
        mRewardViewModel.getShowReward().observe(this, Observer { isShow ->
            if (isShow) {
                show(vRewardScene, R.anim.base_slide_bottom_up)
            } else {
                hide(vRewardScene, R.anim.base_slide_bottom_down)
            }
        })
    }

    override fun onBackPress(): Boolean {
        if (vRewardScene.isVisible) {
            mRewardViewModel.setShowReward(false)
            return true
        }
        return super.onBackPress()
    }

}