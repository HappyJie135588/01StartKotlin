package com.example.kotlin.a01startkotlin.class04

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.util.*
import kotlinx.android.synthetic.main.activity_special.*

class SpecialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_special)

        var count = 0
        btn_vararg_generic.setOnClickListener {
            tv_function_result.text = when (count % 3) {
                0 -> appendString<String>("古代的四大发明", "造纸术", "印刷术", "火药", "指南针")
                1 -> appendString<Int>("小于10的素数", 2, 3, 5, 7)
                else -> appendString<Double>("烧钱的日子", 5.20, 6.18, 11.11, 12.12)
            }
            count++
        }
        var int_array: Array<Int> = arrayOf(1, 2, 3)
        var float_array: Array<Float> = arrayOf(1.0f, 2.0f, 3.0f)
        var double_array: Array<Double> = arrayOf(11.11, 22.22, 33.33)
        // Kotlin进行函数调用时，要求参数类型完全匹配。所以即使Int继承自Number类，也不能调用setArrayNumber方法传送Int类型
        // btn_generic_number.setOnClickListener { setArrayNumber(int_array) }
        btn_generic_number.setOnClickListener {
            when (count % 3) {
                0 -> setArrayStr<Int>(int_array)
                1 -> setArrayStr<Float>(float_array)
                else -> setArrayStr<Double>(double_array)
            }
            count++
        }

        btn_function_simplify.setOnClickListener {
            var n = 10 //计算阶乘结果，即10*9*8*7*6*5*4*3*2*1
            tv_function_result.text = "$n!的运算结果是${factorial(n)}"
        }

        btn_function_recursion.setOnClickListener {
            var x = 100.0 //不管x为何值，findFixPoint(x)的结果只有一个
            tv_function_result.text = "余弦不动点的值为${findFixPoint(x)}"
        }

        var string_array: Array<String> = arrayOf("How", "do", "you", "do", "I'm   ", "Fine")
        btn_function_higher.setOnClickListener {
            tv_function_result.text = when (count++ % 5) {
                0 -> "字符串数组的默认最大值为${string_array.max()}"
                1 -> "字符串数组按长度比较的最大值为${maxCustom(string_array, { a, b -> a.length > b.length })}"
                2 -> "字符串数组的默认最大值(使用高阶函数)为${maxCustom(string_array, { a, b -> a > b })}"
                3 -> "字符串数组按去掉空格再比较长度的最大值为${maxCustom(string_array, { a, b -> a.trim().length > b.trim().length })}"
                else -> "字符串数组按长度比较的最大值为采用传统写法${maxCustom(string_array, fun(a: String, b: String): Boolean {
                    var result: Boolean
                    result = a.length > b.length
                    return result
                })}"
            }
        }


    }

    fun setArrayNumber(array: Array<Number>) {
        var str: String = "数组元素依次排列:"
        for (item in array) {
            str = str + item.toString() + ", "
        }
        tv_function_result.text = str
    }

    inline fun <reified T : Number> setArrayStr(array: Array<T>) {
        var str: String = "数组元素依次排列:"
        for (item in array) {
            str = str + item.toString() + ","
        }
        tv_function_result.text = str
    }
}
