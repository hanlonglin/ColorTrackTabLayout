package com.dragonforest.colortracktablayout.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fg_tab.*

/**
 *
 * author: DragonForest
 * time: 2020/3/23
 */
class TabFragment(var layoutid: Int, var msg: String,var bgColor:Int) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(layoutid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_msg.text = msg
        ll_fg_content.setBackgroundColor(bgColor)
    }
}