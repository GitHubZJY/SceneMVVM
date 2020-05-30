package com.example.scenedemo.base

import android.graphics.drawable.Drawable
import androidx.annotation.StringRes

/**
 * <b>Package:</b> SceneMVVM <br>
 * <b>Create Date:</b> 2020/5/8 <br>
 * <b>@author:</b> Yang <br>
 * <b>Description:</b> 封装资源获取相关操作 <br>
 */
interface IResourceHelper {

    fun getStringResource(@StringRes resId: Int): String

    fun getStringResource(@StringRes resId: Int , vararg formatArgs: Any): String

    fun getColorResource(resId: Int): Int

    fun getDrawableResource(resId: Int): Drawable?
}