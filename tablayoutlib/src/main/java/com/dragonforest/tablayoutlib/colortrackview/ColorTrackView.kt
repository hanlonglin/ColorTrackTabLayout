package com.dragonforest.tablayoutlib.colortrackview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.dragonforest.tablayoutlib.R

/**
 *
 * author: DragonForest
 * time: 2020/3/23
 */
class ColorTrackView : AppCompatTextView {
    var changeColor: Int = Color.RED
    var defaultColor: Int = Color.BLACK
    var progress: Float = 0f
        set(value) {
            var v = value % 2
            if (v > 1)
                v = v - 2
            if (v < -1)
                v = v + 2
            field = v
            invalidate()
        }
        get() {
            return field
        }

    constructor(context: Context) : super(context) {
        defaultColor = currentTextColor
    }

    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        defaultColor = currentTextColor
        val obtainStyledAttributes =
            context.obtainStyledAttributes(attr, R.styleable.ColorTrackView)
        changeColor =
            obtainStyledAttributes.getColor(R.styleable.ColorTrackView_changeColor, Color.RED)
        progress = obtainStyledAttributes.getFloat(R.styleable.ColorTrackView_progress, 0f)
        obtainStyledAttributes.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        if (progress >= 0 && progress <= 1) {
            canvas?.save()
            canvas?.clipRect(0f, 0f, width * progress, height.toFloat())
            setTextColor(changeColor)
            super.onDraw(canvas)
            canvas?.restore()

            canvas?.save()
            canvas?.clipRect(width * progress, 0f, width.toFloat(), height.toFloat())
            setTextColor(defaultColor)
            super.onDraw(canvas)
            canvas?.restore()
        } else if (progress >= -1 && progress <= 0) {
            canvas?.save()
            canvas?.clipRect(0f, 0f, width * (1 + progress), height.toFloat())
            setTextColor(defaultColor)
            super.onDraw(canvas)
            canvas?.restore()

            canvas?.save()
            canvas?.clipRect(width * (1 + progress), 0f, width.toFloat(), height.toFloat())
            setTextColor(changeColor)
            super.onDraw(canvas)
            canvas?.restore()
        }


    }
}