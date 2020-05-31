package com.example.scenedemo.room.view.mic.view

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.scene.ktx.postDelayed
import com.example.scenedemo.R
import com.example.scenedemo.room.view.BaseRoomScene

class MicScene : BaseRoomScene() {


    private var vMicRv: RecyclerView? = null


    override fun onInflaterViewId(): Int {
        return R.layout.layout_mic
    }

    override fun onBindView(view: View?) {
        vMicRv = findViewById(R.id.mic_rv)
    }

    override fun bindObserver() {
        mMicViewModel.getMicListData().observe(this, Observer {
            vMicRv?.apply {
                layoutManager = GridLayoutManager(requireSceneContext(), 3)
                adapter = MicAdapter(
                    requireSceneContext(),
                    it
                )
                adapter?.notifyDataSetChanged()
            }
        })
    }

    override fun setData() {
        postDelayed(Runnable {
            mMicViewModel.loadMiCList()
        }, 2000)
    }


}