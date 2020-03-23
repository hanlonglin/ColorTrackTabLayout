package com.dragonforest.tablayoutlib.tablayout

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.viewpager.widget.ViewPager
import com.dragonforest.tablayoutlib.R
import com.dragonforest.tablayoutlib.colortrackview.ColorTrackView
import com.dragonforest.tablayoutlib.util.DimenHelper
import com.dragonforest.tablayoutlib.util.ScreenHelper
import kotlinx.android.synthetic.main.layout_colortrack_tablayout.view.*
import java.lang.Exception

/**
 *
 * author: DragonForest
 * time: 2020/3/23
 */
class ColorTrackTabLayout : LinearLayout {
    var tabTextColor: Int = Color.GRAY
    var tabSelectTextColor: Int = Color.RED
    var tabTextSize: Float = 18f
    var tabPadding: Float = 30f
    var tabForeground: Int = R.drawable.ripper_colortrackitem
    var tabMode: Int = 0
    var startScrollX = 200f
    var tabSelectScale = 1.1f

    var tabCount = 1

    var itemViews: MutableList<ColorTrackView> = mutableListOf()

    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        val obtainStyledAttributes =
            context.obtainStyledAttributes(attr, R.styleable.ColorTrackTabLayout)
        tabSelectTextColor = obtainStyledAttributes.getColor(
            R.styleable.ColorTrackTabLayout_tabSelectTextColor,
            Color.RED
        )
        tabTextColor = obtainStyledAttributes.getColor(
            R.styleable.ColorTrackTabLayout_tabTextColor,
            Color.GRAY
        )
        tabTextSize =
            obtainStyledAttributes.getDimension(R.styleable.ColorTrackTabLayout_tabTextSize, 18f)
        tabSelectScale =
            obtainStyledAttributes.getFloat(R.styleable.ColorTrackTabLayout_tabSelectScale, 1.1f)
        startScrollX =
            obtainStyledAttributes.getDimension(R.styleable.ColorTrackTabLayout_startScrollX, 200f)
        tabMode =
            obtainStyledAttributes.getInt(R.styleable.ColorTrackTabLayout_tabMode, 0)
        tabPadding =
            obtainStyledAttributes.getDimension(R.styleable.ColorTrackTabLayout_tabPadding, 30f)
        tabForeground = obtainStyledAttributes.getResourceId(
            R.styleable.ColorTrackTabLayout_tabForeground,
            R.drawable.ripper_colortrackitem
        )
        obtainStyledAttributes.recycle()

        View.inflate(context, R.layout.layout_colortrack_tablayout, this)
    }

    fun setUpWithViewPager(vp: ViewPager) {
        itemViews.clear()
        ll_tab_content.removeAllViews()
        // 添加tabItem
        tabCount = vp.adapter!!.count
        if (tabCount == 0) {
            throw Exception("ViewPager has not set data,please set data first!!")
        }
        for (pos in 0 until tabCount) {
            addTrackView(vp.adapter!!.getPageTitle(pos))
        }
        // 设置监听
        for (pos in 0 until itemViews.size) {
            var itemView = itemViews.get(pos)
            itemView.setOnClickListener {
                vp.setCurrentItem(pos)
            }
        }

        vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val curTabItem = itemViews.get(position)
                curTabItem.progress = positionOffset + 1
                curTabItem.scaleX = tabSelectScale - (tabSelectScale - 1) * positionOffset
                curTabItem.scaleY = tabSelectScale - (tabSelectScale - 1) * positionOffset
                if ((position + 1) < itemViews.size) {
                    var nextTabItem = itemViews.get(position + 1)
                    nextTabItem.progress = positionOffset
                    nextTabItem.scaleX = 1 + (tabSelectScale - 1) * positionOffset
                    nextTabItem.scaleY = 1 + (tabSelectScale - 1) * positionOffset
                }

                if (tabMode == 0) {
                    var leftOffsets = getLeftOffsets(position)
                    if (leftOffsets > startScrollX) {
                        var itemWidth =
                            itemViews[position].width
                        var diffx = leftOffsets - itemWidth - startScrollX.toInt()
                        scrollView_tab.scrollTo(diffx + (itemWidth * positionOffset).toInt(), 0)
                    }
                }
            }

            override fun onPageSelected(position: Int) {
                for (index in 0 until itemViews.size) {
                    if (index == position) continue
                    itemViews[index].progress = 0f
                }
            }

        })

    }

    private fun getLeftOffsets(position: Int): Int {
        var leftOffsets: Int = 0
        for (i in 0..position) {
            leftOffsets += itemViews[i].width
        }
        return leftOffsets
    }

    private fun addTrackView(pageTitle: CharSequence?) {
        var tabItemView = ColorTrackView(context)
        tabItemView.changeColor = tabSelectTextColor
        tabItemView.defaultColor = tabTextColor
        tabItemView.setTextSize(DimenHelper.px2dp(tabTextSize))
        tabItemView.typeface = Typeface.MONOSPACE
        tabItemView.text = pageTitle
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            tabItemView.foreground = AppCompatResources.getDrawable(context, tabForeground)
        }
        tabItemView.gravity = Gravity.CENTER
        tabItemView.setPadding(
            tabItemView.paddingLeft,
            DimenHelper.dp2px(7f).toInt(),
            tabItemView.paddingRight,
            DimenHelper.dp2px(7f).toInt()
        )

        // fill模式，所有tab平均铺满屏幕
        if (tabMode == 1) {
            var tabWidth = ScreenHelper.getScreenWidth() / tabCount
            var lp: LinearLayout.LayoutParams =
                LayoutParams(tabWidth, LayoutParams.WRAP_CONTENT)
            tabItemView.layoutParams = lp
        }

        // scroll模式，所有tab自由占据
        if (tabMode == 0) {
            var lp: LinearLayout.LayoutParams =
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            tabItemView.layoutParams = lp
            tabItemView.setPadding(
                tabPadding.toInt(),
                tabItemView.paddingTop,
                tabPadding.toInt(),
                tabItemView.paddingBottom
            )
        }

        ll_tab_content.addView(tabItemView)
        itemViews.add(tabItemView)
    }
}