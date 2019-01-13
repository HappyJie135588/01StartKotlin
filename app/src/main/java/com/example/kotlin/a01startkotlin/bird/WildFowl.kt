package com.example.kotlin.a01startkotlin.bird

//只有接口才能够使用关键字by进行代理操作，
//如果by的对象是个类，则编译器会报错“Only interfaces can be delegated to”
class WildFowl(name: String, sex: Int = MALE, behavior: Behavior) : Bird(name, sex), Behavior by behavior {
}