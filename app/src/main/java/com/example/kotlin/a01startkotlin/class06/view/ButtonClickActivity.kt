package com.example.kotlin.a01startkotlin.class06.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_button_click.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class ButtonClickActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_click)
        btn_click_anonymos.setOnClickListener { v ->
            //Kotlin对变量进行类型转换的关键字是as
            toast("你点击了控件:${(v as Button).text}")
        }
        btn_click_anonymos.setOnLongClickListener { v ->
            longToast("你长按了控件${(v as Button).text}")
            true
        }
        btn_click_inner.setOnClickListener(MyClickLister())
        btn_click_inner.setOnLongClickListener(MyLongClickLister())

        btn_click_interface.setOnClickListener(this)
        btn_click_interface.setOnLongClickListener(this)


    }

    override fun onClick(v: View?) {
        toast("你点击了控件:${(v as Button).text}")
    }

    override fun onLongClick(v: View?): Boolean {
        longToast("你长按了控件${(v as Button).text}")
        return true
    }

    private inner class MyClickLister : View.OnClickListener {
        override fun onClick(v: View?) {
            toast("你点击了控件:${(v as Button).text}")
        }
    }

    private inner class MyLongClickLister : View.OnLongClickListener {
        override fun onLongClick(v: View?): Boolean {
            longToast("你长按了控件${(v as Button).text}")
            return true
        }

    }
}
