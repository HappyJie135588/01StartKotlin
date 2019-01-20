package com.example.kotlin.a01startkotlin.class04

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_param.*

class ParamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_param)
        var isOdd = true
        btn_input_manual.setOnClickListener {
            tv_four_answer.text = if (isOdd) getFourBig("古代的四大发明", "造纸术", "印刷术", "火药", "指南针")
            else getFourBig("现代的四大发明", "高铁", "网购", "移动支付", "共享单车")
            isOdd = !isOdd
        }

        btn_input_default.setOnClickListener {
            tv_four_answer.text = getFourBigDefault("古代的四大发明")
        }

        btn_input_part.setOnClickListener {
            tv_four_answer.text = getFourBigDefault("古代的四大发明", "蔡伦发明的造纸术")
        }

        btn_input_name.setOnClickListener {
            tv_four_answer.text = getFourBigDefault("古代的四大发明", second = "活字印刷")
        }

        btn_param_vararg.setOnClickListener {
            tv_four_answer.text = if (isOdd) getFourBigVararg("古代的四大发明")
            else getFourBigVararg("古代的七大发明", "造纸术", "印刷术", "火药", "指南针", "丝绸", "瓷器", "茶叶")
            isOdd = !isOdd
        }

        btn_param_array.setOnClickListener {
            tv_four_answer.text = if (isOdd) getFourBigArray("古代的四大发明") else
                getFourBigArray("古代的N大发明", "造纸术", "印刷术", "火药", "指南针", arrayOf("丝绸", "瓷器", "茶叶"), arrayOf("国画", "中医", "武术"))
            isOdd = !isOdd
        }


    }

    fun getFourBig(general: String, first: String, second: String, third: String, fourth: String): String {
        var answer: String = "$general: $first, $second, $third, $fourth"
        return answer
    }

    fun getFourBigDefault(general: String, first: String = "造纸术", second: String = "印刷术", third: String = "火药", fourth: String = "指南针"): String {
        var answer: String = "$general: $first, $second, $third, $fourth"
        return answer
    }

    fun getFourBigVararg(general: String, first: String = "造纸术", second: String = "印刷术", third: String = "火药", fourth: String = "指南针", vararg otherArray: String?): String {
        var answer: String = "$general: $first, $second, $third, $fourth"
        for (item in otherArray) {
            answer = "$answer, $item"
        }
        return answer
    }

    fun getFourBigArray(general: String, first: String = "造纸术", second: String = "印刷术", third: String = "火药", fourth: String = "指南针", vararg otherArray: Array<String>): String {
        var answer: String = "$general: $first, $second, $third, $fourth"
        //先遍历每个数组
        for (array in otherArray) {
            //再遍历某个数组中的所有元素
            for (item in array) {
                answer = "$answer, $item"
            }
        }
        return answer
    }

}
