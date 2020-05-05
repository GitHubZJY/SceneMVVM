package com.example.scenedemo.mic

import io.reactivex.Observable

interface MicContract {

    interface IRepository {
        fun reqMicListData(): Observable<List<String>>
    }
}