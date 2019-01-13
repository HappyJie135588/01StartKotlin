package com.example.kotlin.a01startkotlin.util

fun <T> appendString(tag: String, vararg otherInfo: T?): String {
    var str: String = "$tag："
    for (item in otherInfo) {
        str = "$str${item.toString()}，"
    }
    return str
}

//fun factorial(n: Int): Int {
//    return if (n == 1) 1 else n * factorial(n - 1)
//}

fun factorial(n: Int): Int = if (n == 1) 1 else n * factorial(n - 1)

// 如果函数尾部递归调用自身，则可加上关键字tailrec表示这是个尾递归函数，
// 此时编译器会自动优化递归，即用循环方式代替递归，从而避免栈溢出的情况。
// 比如下面这个求余弦不动点的函数就是尾递归函数

tailrec fun findFixPoint(x: Double = 1.0): Double = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))

// 允许将函数表达式作为输入参数传进来，就形成了高阶函数，这里的greater函数就像是个变量。
// greater函数有两个输入参数，返回布尔型的输出参数。
// 如果第一个参数大于第二个参数，则认为greater返回true，否则返回false。
fun <T> maxCustom(array: Array<T>, greater: (T, T) -> Boolean): T? {
    var max: T? = null
    for (item in array) {
        if (max == null || greater(item, max))
            max = item
    }
    return max
}

