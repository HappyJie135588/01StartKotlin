package com.example.kotlin.a01startkotlin.class03

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_repeat.*

class RepeatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repeat)
        val poemArray: Array<String> = arrayOf("朝辞白帝彩云间", "千里江陵一日还", "两岸猿声啼不住", "轻舟已过万重山")
        btn_repeat_item.setOnClickListener {
            var poem: String = ""
            for (item in poemArray) {
                poem = "${poem}${item},\n"
            }
            tv_poem_content.text = poem
        }
        btn_repeat_subscript.setOnClickListener {
            var poem: String = ""
            //indices表示数组变量对应的下标数组
            for (i in poemArray.indices) {
                if (i % 2 == 0) {
                    poem = "${poem}${poemArray[i]},\n"
                } else {
                    poem = "${poem}${poemArray[i]}.\n"
                }
            }
            tv_poem_content.text = poem
        }

        btn_repeat_begin.setOnClickListener {
            var poem: String = ""
            var i: Int = 0
            while (i < poemArray.size) {
                if (i % 2 == 0) {
                    poem = "$poem${poemArray[i]},\n"
                } else {
                    poem = "$poem${poemArray[i]}.\n"
                }
                i++
            }
            poem = "${poem}改诗歌一共有${i}句."
            tv_poem_content.text = poem
        }
        btn_repeat_end.setOnClickListener {
            var poem: String = ""
            var i: Int = 0
            do {
                if (i % 2 == 0) {
                    poem = "$poem${poemArray[i]},\n"
                } else {
                    poem = "$poem${poemArray[i]}.\n"
                }
                i++
            } while (i < poemArray.size)
            poem = "${poem}改诗歌一共有${i}句."
            tv_poem_content.text = poem
        }

        val poem2Array: Array<String?> = arrayOf("朝辞白帝彩云间", null, "千里江陵一日还", "", "两岸猿声啼不住", "   ", "轻舟已过万重山", "送孟浩然之广陵")
        btn_repeat_continue.setOnClickListener {
            var poem: String = ""
            var pos: Int = -1
            var count: Int = 0
            while (pos <= poem2Array.size) {
                pos++
                if (poem2Array[pos].isNullOrBlank()) {
                    continue
                }
                if (count % 2 == 0) {
                    poem = "$poem${poem2Array[pos]},\n"
                } else {
                    poem = "$poem${poem2Array[pos]}.\n"
                }
                count++
                if (count == 4) {
                    break
                }
            }
            tv_poem_content.text = poem
        }
        btn_repeat_break.setOnClickListener {
            var i: Int = 0
            var is_found = false
            //给外层循环加个名加outside的标记
            outside@ while (i < poemArray.size) {
                var item = poemArray[i]
                var j: Int = 0
                while (j < item.length) {
                    if (item[j] == '一') {
                        is_found = true
                        //发现情况,直接跳出outside循环
                        break@outside
                    }
                    j++
                }
                i++
            }
            tv_poem_content.text = if(is_found){
                "我找到'一'字啦"
            }else{
                "没有找到'一'字呀"
            }
        }

    }
}
