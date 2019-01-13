package com.example.kotlin.a01startkotlin.class02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_map_of.*

class MapOfActivity : AppCompatActivity() {

    private val goodsA: String = "iPhone8"
    private val goodsB: String = "Mate10"
    private val goodsC: String = "小米6"
    private val goodsD: String = "OPPO R11"
    private val goodsE: String = "vivo X9S"
    private val goodsF: String = "魅族Pro6S"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_of)
        var goodsMap: Map<String, String> = mapOf("苹果" to goodsA, "华为" to goodsB, "小米" to goodsC, "欧珀" to goodsD, "步步高" to goodsE, "魅族" to goodsF)
        var goodsMutMap: MutableMap<String, String> = mutableMapOf(Pair("苹果", goodsA), Pair("华为", goodsB), Pair("小米", goodsC), Pair("欧珀", goodsD), Pair("步步高", goodsE), Pair("魅族", goodsF))
        btn_map_for.setOnClickListener {
            var desc = ""
            for (item in goodsMutMap) {
                desc = "${desc}厂家:${item.key},名称:${item.value}\n"
            }
            tv_map_result.text = "手机畅销榜包含以下${goodsMutMap.size}款手机:\n${desc}"
        }
        btn_map_iterator.setOnClickListener {
            val iterator = goodsMutMap.iterator()
            var desc = ""
            while (iterator.hasNext()) {
                var item = iterator.next()
                desc = "${desc}厂家:${item.key},名称:${item.value}\n"
                tv_map_result.text = "手机畅销榜包含以下${goodsMutMap.size}款手机:\n${desc}"
            }
        }
        btn_map_foreach.setOnClickListener {
            var desc = ""
            goodsMutMap.forEach { key, value ->
                desc = "${desc}厂家:${key},名称:${value}\n"
            }
            tv_map_result.text = "手机畅销榜包含以下${goodsMutMap.size}款手机:\n${desc}"
        }

    }
}
