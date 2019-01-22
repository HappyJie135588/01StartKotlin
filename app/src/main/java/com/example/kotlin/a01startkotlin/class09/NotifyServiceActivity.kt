package com.example.kotlin.a01startkotlin.class09

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.class09.service.MusicService
import kotlinx.android.synthetic.main.activity_notify_service.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class NotifyServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notify_service)
        var bPlay = false
        btn_send_service.setOnClickListener {
            bPlay = !bPlay
            val intent = intentFor<MusicService>(
                    Pair("is_play", bPlay),
                    Pair("song", et_song.text.toString()))
            if (bPlay) {
                startService(intent)
                toast("歌曲${et_song.text}已在通知栏开始播放")
                btn_send_service.text = "停止播放音乐"
            } else {
                stopService(intent)
                toast("歌曲${et_song.text}已从通知栏清除")
                btn_send_service.text = "开始播放音乐"
            }
        }
    }
}
