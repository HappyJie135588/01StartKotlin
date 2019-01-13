package com.example.kotlin.a01startkotlin.class07

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_spinner_dialog.*
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast

class SpinnerDialogActivity : AppCompatActivity() {
    private val satellites = listOf("水星", "金星", "地球", "火星", "木星", "土星")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_dialog)

        tv_spinner.text = satellites[0]
        tv_spinner.setOnClickListener {
            selector("请选择行星", satellites) { dialog, i ->
                tv_spinner.text = satellites[i]
                toast("你选择的行星是${tv_spinner.text}")
            }
        }


    }
}
