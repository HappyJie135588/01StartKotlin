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
import android.support.v4.app.NotificationCompat
import android.view.View
import com.example.kotlin.a01startkotlin.R
import kotlinx.android.synthetic.main.activity_notify_simple.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast

class NotifySimpleActivity : AppCompatActivity() {
    private val styles = listOf("大文字风格", "大图片风格", "收件箱风格")
    private var type = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notify_simple)
        btn_send_simple.setOnClickListener {
            val title = et_title.text.toString()
            val message = et_message.text.toString()
            sendSimpleNotify(title, message)
            toast("简单消息已推送到通知栏。点击该消息回到首页")
        }
        btn_send_counter.setOnClickListener {
            val title = et_title.text.toString()
            val message = et_message.text.toString()
            sendCounterNotify(title, message)
            toast("计数消息已推送到通知栏。滑掉该消息回到首页")
        }

        sp_style.visibility = View.GONE
        tv_spinner.visibility = View.VISIBLE
        tv_spinner.text = styles[0]
        tv_spinner.setOnClickListener {
            selector("请选择大视图风格", styles) {_, i ->
                tv_spinner.text = styles[i]
                type = i
            }
        }
        btn_send_large.setOnClickListener {
            getStyleAndSend(et_title.text.toString(), et_message.text.toString(), type)
        }

    }

    private fun sendSimpleNotify(title: String, message: String) {
        //声明一个点击通知栏时触发的动作意图
        val clickIntent = intentFor<NotifySimpleActivity>()
        val piClick = PendingIntent.getActivity(this, R.string.app_name, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        //开始构建简单消息的各个参数
        val builder = Notification.Builder(this)
        val notify = builder.setContentIntent(piClick)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.cart)
                .setSubText("这里是副本")
                .setTicker("简单消息来啦")
                .setWhen(System.currentTimeMillis())
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.apple1))
                .setContentTitle(title)
                .setContentText(message).build()
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
        notifyMgr.notify(R.string.app_name, notify)

    }

    private fun sendCounterNotify(title: String, message: String) {
        val cancelIntent = intentFor<NotifySimpleActivity>()
        val piDelete = PendingIntent.getActivity(this, R.string.app_name, cancelIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        //开始构建计时消息的各个参数
        val builder = Notification.Builder(this)
        val notify = builder.setDeleteIntent(piDelete)
                .setAutoCancel(true)
                .setUsesChronometer(true)
                .setProgress(100, 60, false)
                .setNumber(99)
                .setSmallIcon(R.drawable.ic_app)
                .setTicker("计数消息来啦")
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_app))
                .setContentTitle(title)
                .setContentText(message).build()
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
        notifyMgr.notify(R.string.app_name, notify)
    }

    private fun getStyleAndSend(title: String, message: String, type: Int) {
        var style: NotificationCompat.Style? = null
        when (type) {
            0 -> {//声明大文本风格
                style = NotificationCompat.BigTextStyle()
                style.setBigContentTitle(title)
                style.setSummaryText(message)
                style.bigText("这是一条大文字风格的通知消息")
            }
            1 -> {//声明大图片风格
                style = NotificationCompat.BigPictureStyle()
                style.setBigContentTitle(title)
                style.setSummaryText(message)
                style.bigLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.apple2))
                style.bigPicture(BitmapFactory.decodeResource(resources, R.drawable.apple1))
            }
            2 -> {//声明收件箱风格
                style = NotificationCompat.InboxStyle()
                style.setBigContentTitle(title)
                style.setSummaryText(message)
                style.addLine("天青色等烟雨，而我在等你")
                style.addLine("炊烟袅袅升起，隔江千万里")
                style.addLine("在瓶底书汉隶仿前朝的飘逸")
            }
        }
        sendLargeNotify(title, message, style)
        toast("大视图消息已推送到通知栏。")
    }

    private fun sendLargeNotify(title: String, message: String, style: NotificationCompat.Style?) {
        //声明一个“取消”按钮的动作意图
        val cancelIntent = intentFor<NotifySimpleActivity>()
        val piCancel = PendingIntent.getActivity(this, R.string.app_name, cancelIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        //声明一个“前往”按钮的动作意图
        val confirmIntent = intentFor<NotifySimpleActivity>()
        val piConfirm = PendingIntent.getActivity(this, R.string.app_name, cancelIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        //大视图通知需要通过NotificationCompat.Builder来构建
        val builder = NotificationCompat.Builder(this,"com.example.kotlin.a01startkotlin")
        val notify =builder.setSmallIcon(R.drawable.ic_app)
                .setTicker("大视图消息来啦")
                .setWhen(System.currentTimeMillis())
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_app))
                .setContentTitle(title)
                .setContentText(message)
                .setDefaults(Notification.DEFAULT_ALL)//设置大视图通知的提醒方式
                .setStyle(style)//设置大视图通知的风格类型
                .addAction(R.drawable.icon_cancel, "取消", piCancel)//添加取消按钮
                .addAction(R.drawable.icon_confirm, "前往", piConfirm)//添加前往按钮
                .build()
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

        notifyMgr.notify(R.string.app_name, notify)
    }
}
