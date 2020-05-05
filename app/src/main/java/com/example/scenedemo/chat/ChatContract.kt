package com.example.scenedemo.chat

import io.reactivex.Observable

interface ChatContract {

    interface IRepository {
        fun reqChatListData(): Observable<MutableList<String>>
    }
}