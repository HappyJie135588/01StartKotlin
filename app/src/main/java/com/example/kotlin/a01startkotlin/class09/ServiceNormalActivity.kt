package com.example.kotlin.a01startkotlin.class09

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.class09.service.NormalService
import com.example.kotlin.a01startkotlin.util.DateUtil
import kotlinx.android.synthetic.main.activity_service_normal.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class ServiceNormalActivity : AppCompatActivity() {
    private lateinit var intentNormal: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_normal)
        btn_start.setOnClickListener {
            //第一种写法，参数名和参数值使用关键字to隔开
            intentNormal = intentFor<NormalService>(
                    "request_content" to et_request.text.toString())
            //第二种写法，利用Pair把参数名和参数值进行配对
            //intentNormal = intentFor<NormalService>(
            //        Pair("request_content", et_request.text.toString()))
            //虽然Anko库集成了startService的简化写法，但是一般不这么调用。
            //因为服务启动之后是需要停止的，按Anko的简化写法会无法停止服务
            //除非无需在代码中停止该服务，才可以采用Anko的简化写法
            //startService<NormalService>("request_content" to et_request.text.toString())
            startService(intentNormal)
            toast("普通服务已启动")
        }
        btn_stop.setOnClickListener {
            if (intentNormal != null) {
                stopService(intentNormal)
                toast("普通服务已停止")
            }
        }
        Normal.tv_normal = findViewById(R.id.tv_normal)
    }

    companion object Normal {
        private var tv_normal: TextView? = null
        private var mDesc = ""
        fun showText(desc: String) {
            mDesc = "${mDesc}${DateUtil.nowTime} $desc\n"
            //如果tv_normal非空才设置文本,否则不设置文本
            tv_normal?.text = mDesc
        }

    }
}
