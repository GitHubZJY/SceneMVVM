package com.example.scenedemo.base

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle

/**
 * <b>Package:</b> lingjidashi <br>
 * <b>Create Date:</b> 2020/5/8 <br>
 * <b>@author:</b> shengyang <br>
 * <b>Description:</b>  <br>
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application),
    DefaultLifecycleObserver, IResourceHelper {

    private var mApplication: Application = application

    fun bindLifeCycle(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    override fun getStringResource(resId: Int): String {
        return mApplication.resources.getString(resId)
    }

    override fun getStringResource(resId: Int, vararg formatArgs: Any): String {
        return mApplication.resources.getString(resId, formatArgs)
    }

    override fun getColorResource(resId: Int): Int {
        return mApplication.resources.getColor(resId)
    }

    override fun getDrawableResource(resId: Int): Drawable {
        return mApplication.resources.getDrawable(resId)
    }
}