package com.dragonforest.colortracktablayout.demo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *
 * author: DragonForest
 * time: 2020/3/23
 */
class TabPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    var fgs: MutableList<Fragment> = mutableListOf()
    var titles: MutableList<String> = mutableListOf()

    override fun getItem(position: Int): Fragment {
        return fgs.get(position)
    }

    override fun getCount(): Int {
        return fgs.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles.get(position)
    }
}