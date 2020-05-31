package com.example.scenedemo.room.view.topbar.view

import android.view.View
import android.widget.ImageView
import com.example.scenedemo.R
import com.example.scenedemo.create.CreateChatScene
import com.example.scenedemo.room.view.BaseRoomScene

class TopBarScene : BaseRoomScene() {

    private var vCreate: ImageView? = null

    override fun onInflaterViewId(): Int {
        return R.layout.layout_top_bar
    }

    override fun onBindView(view: View?) {
        vCreate = findViewById(R.id.vCreate)
        vCreate?.setOnClickListener {
            jumpPage(CreateChatScene::class.java)
        }
    }

    override fun bindObserver() {

    }

}