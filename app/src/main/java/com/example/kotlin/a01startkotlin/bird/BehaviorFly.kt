package com.example.kotlin.a01startkotlin.bird

class BehaviorFly :Behavior {
    override fun fly():String {
        return "翱翔天空"
    }

    override fun swim():String {
        return "落水凤凰不如鸡"
    }

    override fun run():String {
        return "能飞干嘛还要走"
    }

    override var skilledSports:String = "飞翔"
}