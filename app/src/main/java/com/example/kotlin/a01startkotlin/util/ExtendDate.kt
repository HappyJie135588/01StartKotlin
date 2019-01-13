package com.example.kotlin.a01startkotlin.util

import java.text.SimpleDateFormat
import java.util.*

fun Date.getNowDateTime(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return sdf.format(this)
}

fun Date.getNowDate(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    return sdf.format(this)
}

fun Date.getNowTime(): String {
    val sdf = SimpleDateFormat("HH:mm:ss")
    return sdf.format(this)
}

fun Date.getNowDateTimeDetail(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
    return sdf.format(this)
}

fun Date.getFormatTime(format: String = ""): String {

    val sdf = if (format.isNullOrBlank()) SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS") else SimpleDateFormat(format)
    return sdf.format(this)
}