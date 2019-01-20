package com.example.kotlin.a01startkotlin.class03

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_condition.*

class ConditionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_condition)
        var is_odd = true
        tv_puzzle.text = "凉风有信，秋月无边。打二字"
        btn_if_simple.setOnClickListener {
            if (is_odd) {
                tv_answer.text = "凉风有信的谜底是“讽”"
            } else {
                tv_answer.text = "秋月无边的谜底是“二”"
            }
            is_odd = !is_odd
        }
        btn_if_value.setOnClickListener {
            tv_answer.text = if (is_odd) {
                "凉风有信的谜底是“讽”"
            } else {
                "秋月无边的谜底是“二”"
            }
            is_odd = !is_odd
        }
        var count: Int = 0
        btn_when_simple.setOnClickListener {
            when (count) {
                0 -> tv_answer.text = "凉风有信的谜底是“讽”"
                1 -> tv_answer.text = "秋月无边的谜底是“二”"
                else -> tv_answer.text = "好诗,这真是一首好诗"
            }
            count = (count + 1) % 3
        }
        btn_when_value.setOnClickListener {
            tv_answer.text = when (count) {
                0 -> "凉风有信的谜底是“讽”"
                1 -> "秋月无边的谜底是“二”"
                else -> "好诗,这真是一首好诗"
            }
            count = (count + 1) % 3
        }
        var odd: Int = 0
        var even: Int = 1
        btn_when_variable.setOnClickListener {
            tv_answer.text = when (count) {
                odd -> "凉风有信的谜底是“讽”"
                even -> "秋月无边的谜底是“二”"
                else -> "好诗,这真是一首好诗"
            }
            count = (count + 1) % 3
        }
        btn_when_region.setOnClickListener {
            tv_answer.text = when (count) {
                1, 3, 5, 7, 9 -> "凉风有信的谜底是“讽”"
                in 13..19 -> "秋月无边的谜底是“二”"
                !in 6..10 -> "当里的当,少侠你来猜猜"
                else -> "好诗,这真是一首好诗"
            }
            count = (count + 1) % 20
        }
        var countType: Number
        btn_when_instance.setOnClickListener {
            count = (count + 1) % 3
            countType = when (count) {
                0 -> count.toLong()
                1 -> count.toDouble()
                else -> count.toFloat()
            }
            tv_answer.text = when (countType) {
                is Long -> "此恨绵绵无绝期"
                is Double -> "树上的鸟儿成双对"
                else -> "门泊东吴万里船"
            }
        }
    }
}
