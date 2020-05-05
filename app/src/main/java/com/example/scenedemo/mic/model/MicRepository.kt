package com.example.scenedemo.mic.model

import com.example.scenedemo.mic.MicContract
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import org.reactivestreams.Subscriber




class MicRepository : MicContract.IRepository{
    override fun reqMicListData(): Observable<List<String>> {

        return Observable.create { emitter ->
            val data = ArrayList<String>()
            data.add("Mic1")
            data.add("Mic2")
            data.add("Mic3")
            data.add("Mic4")
            data.add("Mic5")
            data.add("Mic6")
            emitter.onNext(data)
        }

    }
}