package com.example.kotlin.a01startkotlin.class06.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.bean.MessageInfo
import com.example.kotlin.a01startkotlin.util.DateUtil
import kotlinx.android.synthetic.main.activity_act_request.*
import org.jetbrains.anko.startActivityForResult

class ActRequestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_request)

        btn_act_request.setOnClickListener {
            val info = MessageInfo(et_request.text.toString(), DateUtil.nowTime)
            //ForResult表示需要返回参数
            startActivityForResult<ActResponseActivity>(0, "message" to info)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null) {
            val response = data.extras.getParcelable<MessageInfo>("message")
            tv_request.text = "收到返回消息：\n应答时间为${response.send_time}\n应答内容为${response.content}"
        }
    }
}
