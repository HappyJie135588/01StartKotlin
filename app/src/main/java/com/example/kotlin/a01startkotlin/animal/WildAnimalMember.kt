package com.example.kotlin.a01startkotlin.animal

class WildAnimalMember(var name: String, val sex: Int = 0) {
    var sexName: String
    init {
        sexName = if (sex == 0) "公" else "母"
    }
}