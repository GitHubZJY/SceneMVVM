package com.zjy.baselib.base

import android.app.Activity
import android.view.View

/**
 * <b>Package:</b> SceneMVVM <br>
 * <b>Create Date:</b> 2020/5/8 <br>
 * <b>@author:</b> Yang <br>
 * <b>Description:</b> 抽取UI层级公用接口，方便后期替换库 <br>
 */
interface IUIHierarchy {

    /**
     * 设置布局之前回调
     */
    fun onLayoutBefore()

    /**
     * 获取布局LayoutId
     */
    fun onInflaterViewId(): Int

    /**
     * 查找View和给View进行相关设置等
     */
    fun onBindView(view: View?)

    /**
     * 设置数据
     */
    fun setData()

    /**
     * 获取所属Activity
     */
    fun getFromActivity(): Activity?

    /**
     * 绑定ViewModel相关操作
     */
    fun bindObserver()

    /**
     * 关闭页面
     */
    fun finishPage(isAnim: Boolean)
}