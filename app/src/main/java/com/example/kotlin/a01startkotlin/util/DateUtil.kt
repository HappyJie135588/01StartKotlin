package com.example.kotlin.a01startkotlin.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    val nowDateTime: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return sdf.format(Date())
        }
    val nowDate: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            return sdf.format(Date())
        }
    val nowTime: String
        get() {
            val sdf = SimpleDateFormat("HH:mm:ss")
            return sdf.format(Date())
        }
    val nowDateTimeDetail: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
            return sdf.format(Date())
        }

    fun getFormatTime(format: String = ""): String {
        val sdf = if (format.isNullOrBlank()) SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS") else SimpleDateFormat(format)
        return sdf.format(Date())
    }

}