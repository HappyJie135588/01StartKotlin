package com.example.kotlin.a01startkotlin.class06.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.bean.MessageInfo
import com.example.kotlin.a01startkotlin.util.DateUtil
import kotlinx.android.synthetic.main.activity_act_response.*

class ActResponseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_response)

        val request = intent.extras.getParcelable<MessageInfo>("message")
        tv_response.text = "收到打包好的请求消息：\n请求时间为${request.send_time}\n请求内容为${request.content}"

        btn_act_response.setOnClickListener {
            val response = MessageInfo(et_response.text.toString(), DateUtil.nowTime)
            val intent = Intent()
            intent.putExtra("message", response)
            //调用setResult方法表示携带应答参数返回到上一个页面
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
