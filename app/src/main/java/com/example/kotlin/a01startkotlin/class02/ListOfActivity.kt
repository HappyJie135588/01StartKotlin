package com.example.kotlin.a01startkotlin.class02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_list_of.*

class ListOfActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of)

        var goodsMutList: MutableList<String> = mutableListOf("iPhone8", "Mate10", "小米6", "OPPO R11", "vivo X9S", "魅族 Pro6SS")
        btn_for_index.setOnClickListener {
            var desc = ""
            for (i in goodsMutList.indices) {
                val item = goodsMutList[i]
                desc = "${desc}名称:${item}\n"
            }
            tv_list_result.text = "手机畅销榜包含以下${goodsMutList.size}款手机:\n$desc"
        }

        var sortAsc = true
        btn_sort_by.setOnClickListener {
            if (sortAsc) {
                goodsMutList.sortBy { it.length }
            } else {
                goodsMutList.sortByDescending { it.length }
            }
            var desc = ""
            for (item in goodsMutList) {
                desc = "${desc}名称:${item}\n"
            }
            tv_list_result.text = "手机畅销榜已按照长度${if (sortAsc) "升序" else "降序"}重新排列：\n$desc"
            sortAsc = !sortAsc
        }
    }
}
