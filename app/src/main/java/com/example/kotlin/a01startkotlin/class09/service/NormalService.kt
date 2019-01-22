package com.example.kotlin.a01startkotlin.class09.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.kotlin.a01startkotlin.class09.ServiceNormalActivity

class NormalService : Service() {

    override fun onCreate() {
        super.onCreate()
        ServiceNormalActivity.showText("创建服务")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val bundle = intent.extras
        val request_content = bundle.getString("request_content")
        ServiceNormalActivity.showText("启动服务,收到请求内容:${request_content}")
        return Service.START_STICKY
    }

    override fun onDestroy() {
        ServiceNormalActivity.showText("停止服务")
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}