package com.dragonforest.colortracktablayout.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dragonforest.colortracktablayout.R
import kotlinx.android.synthetic.main.activity_tab_scroll_mode_demo.*

class TabScrollModeDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("滑动模式tab")
        setContentView(R.layout.activity_tab_scroll_mode_demo)
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
        list.add(
            TabFragment(
                R.layout.fg_tab,
                "第五页",
                resources.getColor(R.color.colorBlue)
            )
        )
        list.add(
            TabFragment(
                R.layout.fg_tab,
                "第六页",
                resources.getColor(R.color.colorGreen)
            )
        )
        list.add(
            TabFragment(
                R.layout.fg_tab,
                "第七页",
                resources.getColor(R.color.colorOrgange)
            )
        )
        list.add(
            TabFragment(
                R.layout.fg_tab,
                "第八页",
                resources.getColor(R.color.colorPink)
            )
        )
        list.add(
            TabFragment(
                R.layout.fg_tab,
                "第九页",
                resources.getColor(R.color.colorBlue)
            )
        )
        list.add(
            TabFragment(
                R.layout.fg_tab,
                "第十页",
                resources.getColor(R.color.colorGreen)
            )
        )
        list.add(
            TabFragment(
                R.layout.fg_tab,
                "第十一页",
                resources.getColor(R.color.colorOrgange)
            )
        )
        list.add(
            TabFragment(
                R.layout.fg_tab,
                "第十二页",
                resources.getColor(R.color.colorPink)
            )
        )
        return list
    }

    private fun getTitles(): MutableList<String> {
        var list: MutableList<String> = mutableListOf()
        list.add("关注")
        list.add("推荐")
        list.add("抗击肺炎")
        list.add("小视频")
        list.add("视频")
        list.add("热点")
        list.add("在家玩")
        list.add("娱乐")
        list.add("在家上课")
        list.add("图片")
        list.add("懂车帝")
        list.add("房产")
        return list
    }


}
