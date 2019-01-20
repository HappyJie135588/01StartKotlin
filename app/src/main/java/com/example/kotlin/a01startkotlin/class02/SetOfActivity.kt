package com.example.kotlin.a01startkotlin.class02

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_set_of.*

class SetOfActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_of)
        val goodsMutset: Set<String> = setOf("iPhone8", "Mate10", "小米6", "OPPO R11", "vivo X9S", "魅族 Pro6SS")
        btn_set_for.setOnClickListener {
            var desc = ""
            for (item in goodsMutset) {
                desc = "${desc}名称:${item}\n"
            }
            tv_set_result.text = "手机畅销榜包含以下${goodsMutset.size}款手机:\n$desc"
        }

        btn_set_iterator.setOnClickListener {
            var desc = ""
            var iterator = goodsMutset.iterator()
            while (iterator.hasNext()){
                var item = iterator.next()
                desc = "${desc}名称:${item}\n"
            }
            tv_set_result.text = "手机畅销榜包含以下${goodsMutset.size}款手机:\n$desc"
        }
    }
}
