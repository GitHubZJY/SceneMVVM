package com.example.scenedemo.room.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.scenedemo.room.view.bottombar.enums.FooterStates
import com.zjy.baselib.base.BaseViewModel

class RoomUIStateViewModel(application: Application) : BaseViewModel(application){

    private val mRewardPanelState: MutableLiveData<Boolean> = MutableLiveData()

    private val mEmojiPanelState: MutableLiveData<Boolean> = MutableLiveData()

    private val mSoftKeyBoardState: MutableLiveData<Boolean> = MutableLiveData()

    private val mFooterShowState: MutableLiveData<FooterStates> = MutableLiveData()


    fun setShowRewardPanel(isShow: Boolean) {
        mRewardPanelState.value = isShow
    }

    fun getShowRewardPanel(): MutableLiveData<Boolean> {
        return mRewardPanelState
    }

    fun setShowEmojiPanel(isShow: Boolean) {
        mEmojiPanelState.value = isShow
    }

    fun getShowEmojiPanel(): MutableLiveData<Boolean> {
        return mEmojiPanelState
    }

    fun setSoftKeyBoardState(isShow: Boolean) {
        mSoftKeyBoardState.value = isShow
    }

    fun getSoftKeyBoardState(): MutableLiveData<Boolean> {
        return mSoftKeyBoardState
    }

    fun setFooterState(state: FooterStates) {
        mFooterShowState.value = state
    }

    fun getFooterState(): MutableLiveData<FooterStates> {
        return mFooterShowState
    }

}