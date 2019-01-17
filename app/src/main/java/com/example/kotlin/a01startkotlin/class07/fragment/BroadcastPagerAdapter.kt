package com.example.kotlin.a01startkotlin.class07.fragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

import com.example.kotlin.a01startkotlin.class07.bean.GoodsInfo

class BroadcastPagerAdapter(fm: FragmentManager, private val goodsList: MutableList<GoodsInfo>) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = goodsList.size

    override fun getItem(position: Int): Fragment {
        return BroadcastFragment.newInstance(position,
                goodsList[position].pic, goodsList[position].desc)
    }

    override fun getPageTitle(position: Int): CharSequence = goodsList[position].name

}

