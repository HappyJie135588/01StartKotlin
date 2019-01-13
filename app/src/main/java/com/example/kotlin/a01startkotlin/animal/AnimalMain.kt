package com.example.kotlin.a01startkotlin.animal

import android.content.Context
import org.jetbrains.anko.toast

class AnimalMain(context: Context, name: String) {
    init {
        context.toast("这只是$name")
    }

    constructor(context: Context, name: String, sex: Int) : this(context, name) {
        var sexName: String = if (sex == 0) "公" else "母"
        context.toast("这只${name}是${sexName}的")
    }
}