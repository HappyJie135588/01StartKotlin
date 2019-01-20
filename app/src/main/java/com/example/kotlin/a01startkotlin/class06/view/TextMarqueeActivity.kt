package com.example.kotlin.a01startkotlin.class06.view

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.Gravity
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_text_marquee.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.singleLine
import org.jetbrains.anko.textColor

class TextMarqueeActivity : AppCompatActivity() {
    private var bPause = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_marquee)
        tv_marquee.text = "快讯：红色预警，超强台风“泰利”即将登陆，请居民关紧门窗、备足粮油，做好防汛救灾准备！"
        tv_marquee.textSize = 17f
        tv_marquee.textColor =Color.BLACK
        tv_marquee.backgroundColor=Color.WHITE
        tv_marquee.gravity = Gravity.LEFT or Gravity.CENTER //左对齐且垂直居中
        tv_marquee.ellipsize = TextUtils.TruncateAt.MARQUEE //从右向左滚动的跑马灯
        tv_marquee.singleLine = true //跑马灯效果务必设置SingleLine
        tv_marquee.setOnClickListener {
            bPause = !bPause
            tv_marquee.isFocusable = if (bPause) false else true
            tv_marquee.isFocusableInTouchMode = if (bPause) false else true
            if (!bPause) {
                tv_marquee.requestFocus() //强制获得焦点，让跑马灯滚起来
            }
        }

    }
}
