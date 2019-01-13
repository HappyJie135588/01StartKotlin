package com.example.kotlin.a01startkotlin.util

fun <T> Array<T>.swap(pos1: Int, pos2: Int) {
    var tmp: T = this[pos1]
    this[pos1] = this[pos2]
    this[pos2] = tmp
}

fun <T> Array<T>.maxCustomize(greater: (T, T) -> Boolean): T? {
    var max: T? = null
    for (item in this) {
        if (max == null || greater(item, max)) {
            max = item;
        }
    }
    return max;
}