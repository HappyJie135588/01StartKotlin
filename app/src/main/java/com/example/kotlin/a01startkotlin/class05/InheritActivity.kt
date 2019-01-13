package com.example.kotlin.a01startkotlin.class05

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.grammar.bird.BehaviorRun
import com.example.grammar.bird.BehaviorSwim
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.bird.*
import kotlinx.android.synthetic.main.activity_inherit.*

class InheritActivity : AppCompatActivity() {
    var count = 0
    var birdName = ""
    var birdSex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inherit)

        btn_class_bird.setOnClickListener {
            setbirdInfo()
            var bird = when (count % 2) {
                0 -> Bird(birdName)
                else -> Bird(birdName, birdSex)
            }
            tv_class_inherit.text = bird.getDesc("鸟语林")
            //外部无法访问private和protected的成员属性和成员方法
            //bird.getSexName(birdSex)
        }

        btn_class_duck.setOnClickListener {
            var sexBrid = if (count++ % 3 == 0) Bird.MALE else Bird.FEMALE
            var duck = Duck(sex = sexBrid)
            tv_class_inherit.text = duck.getDesc("鸟语林")

        }

        btn_class_ostrich.setOnClickListener {
            var sexBird = if (count++ % 3 == 0) Bird.MALE else Bird.FEMALE
            var ostrich = Ostrich(sex = sexBird)
            tv_class_inherit.text = ostrich.getDesc("鸟语林")
        }

        btn_abstract_cock.setOnClickListener {
            //调用公鸡类的叫唤方法
            tv_class_inherit.text = Cock().callOut(count++ % 10)
        }

        btn_abstract_hen.setOnClickListener {
            //调用母鸡类的叫唤方法
            tv_class_inherit.text = Hen().callOut(count++ % 10)
        }

        btn_interface_behavior.setOnClickListener {
            tv_class_inherit.text = when (count++ % 3) {
                0 -> Goose().fly()
                1 -> Goose().swim()
                else -> Goose().run()
            }
        }

        btn_delegate_behavior.setOnClickListener {
            var fowl = when (count++ % 6) {
                0 -> WildFowl("老鹰", Bird.MALE, BehaviorFly())
                1 -> WildFowl("凤凰", behavior = BehaviorFly())
                2 -> WildFowl("大雁", Bird.MALE, BehaviorSwim())
                3 -> WildFowl("企鹅", behavior = BehaviorSwim())
                4 -> WildFowl("鸵鸟", Bird.MALE, BehaviorRun())
                else -> WildFowl("鸸鹋", behavior = BehaviorRun())
            }

            var action = when (count % 11) {
                in 0..3 -> fowl.fly()
                4, 7, 10 -> fowl.swim()
                else -> fowl.run()
            }

            tv_class_inherit.text = "${fowl.name}:$action"

        }
    }

    fun setbirdInfo() {
        count++
        birdName = if (count % 2 == 0) "孔雀" else "黄鹂"
        birdSex = if (count % 3 == 0) Bird.MALE else Bird.FEMALE
    }
}
