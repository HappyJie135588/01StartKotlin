package com.example.kotlin.a01startkotlin.class09.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.widget.ProgressBar

class TextProgressBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ProgressBar(context, attrs, defStyleAttr) {
    var progressText = ""
    private var paint: Paint
    private var textColor = Color.WHITE
    private var textSize = 30f

    init {
        paint = Paint()
        paint.color = textColor
        paint.textSize = textSize
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val rect = Rect()
        paint.getTextBounds(progressText, 0, progressText.length, rect)
        val x = width / 2 - rect.centerX()
        val y = height / 2 - rect.centerY()
        canvas.drawText(progressText, x.toFloat(), y.toFloat(), paint)
    }
}