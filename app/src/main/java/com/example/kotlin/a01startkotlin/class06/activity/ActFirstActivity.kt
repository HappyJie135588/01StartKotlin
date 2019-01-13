package com.example.kotlin.a01startkotlin.class06.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.util.DateUtil
import kotlinx.android.synthetic.main.activity_act_first.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask
import org.jetbrains.anko.startActivity

class ActFirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_first)

        btn_act_normal_no_param.setOnClickListener {
            //var intent = Intent(this@ActFirstActivity, LinearLayoutActivity::class.java)
            //startActivity(intent)
        }

        btn_act_request.setOnClickListener {

            //第一种写法，参数名和参数值使用关键字to隔开
            //startActivity<ActSecondActivity>(
            //        "request_time" to DateUtil.nowTime,
            //        "request_content" to et_request.text.toString())

            //第二种写法，利用Pair把参数名和参数值进行配对
            startActivity<ActSecondActivity>(
                    Pair("request_time", DateUtil.nowTime),
                    Pair("request_content", et_request.text.toString())
            )

        }

        btn_act_flag.setOnClickListener {
            val intent = intentFor<ActSecondActivity>(
                    "request_time" to DateUtil.nowTime,
                    "request_content" to et_request.text.toString()
            )
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            //startActivity(intent)

            startActivity(intent.newTask()) //对应启动标志FLAG_ACTIVITY_NEW_TASK
            //.singleTop() //对应启动标志FLAG_ACTIVITY_SINGLE_TOP
            //.clearTop() //对应启动标志FLAG_ACTIVITY_CLEAR_TOP
            //.noHistory() //对应启动标志FLAG_ACTIVITY_NO_HISTORY
            //.clearTask() //对应启动标志FLAG_ACTIVITY_CLEAR_TASK
        }

    }
}
