package com.example.kotlin.a01startkotlin.class08.bean

import com.example.kotlin.a01startkotlin.class07.bean.GoodsInfo

data class CartInfo(var rowid: Long=0, var xuhao: Int=0, var goods_id: Long=0,
                    var count: Int=0, var update_time: String="", var goods: GoodsInfo =GoodsInfo()) {
}
