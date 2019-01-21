package com.example.kotlin.a01startkotlin.class09

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_notify_special.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class NotifySpecialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notify_special)
        btn_notify_progress.setOnClickListener { v -> clickNotify(v) }
        btn_notify_float.setOnClickListener { v -> clickNotify(v) }
        btn_lock_private.setOnClickListener { v -> clickNotify(v) }
        btn_lock_public.setOnClickListener { v -> clickNotify(v) }
    }

    private fun clickNotify(v: View) {
        val title = et_title.text.toString()
        val message = et_message.text.toString()
        when (v.id) {
            R.id.btn_notify_progress -> startProgressNotify(title, message)
            R.id.btn_notify_float -> sendFloatNotify(title, message)
            R.id.btn_lock_private -> sendLockNotify(title, message, false)
            R.id.btn_lock_public -> sendLockNotify(title, message, true)
        }
    }

    private val handler = Handler()
    private var count = 0
    private var refreshNotify: ProgressNotify? = null
    //开始播放进度通知的刷新动画
    private fun startProgressNotify(title: String, message: String) {
        count = 0
        refreshNotify = ProgressNotify(title, message)
        handler.post(refreshNotify)
        toast("已推送到进度通知。")
    }

    //定义一个持续发送进度通知的任务内部类，当进度超过100%时任务停止
    private inner class ProgressNotify(private val title: String, private val message: String) : Runnable {
        override fun run() {
            sendProgressNotify(title, message, count)
            count++
            if (count <= 100) {
                handler.postDelayed(refreshNotify, 200)
            }
        }
    }

    //发送单次进度通知。若要不断刷新进度，需外部多次调用该方法
    private fun sendProgressNotify(title: String, message: String, progress: Int) {
        val clickIntent = intentFor<NotifySpecialActivity>()
        val piClick = PendingIntent.getActivity(this,
                R.string.app_name, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        //开始构建进度通知的各个参数
        val builder = Notification.Builder(this)
        builder.setContentIntent(piClick)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_app)
                .setTicker("进度通知来啦")
                .setWhen(System.currentTimeMillis())
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_app))
                .setContentTitle(title)
                .setContentText(message)
                .setDefaults(Notification.FLAG_ONLY_ALERT_ONCE)//设置大视图通知的提醒方式
                .setProgress(100, progress, false) //设置进度条的当前进度
        val notify = builder.build()
        //获取系统的通知管理器
        val notifyMgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //添加如果系统版本大于等于 8.0 设置NotificationChannel代码
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel = NotificationChannel(
                    "com.example.kotlin.a01startkotlin",
                    "随便写点什么",
                    NotificationManager.IMPORTANCE_LOW
            )
            channel.enableVibration(false)
            channel.enableLights(false)
            channel.setSound(null, null)
            notifyMgr.createNotificationChannel(channel)
            builder.setChannelId("com.example.kotlin.a01startkotlin")
        }
        notifyMgr.notify(R.string.app_name, notify)
    }

    private fun sendFloatNotify(title: String, message: String) {
        toast("已推送到浮动通知。")
        val clickIntent = intentFor<NotifySimpleActivity>()
        val piClick = PendingIntent.getActivity(this,
                R.string.app_name, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        //开始构建浮动通知的各个参数
        val builder = Notification.Builder(this)
        builder.setContentIntent(piClick)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_app)
                .setTicker("浮动通知来啦")
                .setWhen(System.currentTimeMillis())
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_app))
                .setContentTitle(title)
                .setContentText(message)
                .setFullScreenIntent(piClick, true) //设置浮动窗的点击事件
        val notify = builder.build()
        //获取系统的通知管理器
        val notifyMgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //添加如果系统版本大于等于 8.0 设置NotificationChannel代码
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel = NotificationChannel(
                    "com.example.kotlin.a01startkotlin",
                    "随便写点什么",
                    NotificationManager.IMPORTANCE_DEFAULT
            )
            notifyMgr.createNotificationChannel(channel)
            builder.setChannelId("com.example.kotlin.a01startkotlin")
        }
        handler.postDelayed({ notifyMgr.notify(R.string.app_name, notify) }, 5000)
    }

    private fun sendLockNotify(title: String, message: String, visibile: Boolean) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            toast("锁屏通知需要5.0以上系统支持。")
            return
        } else {
            toast("已推送锁屏通知。")
        }
        val clickIntent = intentFor<NotifySimpleActivity>()
        val piClick = PendingIntent.getActivity(this,
                R.string.app_name, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        //开始构建锁屏通知的各个参数
        val builder = Notification.Builder(this)
        builder.setContentIntent(piClick)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_app)
                .setTicker("锁屏通知来啦")
                .setWhen(System.currentTimeMillis())
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_app))
                .setContentTitle(title)
                .setContentText(message)
        //设置锁屏通知的可见性
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setVisibility(if (visibile) Notification.VISIBILITY_PUBLIC else Notification.VISIBILITY_SECRET)
        }
        val notify = builder.build()
        //获取系统的通知管理器
        val notifyMgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //添加如果系统版本大于等于 8.0 设置NotificationChannel代码
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel = NotificationChannel(
                    "com.example.kotlin.a01startkotlin",
                    "随便写点什么",
                    NotificationManager.IMPORTANCE_DEFAULT
            )
            notifyMgr.createNotificationChannel(channel)
            builder.setChannelId("com.example.kotlin.a01startkotlin")
        }
        handler.postDelayed({ notifyMgr.notify(R.string.app_name, notify) }, 5000)
    }
}
