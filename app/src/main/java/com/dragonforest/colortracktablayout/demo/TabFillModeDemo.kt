package com.dragonforest.colortracktablayout.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dragonforest.colortracktablayout.R
import kotlinx.android.synthetic.main.activity_tab_scroll_mode_demo.*

class TabFillModeDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("固定模式tab")
        setContentView(R.layout.activity_tab_fill_mode_demo)
        initView()
    }

    private fun initView() {
        var pagerAdapter =
            TabPagerAdapter(supportFragmentManager)
        pagerAdapter.fgs = getFragments()
        pagerAdapter.titles = getTitles()
        viewpager.adapter = pagerAdapter
        ct_tablayout.setUpWithViewPager(viewpager)
    }

    private fun getFragments(): MutableList<Fragment> {
        var list: MutableList<Fragment> = mutableListOf()
        list.add(
            TabFragment(
                R.layout.fg_tab,
                "第一页",
                resources.getColor(R.color.colorBlue)
            )
        )
        list.add(
            TabFragment(
                R.layout.fg_tab,
                "第二页",
                resources.getColor(R.color.colorGreen)
            )
        )
        list.add(
            TabFragment(
                R.layout.fg_tab,
                "第三页",
                resources.getColor(R.color.colorOrgange)
            )
        )
        list.add(
            TabFragment(
                R.layout.fg_tab,
                "第四页",
                resources.getColor(R.color.colorPink)
            )
        )
        return list
    }

    private fun getTitles(): MutableList<String> {
        var list: MutableList<String> = mutableListOf()
        list.add("首页")
        list.add("推荐")
        list.add("热门")
        list.add("我的")
        return list
    }


}
