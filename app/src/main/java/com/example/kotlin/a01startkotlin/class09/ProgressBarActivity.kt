package com.example.kotlin.a01startkotlin.class09

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_progress_bar.*

class ProgressBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)
        pb_progress.max = 100
        pb_progress.progress = 0
        pb_progress.progressDrawable = resources.getDrawable(R.drawable.progress_green)
        btn_progress.setOnClickListener {
            pb_progress.progress = et_progress.text.toString().toInt()
        }
    }
}
