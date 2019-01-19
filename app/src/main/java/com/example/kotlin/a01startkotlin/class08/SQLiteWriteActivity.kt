package com.example.kotlin.a01startkotlin.class08

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.class08.bean.UserInfo
import com.example.kotlin.a01startkotlin.database.UserDBHelper
import com.example.kotlin.a01startkotlin.util.DateUtil
import kotlinx.android.synthetic.main.activity_sqlite_write.*
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast

class SQLiteWriteActivity : AppCompatActivity() {
    private val types = listOf("未婚", "已婚")
    private lateinit var mHelper: UserDBHelper
    private var bMarried = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_write)
        mHelper = UserDBHelper.getInstance(this)
        sp_married.visibility = View.GONE
        tv_spinner.visibility = View.VISIBLE
        tv_spinner.text = types[0]
        tv_spinner.setOnClickListener {
            selector("请选择婚姻状况", types) { _, i ->
                tv_spinner.text = types[i]
                bMarried = if (i == 0) false else true
            }
        }

        readSQLite()
        btn_save.setOnClickListener {
            when (true) {
                et_name.text.isEmpty() -> toast("请先填写姓名")
                et_age.text.isEmpty() -> toast("请先填写年龄")
                et_height.text.isEmpty() -> toast("请先填写身高")
                et_weight.text.isEmpty() -> toast("请先填写体重")
                else -> {
                    val info = UserInfo(name = et_name.text.toString(),
                            age = et_age.text.toString().toInt(),
                            height = et_height.text.toString().toLong(),
                            weight = et_weight.text.toString().toFloat(),
                            married = bMarried,
                            update_time = DateUtil.nowDateTime)
                    mHelper.insert(info)
                    toast("数据已写入SQLite数据库")
                }
            }
        }


    }

    private fun readSQLite() {
        val userArray = mHelper.queryAll()
        var desc = "数据库查询到${userArray.size}条记录，详情如下："
        for (i in userArray.indices) {
            val item = userArray[i]
            desc = "$desc\n第${i + 1}条记录信息如下：" +
                    "\n　姓名为${item.name}" +
                    "\n　年龄为${item.age}" +
                    "\n　身高为${item.height}" +
                    "\n　体重为${item.weight}" +
                    "\n　婚否为${item.married}" +
                    "\n　更新时间为${item.update_time}"
        }
        if (userArray.isEmpty()) {
            desc = "数据库查询到的记录为空"
        }
        tv_sqlite.text = desc
    }
}
