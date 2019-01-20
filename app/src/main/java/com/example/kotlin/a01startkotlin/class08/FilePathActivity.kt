package com.example.kotlin.a01startkotlin.class08

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_file_path.*

class FilePathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_path)
        val publicPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()
        val privatePath = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString()
        tv_file_path.text = "系统的公共存储路径位于${publicPath}" +
                "\n\n当前App的私有存储路径位于${privatePath}" +
                "\n\nAndroid7.0之后默认禁止访问公共存储目录"
    }
}
