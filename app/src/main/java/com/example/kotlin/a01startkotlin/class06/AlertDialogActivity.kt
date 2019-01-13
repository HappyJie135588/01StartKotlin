package com.example.kotlin.a01startkotlin.class06

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_alert_dialog.*
import org.jetbrains.anko.alert

class AlertDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        btn_alert.setOnClickListener {
            alert("你真的要卸载我吗?", "尊敬的用户") {
                positiveButton("残忍卸载") {
                    tv_alert.text = "虽然依依不舍，但是只能离开了"
                }
                negativeButton("我再想想") {
                    tv_alert.text = "让我再陪你三百六十五个日夜"
                }
            }.show()
        }

    }
}
