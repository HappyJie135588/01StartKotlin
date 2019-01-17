package com.example.kotlin.a01startkotlin.class07.materialdesign

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_appbar_nested.*

class AppbarNestedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appbar_nested)
        setSupportActionBar(tl_title)
    }
}
