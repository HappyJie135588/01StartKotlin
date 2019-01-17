package com.example.kotlin.a01startkotlin.class07

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.class07.bean.GoodsInfo
import com.example.kotlin.a01startkotlin.class07.fragment.BroadcastFragment
import com.example.kotlin.a01startkotlin.class07.fragment.BroadcastPagerAdapter
import kotlinx.android.synthetic.main.activity_broad_temp.*
import org.jetbrains.anko.backgroundColor

class BroadTempActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broad_temp)
        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        vp_content.adapter = BroadcastPagerAdapter(supportFragmentManager, GoodsInfo.defaultList)
        vp_content.currentItem = 0
    }

    override fun onStart() {
        super.onStart()
        bgChangeReceiver = BgChangeReceiver()
        val filter = IntentFilter(BroadcastFragment.EVENT)
        registerReceiver(bgChangeReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(bgChangeReceiver)
    }

    private var bgChangeReceiver: BgChangeReceiver? = null

    private inner class BgChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                val color = intent.getIntExtra("color", Color.WHITE)
                ll_brd_temp.backgroundColor = color
            }
        }

    }


}
