package com.example.kotlin.a01startkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_easy.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class EasyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy)
        var mStr:String? = "你可以的"
        mStr!!.length
        mStr.isBlank()
        tv_hello.text = "你好啊"

        btn_click.setOnClickListener {
            btn_click.text = "你点了一下下"
        }

        btn_click_long.setOnLongClickListener {
            btn_click_long.text = "你长按了一会儿"
            true
        }

        btn_toast.setOnClickListener {
            toast("小提示：你点了一下下")
        }

        btn_toast_long.setOnLongClickListener {
            longToast("长提示：你长按了一会儿")
            true
        }

    }

}
