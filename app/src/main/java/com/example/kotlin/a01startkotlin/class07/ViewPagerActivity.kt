package com.example.kotlin.a01startkotlin.class07

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.TypedValue
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.class07.adapter.ImagePagerAdapter
import com.example.kotlin.a01startkotlin.class07.bean.GoodsInfo
import kotlinx.android.synthetic.main.activity_view_pager.*
import org.jetbrains.anko.toast

class ViewPagerActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {
    private var goodsList = GoodsInfo.defaultList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        //注意PagerTabStrip不存在textSize属性，只能调用setTextSize方法设置文字大小
        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        pts_tab.setTextColor(Color.GREEN)
        vp_content.adapter = ImagePagerAdapter(this, goodsList)
        vp_content.currentItem = 0
        vp_content.addOnPageChangeListener(this)

    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    //在页面切换结束（即滑动停止）时触发该方法
    override fun onPageSelected(position: Int) {
        toast("你翻到的手机品牌是:${goodsList[position].name}")
    }
}
