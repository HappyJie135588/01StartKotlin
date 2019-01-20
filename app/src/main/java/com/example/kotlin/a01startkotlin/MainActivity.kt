package com.example.kotlin.a01startkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.a01startkotlin.class06.view.LinearLayoutActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_linear_layout.setOnClickListener{
            var intent = Intent(this@MainActivity, LinearLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}
