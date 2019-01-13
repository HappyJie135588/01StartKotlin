package com.example.kotlin.a01startkotlin.class02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_string.*

class StringActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_string)
        val origin: String = tv_origin.text.toString()
        var origin_trim: String = origin
        if (origin_trim.indexOf('.') > 0) {
            origin_trim = origin_trim.substring(0, origin_trim.indexOf('.'))
        }

        btn_split.setOnClickListener {
            var strList: List<String> = origin.split('.')
            var strResult: String = ""
            for (item in strList) {
                strResult = strResult + item + ", "
            }
            tv_convert.text = strResult
        }

        btn_format.setOnClickListener { tv_convert.text = "字符串的值为$origin" }
        btn_length.setOnClickListener { tv_convert.text = "字符串的长度为${origin.length}" }
        btn_dollar.setOnClickListener {
            tv_convert.text = "美元金额为${'$'}$origin"
            //tv_convert.text = "美元金额为\$$origin"
        }
    }
}
