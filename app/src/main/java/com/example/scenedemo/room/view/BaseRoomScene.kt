package com.example.scenedemo.room.view

import com.bytedance.scene.ktx.activityViewModels
import com.example.scenedemo.base.BaseScene
import com.example.scenedemo.room.view.chat.viewmodel.ChatViewModel
import com.example.scenedemo.room.view.mic.viewmodel.MicViewModel
import com.example.scenedemo.room.view.reward.viewmodel.RewardViewModel
import com.example.scenedemo.room.viewmodel.RoomUIStateViewModel

abstract class BaseRoomScene : BaseScene() {

    protected val mUIStateViewModel: RoomUIStateViewModel by activityViewModels()
    protected val mRewardViewModel: RewardViewModel by activityViewModels()
    protected val mChatViewModel: ChatViewModel by activityViewModels()
    protected val mMicViewModel: MicViewModel by activityViewModels()


}