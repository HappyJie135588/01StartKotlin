package com.example.kotlin.a01startkotlin.class07.materialdesign

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_collapse_pin.*

class CollapsePinActivity : AppCompatActivity() {
    private val years = arrayOf("鼠年", "牛年", "虎年", "兔年", "龙年", "蛇年", "马年", "羊年", "猴年", "鸡年", "狗年", "猪年")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapse_pin)
        setSupportActionBar(tl_title)
        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.adapter = RecyclerCollapseAdapter(this, years)
    }
}
