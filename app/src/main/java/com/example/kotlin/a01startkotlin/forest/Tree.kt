package com.example.kotlin.a01startkotlin.forest

class Tree(var treeName:String) {
    //在类内部再定义一个类，这个新类称作嵌套类
    class Flower(var flowerName:String){
        fun getName():String{
            return "这是一朵$flowerName"
            //普通的嵌套类不能访问外部类的成员如treeName
            //否则编译器报错“Unresolved reference: ***”
            //return "这是${treeName}上的一朵$flowerName"
            //return "这是${treeName}上的一朵${flowerName}"
        }
    }

    inner class Fruit(var fruitName:String){
        fun getName():String{
            return "这是${treeName}上长出来$fruitName"
        }

    }
}