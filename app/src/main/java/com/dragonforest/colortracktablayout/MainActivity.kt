package com.dragonforest.colortracktablayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dragonforest.colortracktablayout.demo.ColorTrackViewDemo
import com.dragonforest.colortracktablayout.demo.TabFillModeDemo
import com.dragonforest.colortracktablayout.demo.TabScrollModeDemo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("仿今日头条demo")
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btn_demo1.setOnClickListener(this)
        btn_demo2.setOnClickListener(this)
        btn_demo3.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_demo1 -> {
                startActivity(
                    Intent(
                        this,
                        ColorTrackViewDemo::class.java
                    )
                )
            }
            R.id.btn_demo2 -> {
                startActivity(
                    Intent(
                        this,
                        TabScrollModeDemo::class.java
                    )
                )
            }
            R.id.btn_demo3 -> {
                startActivity(
                    Intent(
                        this,
                        TabFillModeDemo::class.java
                    )
                )
            }
        }
    }
}
