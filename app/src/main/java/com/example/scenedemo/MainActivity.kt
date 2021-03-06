package com.example.scenedemo

import android.os.Bundle
import com.bytedance.scene.Scene
import com.example.scenedemo.room.view.home.HomeScene
import com.zjy.baselib.base.BaseSceneActivity


class MainActivity : BaseSceneActivity() {

    override fun supportRestore(): Boolean {
        return false
    }

    override fun getHomeSceneClass(): Class<out Scene> {
        return HomeScene::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
