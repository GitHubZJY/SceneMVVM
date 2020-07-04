package com.zjy.baselib.base

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.bytedance.scene.NavigationSceneUtility
import com.bytedance.scene.Scene
import com.bytedance.scene.SceneDelegate

abstract class BaseSceneActivity : AppCompatActivity() {
    private var mDelegate: SceneDelegate? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent?.extras
        mDelegate = if (bundle == null) {
            NavigationSceneUtility.setupWithActivity(this, getHomeSceneClass())
                .supportRestore(supportRestore())
                .build()
        } else {
            NavigationSceneUtility.setupWithActivity(this, getHomeSceneClass())
                .rootSceneArguments(bundle)
                .supportRestore(supportRestore())
                .build()
        }
    }

    override fun onBackPressed() {
        if (!mDelegate!!.onBackPressed()) {
            super.onBackPressed()
        }
    }

    protected abstract fun getHomeSceneClass(): Class<out Scene?>

    protected abstract fun supportRestore(): Boolean
}