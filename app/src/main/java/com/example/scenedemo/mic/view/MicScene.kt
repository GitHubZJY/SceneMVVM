package com.example.scenedemo.mic.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.scene.ktx.activityViewModels
import com.bytedance.scene.ktx.postDelayed
import com.bytedance.scene.ui.template.AppCompatScene
import com.example.scenedemo.R
import com.example.scenedemo.mic.viewmodel.MicViewModel
import com.example.scenedemo.reward.viewmodel.RewardViewModel

class MicScene : AppCompatScene() {

    private val mMicViewModel: MicViewModel by activityViewModels()

    private var vMicRv: RecyclerView? = null

    override fun onCreateContentView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_mic, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setToolbarVisible(false)
        setStatusBarVisible(false)

        vMicRv = findViewById(R.id.mic_rv)

        mMicViewModel.getMicListData().observe(this, Observer {
            vMicRv?.apply {
                layoutManager = GridLayoutManager(requireSceneContext(), 3)
                adapter = MicAdapter(requireSceneContext(), it)
                adapter?.notifyDataSetChanged()
            }
        })

        postDelayed(Runnable {
            mMicViewModel.loadMiCList()
        }, 2000)
    }

}