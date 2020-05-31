package com.example.scenedemo.room.view.home

import android.view.View
import androidx.lifecycle.Observer
import com.example.scenedemo.R
import com.example.scenedemo.room.view.BaseRoomScene
import com.example.scenedemo.room.view.bottombar.view.BottomBarScene
import com.example.scenedemo.room.view.chat.view.ChatScene
import com.example.scenedemo.room.view.mic.view.MicScene
import com.example.scenedemo.room.view.reward.view.RewardScene
import com.example.scenedemo.room.view.topbar.view.TopBarScene

class HomeScene : BaseRoomScene() {

    private val vRewardScene: RewardScene = RewardScene()
    private val vMicScene: MicScene = MicScene()
    private val vChatScene: ChatScene = ChatScene()
    private val vTopBarScene: TopBarScene = TopBarScene()
    private val vBottomScene: BottomBarScene = BottomBarScene()

    override fun onInflaterViewId(): Int {
        return R.layout.layout_home
    }

    override fun onBindView(view: View?) {
        addChildScene(R.id.top_container, vTopBarScene, false)
        addChildScene(R.id.reward_container, vRewardScene, true)
        addChildScene(R.id.mic_container, vMicScene, false)
        addChildScene(R.id.chat_container, vChatScene, false)
        addChildScene(R.id.bottom_container, vBottomScene, false)

        view?.setOnClickListener {
            mUIStateViewModel.setSoftKeyBoardState(false)
            mUIStateViewModel.setShowRewardPanel(false)
            mUIStateViewModel.setShowEmojiPanel(false)
        }
    }

    override fun bindObserver() {
        mUIStateViewModel.getShowRewardPanel().observe(this, Observer { show ->
            if (show) {
                show(vRewardScene)
            } else {
                hide(vRewardScene)
            }
        })
    }

    override fun onBackPress(): Boolean {
        if (vRewardScene.isVisible) {
            mUIStateViewModel.setShowRewardPanel(false)
            return true
        }
        return super.onBackPress()
    }

}