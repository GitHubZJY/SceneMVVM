package com.example.scenedemo.topbar.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bytedance.scene.ktx.activityViewModels
import com.bytedance.scene.ui.template.AppCompatScene
import com.example.scenedemo.R
import com.example.scenedemo.create.CreateChatScene
import com.example.scenedemo.reward.viewmodel.RewardViewModel

class TopBarScene : AppCompatScene() {

    private var vCreate: Button? = null

    override fun onCreateContentView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_top_bar, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setToolbarVisible(false)
        setStatusBarVisible(true)

        vCreate = findViewById(R.id.vCreate)
        vCreate?.setOnClickListener {
            requireNavigationScene().push(CreateChatScene::class.java)
        }
    }

}