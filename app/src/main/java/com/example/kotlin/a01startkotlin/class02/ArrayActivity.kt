package com.example.kotlin.a01startkotlin.class02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_array.*

class ArrayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array)
        var int_array: IntArray = intArrayOf(1, 2, 3)
        var float_array: FloatArray = floatArrayOf(1.0f, 2.0f, 3.0f)
        var double_array: DoubleArray = doubleArrayOf(1.0, 2.0, 3.0)
        var boolean_array: BooleanArray = booleanArrayOf(true, false, true)
        var char_Array: CharArray = charArrayOf('a', 'b', 'c')
        var string_array: Array<String> = arrayOf("Hwo", "Are", "You")
        var intArray: Array<Int> = arrayOf(1, 2, 3)
        var longArray: Array<Long> = arrayOf(1, 2, 3)
        var floatArray: Array<Float> = arrayOf(1.0f, 2.0f, 3.0f)
        var doubleArray: Array<Double> = arrayOf(1.0, 2.0, 3.0)
        var booleanArray: Array<Boolean> = arrayOf(true, false, true)
        var charArray: Array<Char> = arrayOf('a', 'b', 'c')

        btn_string.setOnClickListener {
            var str: String = ""
            var i: Int = 0
            while (i < string_array.size) {
                str = str + string_array[i] + ","
                i++
            }
            tv_item_list.text = str

        }


    }
}
