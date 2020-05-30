package com.example.scenedemo.base

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.bytedance.scene.Scene
import com.bytedance.scene.interfaces.PopOptions
import com.bytedance.scene.interfaces.PushOptions
import com.bytedance.scene.ktx.addAndHide
import com.bytedance.scene.navigation.OnBackPressedListener
import com.bytedance.scene.ui.template.SwipeBackGroupScene
import com.example.scenedemo.R

abstract class BaseScene : SwipeBackGroupScene(), IUIHierarchy, IResourceHelper {

    override fun onCreateSwipeContentView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedInstanceState: Bundle?
    ): ViewGroup {
        return inflater.inflate(onInflaterViewId(), null, false) as ViewGroup
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setSwipeEnabled(true)

        onLayoutBefore()
        onBindView(view)
        bindObserver()
        setData()
        initScene()
    }

    fun addChildScene(containerId: Int, scene: Scene, isHide: Boolean) {
        if (isHide) {
            addAndHide(containerId, scene, scene::class.java.simpleName)
        } else {
            add(containerId, scene, scene::class.java.simpleName)
        }
    }

    override fun getFromActivity(): Activity? {
        return activity
    }

    override fun onLayoutBefore() {}

    override fun setData() {}

    override fun finishPage(isAnim: Boolean) {
        if (isAnim) {
            val popOptions = PopOptions.Builder()
                .setAnimation(
                    requireActivity(),
                    R.anim.base_slide_in_right,
                    R.anim.base_slide_normal
                )
                .build()
            requireNavigationScene().pop(popOptions)
        } else {
            requireNavigationScene().pop()
        }
    }

    override fun getColorResource(resId: Int): Int {
        getFromActivity()?.let {
            return ContextCompat.getColor(it, resId)
        }
        return 0
    }

    override fun getDrawableResource(resId: Int): Drawable? {
        getFromActivity()?.let {
            return ContextCompat.getDrawable(it, resId)
        }
        return null
    }

    override fun getStringResource(resId: Int): String {
        return getString(resId)
    }

    override fun getStringResource(resId: Int, vararg formatArgs: Any): String {
        return getString(resId, formatArgs)
    }

    fun jumpPage(scene: Class<out Scene>) {
        jumpPage(scene, null, true)
    }

    fun jumpPage(scene: Class<out Scene>, bundle: Bundle) {
        jumpPage(scene, bundle, true)
    }

    fun jumpPage(scene: Class<out Scene>, bundle: Bundle?, isAnim: Boolean) {
        val pushOption = PushOptions.Builder()
            .setAnimation(
                requireActivity(),
                R.anim.base_slide_in_right,
                R.anim.base_slide_normal
            )
            .build()
        if (isAnim) {
            requireNavigationScene().push(scene, bundle, pushOption)
        } else {
            requireNavigationScene().push(scene, bundle)
        }
    }

    private fun initScene() {
        navigationScene?.addOnBackPressedListener(this,
            OnBackPressedListener {
                onBackPress()
            })
    }

    protected open fun onBackPress(): Boolean {
        return false
    }

}