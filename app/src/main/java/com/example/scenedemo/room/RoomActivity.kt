package com.example.scenedemo.room

import com.bytedance.scene.Scene
import com.example.scenedemo.room.view.home.HomeScene
import com.zjy.baselib.base.BaseSceneActivity


class RoomActivity : BaseSceneActivity() {

    override fun supportRestore(): Boolean {
        return false
    }

    override fun getHomeSceneClass(): Class<out Scene> {
        return HomeScene::class.java
    }
}
