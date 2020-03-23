package com.dragonforest.tablayoutlib.util

import android.content.res.Resources

/**
 *
 * author: DragonForest
 * time: 2020/3/23
 */
object DimenHelper {
    fun dp2px(dp: Float): Float {
        return Resources.getSystem().displayMetrics.density * dp
    }

    fun px2dp(px: Float): Float {
        return px / Resources.getSystem().displayMetrics.density
    }
}