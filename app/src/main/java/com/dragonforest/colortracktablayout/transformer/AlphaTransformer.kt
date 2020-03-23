package com.dragonforest.colortracktablayout.transformer

import android.view.View
import androidx.viewpager.widget.ViewPager

/**
 *
 * author: DragonForest
 * time: 2020/3/23
 */
class AlphaTransformer : ViewPager.PageTransformer {
    var pageTransformer: ViewPager.PageTransformer? = null

    constructor() {
    }

    constructor(pageTransformer: ViewPager.PageTransformer) {
        this.pageTransformer = pageTransformer
    }

    override fun transformPage(page: View, position: Float) {
        pageTransformer?.transformPage(page, position)
        if (position >= 0 && position <= 1) {
            page.alpha = 1 - position
        } else if (position >= -1 && position <= 0) {
            page.alpha = 1 + position
        }
    }
}