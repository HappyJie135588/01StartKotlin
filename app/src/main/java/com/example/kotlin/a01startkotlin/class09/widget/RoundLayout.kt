package com.example.kotlin.a01startkotlin.class09.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.LinearLayout

class RoundLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {
    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        val paint = Paint()
        paint.color = Color.BLUE
        paint.strokeWidth = 2f
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        val rectF = RectF(1f, 1f, (this.width - 1).toFloat(), (this.height - 1).toFloat())
        canvas.drawRoundRect(rectF, 10f, 10f, paint)
    }
}