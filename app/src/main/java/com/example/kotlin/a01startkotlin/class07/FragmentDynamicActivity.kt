package com.example.kotlin.a01startkotlin.class07

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.class07.adapter.MobilePagerAdapter
import com.example.kotlin.a01startkotlin.class07.bean.GoodsInfo
import kotlinx.android.synthetic.main.activity_fragment_dynamic.*

class FragmentDynamicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_dynamic)
        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        //Fragment适配器需要传入Fragment管理器对象supportFragmentManager
        vp_content.adapter = MobilePagerAdapter(supportFragmentManager, GoodsInfo.defaultList)
    }
}
