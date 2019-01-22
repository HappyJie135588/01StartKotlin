package com.example.kotlin.a01startkotlin.class09.service

import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.*
import android.widget.RemoteViews
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.class09.NotifyServiceActivity
import org.jetbrains.anko.intentFor

class MusicService : Service() {
    inner class LocalBinder : Binder() {
        val service: MusicService
            get() = this@MusicService
    }

    private val mBinder = LocalBinder()


    override fun onBind(intent: Intent): IBinder = mBinder

    private var mSong: String = ""
    private var PAUSE_EVENT = ""
    private var isPlay = true
    private var mBaseTime: Long = 0
    private var mPauseTime: Long = 0
    private var mProgress = 0
    private val handler = Handler()
    private lateinit var notify: Notification

    private val playTask = object : Runnable {
        override fun run() {
            if (isPlay) {
                if (mProgress < 100) {
                    mProgress += 2
                } else {
                    mProgress = 0
                }
                handler.postDelayed(this, 1000)
            }
            notify = getNotify(this@MusicService, PAUSE_EVENT, mSong, isPlay, mProgress, mBaseTime)
            startForeground(2, notify)
        }
    }

    private fun getNotify(ctx: Context, event: String, song: String, isPlay: Boolean, progress: Int, time: Long): Notification {
        val pIntent = Intent(event)
        val nIntent = PendingIntent.getBroadcast(ctx, R.string.app_name, pIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        val notify_music = RemoteViews(ctx.packageName, R.layout.notify_music)
        if (isPlay) {
            notify_music.setTextViewText(R.id.btn_play, "暂停")
            notify_music.setTextViewText(R.id.tv_play, song + "正在播放")
            notify_music.setChronometer(R.id.chr_play, time, "%s", true)
        } else {
            notify_music.setTextViewText(R.id.btn_play, "继续")
            notify_music.setTextViewText(R.id.tv_play, song + "暂停播放")
            notify_music.setChronometer(R.id.chr_play, time, "%s", false)
        }
        notify_music.setProgressBar(R.id.pb_play, 100, progress, false)
        notify_music.setOnClickPendingIntent(R.id.btn_play, nIntent)
        val intent = ctx.intentFor<NotifyServiceActivity>()
        val cIntent = PendingIntent.getActivity(ctx, R.string.app_name, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = Notification.Builder(ctx)
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
        return builder.setContentIntent(cIntent)
                .setContent(notify_music) //采用自定义的通知布局
                .setTicker(song)
                .setSmallIcon(R.drawable.tt_s).build()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        mBaseTime = SystemClock.elapsedRealtime()
        isPlay = intent.getBooleanExtra("is_play", true)
        mSong = intent.getStringExtra("song")
        handler.postDelayed(playTask, 200)
        return Service.START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        PAUSE_EVENT = resources.getString(R.string.pause_event)
        pauseReceiver = PauseReceiver()
        registerReceiver(pauseReceiver, IntentFilter(PAUSE_EVENT))
    }

    override fun onDestroy() {
        unregisterReceiver(pauseReceiver)
        if (notify != null) {
            stopForeground(true)
        }
        super.onDestroy()
    }

    private var pauseReceiver: PauseReceiver? = null

    inner class PauseReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                isPlay = !isPlay
                if (isPlay) {
                    handler.postDelayed(playTask, 200)
                    if (mPauseTime > 0) {
                        val gap = SystemClock.elapsedRealtime() - mPauseTime
                        mBaseTime += gap
                    }
                } else {
                    mPauseTime = SystemClock.elapsedRealtime()
                }
            }
        }
    }
}
