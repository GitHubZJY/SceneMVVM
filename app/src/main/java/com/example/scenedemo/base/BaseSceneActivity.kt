package com.example.scenedemo.base

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.bytedance.scene.NavigationSceneUtility
import com.bytedance.scene.Scene
import com.bytedance.scene.SceneDelegate

abstract class BaseSceneActivity : AppCompatActivity() {
    private var mDelegate: SceneDelegate? = null
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = (window.decorView.systemUiVisibility
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        }
        mDelegate = NavigationSceneUtility.setupWithActivity(this, getHomeSceneClass())
            .supportRestore(supportRestore()).build()
    }

    override fun onBackPressed() {
        if (!mDelegate!!.onBackPressed()) {
            super.onBackPressed()
        }
    }

    protected abstract fun getHomeSceneClass(): Class<out Scene?>

    protected abstract fun supportRestore(): Boolean
}