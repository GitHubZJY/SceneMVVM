package com.example.scenedemo.chat.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.scenedemo.chat.ChatContract
import com.example.scenedemo.chat.model.ChatRepository
import com.example.scenedemo.mic.MicContract
import com.example.scenedemo.mic.model.MicRepository

class ChatViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: ChatContract.IRepository by lazy(LazyThreadSafetyMode.NONE) {
        ChatRepository()
    }

    private val mChatListData: MutableLiveData<MutableList<String>> by lazy(LazyThreadSafetyMode.NONE) {
        MutableLiveData<MutableList<String>>()
    }

    public fun sendMsg(content: String){
        val data = mChatListData.value
        data?.apply {
            add(content)
            setChatListData(this)
        }
    }


    public fun setChatListData(data : MutableList<String> ){
        mChatListData.value = data
    }

    public fun getChatListData() : MutableLiveData<MutableList<String>> {
        return mChatListData
    }


    fun loadChatList(){
        mRepository.reqChatListData().subscribe {
            mChatListData.value = it
        }
    }

}