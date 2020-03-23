package com.dragonforest.colortracktablayout.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.dragonforest.colortracktablayout.R
import com.dragonforest.tablayoutlib.colortrackview.ColorTrackView
import kotlinx.android.synthetic.main.activity_color_track_view_demo.*

class ColorTrackViewDemo : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("渐变文字")
        setContentView(R.layout.activity_color_track_view_demo)
        seekbar.max = 200
        seekbar.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(view: SeekBar?, progress: Int, p2: Boolean) {
        tv_progress.text = "$progress%"
        findViewById<ColorTrackView>(R.id.ctv_text).progress = progress.toFloat() / 100
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }
}
