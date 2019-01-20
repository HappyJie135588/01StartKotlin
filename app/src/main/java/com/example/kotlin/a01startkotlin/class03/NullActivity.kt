package com.example.kotlin.a01startkotlin.class03

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_null.*

class NullActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null)
        val strA: String = "非空"
        val strB: String? = null
        val strC: String? = "可空串"

        var length: Int = 0
        btn_length_a.setOnClickListener {
            length = strA.length
            tv_check_result.text = "字符串A的长度为$length"
        }
        btn_length_b.setOnClickListener {
            //length=strB.length //这种写法是不行的，因为strB可能为空，会扔出空指针异常
            length = if (strB != null) strB.length else -1
            tv_check_result.text = "字符串B的长度为$length"
        }
        btn_length_c.setOnClickListener {
            length = if (strC != null) strC.length else -1
            tv_check_result.text = "字符串C的长度为$length"
        }
        var length_null: Int?
        btn_question_dot.setOnClickListener {
            length_null = strB?.length
            tv_check_result.text = "使用?.得到字符串B的长度为$length_null"
        }
        btn_question_colon.setOnClickListener {
            length_null = strB?.length ?: -1
            tv_check_result.text = "使用?:得到字符串B的长度为$length_null"
        }
        btn_exclamation_two.setOnClickListener {
            try {
                length_null = strB!!.length
                tv_check_result.text = "使用!!得到字符串B的长度为$length_null"
            } catch (e: Exception) {
                tv_check_result.text = "发生空指针异常"
            }

        }

    }
}
