package com.example.scenedemo.mic.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.scenedemo.mic.MicContract
import com.example.scenedemo.mic.model.MicRepository

class MicViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: MicContract.IRepository by lazy(LazyThreadSafetyMode.NONE) {
        MicRepository()
    }

    private val mMicListData: MutableLiveData<List<String>> by lazy(LazyThreadSafetyMode.NONE) {
        MutableLiveData<List<String>>()
    }


    public fun setMicListData(data : List<String> ){
        mMicListData.value = data
    }

    public fun getMicListData() : MutableLiveData<List<String>> {
        return mMicListData
    }


    fun loadMiCList(){
        mRepository.reqMicListData().subscribe {
            mMicListData.value = it
        }
    }

}