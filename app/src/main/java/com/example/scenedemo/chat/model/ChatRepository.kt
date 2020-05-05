package com.example.scenedemo.chat.model

import com.example.scenedemo.chat.ChatContract
import com.example.scenedemo.mic.MicContract
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import org.reactivestreams.Subscriber




class ChatRepository : ChatContract.IRepository{
    override fun reqChatListData(): Observable<MutableList<String>> {

        return Observable.create { emitter ->
            val data = ArrayList<String>()
            data.add("HAHAHAHA")
            data.add("SA")
            data.add("123123123123123")
            data.add("21")
            data.add("SLL")
            data.add("A")
            emitter.onNext(data)
        }

    }
}