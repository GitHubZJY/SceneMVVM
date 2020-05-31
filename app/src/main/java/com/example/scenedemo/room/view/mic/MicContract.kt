package com.example.scenedemo.room.view.mic

import io.reactivex.Observable

interface MicContract {

    interface IRepository {
        fun reqMicListData(): Observable<List<String>>
    }
}