package com.example.kotlin.a01startkotlin.class06.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_checkbox.*

class CheckboxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        ck_select.setOnCheckedChangeListener { buttonView, isChecked ->
            tv_select.text = "你${if (isChecked) "勾选" else "取消勾选"}了复选框"
        }
    }
}
