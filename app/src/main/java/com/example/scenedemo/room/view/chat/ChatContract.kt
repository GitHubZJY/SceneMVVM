package com.example.scenedemo.room.view.chat

import io.reactivex.Observable

interface ChatContract {

    interface IRepository {
        fun reqChatListData(): Observable<MutableList<String>>
    }
}