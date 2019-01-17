package com.example.kotlin.a01startkotlin.class07.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.kotlin.a01startkotlin.class07.bean.GoodsInfo
import com.example.kotlin.a01startkotlin.class07.fragment.DynamicFragment

class MobilePagerAdapter(fm: FragmentManager, private val goodsList: MutableList<GoodsInfo>) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = goodsList.size

    //获取每个页面的碎片对象
    override fun getItem(position: Int): Fragment {
        val item = goodsList[position]
        return DynamicFragment.newInstance(position, item.pic, item.desc, item.price)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return goodsList[position].name
    }
}