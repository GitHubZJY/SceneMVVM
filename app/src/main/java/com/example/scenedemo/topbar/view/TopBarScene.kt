package com.example.scenedemo.topbar.view

import android.view.View
import android.widget.Button
import com.example.scenedemo.R
import com.example.scenedemo.base.BaseScene
import com.example.scenedemo.create.CreateChatScene

class TopBarScene : BaseScene() {

    private var vCreate: Button? = null

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