package com.example.kotlin.a01startkotlin.class09

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_runnable.*

class RunnableActivity : AppCompatActivity() {

    private val handler = Handler()
    private var count = 0
    private var isStarted = false
    private val counter: Counter = Counter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runnable)
        btn_runnable.setOnClickListener {
            isStarted = !isStarted
            if (isStarted) {
                btn_runnable.text = "停止计数"
                handler.post(counter1)
            } else {
                btn_runnable.text = "开始计数"
                handler.removeCallbacks(counter1)
            }
        }

        handler.post(Runnable {
            count++
            tv_result.text = "当前计数值为：$count"
        })

        handler.post {
            count++
            tv_result.text = "当前计数值为：$count"
        }

        handler.postDelayed({
            count++
            tv_result.text = "当前计数值为：$count"
        },1000)
    }

    private inner class Counter : Runnable {
        override fun run() {
            count++
            tv_result.text = "当前计数值为：$count"
            handler.postDelayed(this, 1000)
        }

    }
    //使用关键字object占位,表示这是一个匿名内部类
    private val counter1 = object:Runnable{
        override fun run() {
            count++
            tv_result.text = "当前计数值为：$count"
            handler.postDelayed(this, 1000)
        }
    }

    private val counter2 = Runnable {
        count++
        tv_result.text = "当前计数值为：$count"
    }



}
