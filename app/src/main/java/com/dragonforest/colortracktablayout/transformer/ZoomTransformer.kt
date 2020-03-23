package com.dragonforest.colortracktablayout.transformer

import android.view.View
import androidx.viewpager.widget.ViewPager

/**
 *
 * author: DragonForest
 * time: 2020/3/23
 */
class ZoomTransformer : ViewPager.PageTransformer {
    var pageTransformer: ViewPager.PageTransformer? = null

    constructor() {
    }

    constructor(pageTransformer: ViewPager.PageTransformer) {
        this.pageTransformer = pageTransformer
    }

    override fun transformPage(page: View, position: Float) {
        pageTransformer?.transformPage(page, position)
        if (position >= 0 && position <= 1) {
            page.scaleX = 1 - 0.3f * position
            page.scaleY = 1 - 0.3f * position
        } else if (position >= -1 && position <= 0) {
            page.scaleX = 1 + 0.3f * position
            page.scaleY = 1 + 0.3f * position
        }
    }
}