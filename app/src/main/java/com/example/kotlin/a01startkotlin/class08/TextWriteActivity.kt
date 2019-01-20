package com.example.kotlin.a01startkotlin.class08

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.util.DateUtil
import kotlinx.android.synthetic.main.activity_text_write.*
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast
import java.io.File

class TextWriteActivity : AppCompatActivity() {
    private val types = listOf("未婚", "已婚")
    private var bMarried = false
    private var mPath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_write)
        mPath = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() + "/"

        sp_married.visibility = View.GONE
        tv_spinner.visibility = View.VISIBLE
        tv_spinner.text = types[0]
        tv_spinner.setOnClickListener {
            selector("请选择婚姻状况", types) { _, i ->
                tv_spinner.text = types[i]
                bMarried = if (i == 0) false else true
            }
        }
        btn_save.setOnClickListener {
            val content = "　姓名：${et_name.text}\n" +
                    "　年龄：${et_age.text}\n" +
                    "　身高：${et_height.text}\n" +
                    "　体重：${et_weight.text}\n" +
                    "　婚否：${types[if (!bMarried) 0 else 1]}\n" +
                    "　注册时间：${DateUtil.nowDateTime}\n"
            val file_path = "${mPath}a/b/c${DateUtil.getFormatTime()}.txt"

            val filename = File("${mPath}a/b/c/")
            if (!filename.exists()) {
                filename.mkdirs()
            }
            //writeText写入文本，writeBytes写入字节数组
            //appendText追加文本，appendBytes追加字节数组
            File(file_path).writeText(content)
            tv_path.text = "用户注册信息文件的保存路径为：\n$file_path"
            toast("文本已写入临时目录")

        }
    }

}
