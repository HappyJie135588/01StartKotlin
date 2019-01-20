package com.example.kotlin.a01startkotlin.class03

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_equal.*
import java.util.*

class EqualActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equal)
        val helloHe: String = "你好"
        val helloShe: String = "妳好"
        var isEqual: Boolean = true
        btn_equal_struct.setOnClickListener {
            if (isEqual) {
                tv_check_title.text = "比较 $helloHe 和 $helloShe 是否相等"
                val result: Boolean = helloHe == helloShe
                tv_check_result.text = "==的比较结果是$result"
            } else {
                tv_check_title.text = "比较 $helloHe 和 $helloShe 是否不等"
                //比较两个字符串是否不等的Java写法是 !helloHe.equals(helloShe)
                val result = helloHe != helloShe
                tv_check_result.text = "!=的比较结果是$result"
            }
            isEqual = !isEqual
        }
        val data1: Date = Date()
        val data2: Any = data1.clone()
        var count: Int = 0
        btn_equal_refer.setOnClickListener {
            when (count++ % 4) {
                0 -> {
                    tv_check_title.text = "比较date1和date2是否结构相等"
                    val result = data1 == data2
                    tv_check_result.text = "==的比较结果是$result"
                }
                1 -> {
                    tv_check_title.text = "比较date1和date2是否结构不等"
                    val result = data1 != data2
                    tv_check_result.text = "!=的比较结果是$result"
                }
                2 -> {
                    tv_check_title.text = "比较date1和date2是否引用相等"
                    val result = data1 === data2
                    tv_check_result.text = "===的比较结果是$result"
                }
                else -> {
                    tv_check_title.text = "比较date1和date2是否引用不等"
                    val result = data1 !== data2
                    tv_check_result.text = "!==的比较结果是$result"
                }
            }
        }
        val oneLong: Long = 1L;
        btn_equal_type.setOnClickListener {
            if (isEqual) {
                tv_check_title.text = "比较 oneLong 是否为长整型"
                val result: Boolean = oneLong is Long
                tv_check_result.text = "is的比较结果是$result"
            } else {
                tv_check_title.text = "比较 oneLong 是否非长整型"
                val result: Boolean = oneLong !is Long
                tv_check_result.text = "!is的比较结果是$result"
            }
            isEqual = !isEqual
        }

        val oneArray: IntArray = intArrayOf(1, 2, 3, 4, 5)
        val four: Int = 4
        val nine: Int = 9
        btn_equal_item.setOnClickListener {
            when (count++ % 4) {
                0 -> {
                    tv_check_title.text = "比较 $four 是否存在数组oneArray中"
                    val result: Boolean = four in oneArray
                    tv_check_result.text = "in的比较结果是$result"
                }
                1 -> {
                    tv_check_title.text = "比较 $four 是否不在数组oneArray中"
                    val result: Boolean = four !in oneArray
                    tv_check_result.text = "!in的比较结果是$result"
                }
                2 -> {
                    tv_check_title.text = "比较 $nine 是否存在数组oneArray中"
                    val result: Boolean = nine in oneArray
                    tv_check_result.text = "in的比较结果是$result"
                }
                3 -> {
                    tv_check_title.text = "比较 $nine 是否不在数组oneArray中"
                    val result: Boolean = nine !in oneArray
                    tv_check_result.text = "!in的比较结果是$result"
                }
            }
        }

    }
}
