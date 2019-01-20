package com.example.kotlin.a01startkotlin.class07.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.kotlin.a01startkotlin.class07.bean.GoodsInfo
import org.jetbrains.anko.imageResource

//在主构造函数中声明与入参同名的属性及其初始赋值操作
class ImagePagerAdapter(private val context: Context, private val goodsList: MutableList<GoodsInfo>) : PagerAdapter() {
    private val views = mutableListOf<ImageView>()

    //初始化函数进行开发者额外的初始操作
    init {
        for (item in goodsList) {
            val view = ImageView(context)
            view.layoutParams = ViewGroup.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT)
            view.imageResource = item.pic
            view.scaleType = ImageView.ScaleType.FIT_CENTER
            views.add(view)
        }
    }

    //获取页面数量，使用了简化函数
    override fun getCount(): Int = goodsList.size

    //判断指定页面是否已加入适配器，注意这里用到了引用相等
    override fun isViewFromObject(view: View, `object`: Any): Boolean = view === `object`

    //回收页面
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(views[position])
    }

    //实例化每个页面
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(views[position])
        return views[position]
    }

    //获得页面的标题，要跟PagerTabStrip配合使用
    override fun getPageTitle(position: Int): CharSequence? = goodsList[position].name
}