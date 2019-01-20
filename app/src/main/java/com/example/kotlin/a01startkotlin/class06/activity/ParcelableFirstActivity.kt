package com.example.kotlin.a01startkotlin.class06.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.bean.MessageInfo
import com.example.kotlin.a01startkotlin.util.DateUtil
import kotlinx.android.synthetic.main.activity_parcelable_first.*
import org.jetbrains.anko.startActivity

class ParcelableFirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable_first)
        btn_act_request.setOnClickListener {
            val request = MessageInfo(et_request.text.toString(), DateUtil.nowTime)
            startActivity<ParcelableSecondActivity>("message" to request)
        }

    }
}
