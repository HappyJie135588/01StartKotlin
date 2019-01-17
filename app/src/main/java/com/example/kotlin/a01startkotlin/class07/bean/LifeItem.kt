package com.example.kotlin.a01startkotlin.class07.bean

import com.example.kotlin.a01startkotlin.R

data class LifeItem(var pic_id: Int, var title: String) {
    companion object {
        val default: MutableList<LifeItem>
            get() {
                val itemArray = mutableListOf<LifeItem>()
                for (i in 0..39) {
                    itemArray.add(LifeItem(R.drawable.icon_transfer, "转账"))
                }
                return itemArray
            }
    }
}
