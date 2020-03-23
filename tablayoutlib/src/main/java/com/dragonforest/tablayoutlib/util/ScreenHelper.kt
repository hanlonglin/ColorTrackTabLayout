package com.dragonforest.tablayoutlib.util

import android.content.res.Resources

/**
 *
 * author: DragonForest
 * time: 2020/3/23
 */
object ScreenHelper {
    fun getScreenWidth(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }

    fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }
}