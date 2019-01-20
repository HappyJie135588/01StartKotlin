package com.example.kotlin.a01startkotlin.class07.materialdesign

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.class07.adapter.RecyclerCommonAdapter
import com.example.kotlin.a01startkotlin.class07.bean.LifeItem
import kotlinx.android.synthetic.main.activity_scroll_alipay.*
import kotlinx.android.synthetic.main.life_pay.*
import kotlinx.android.synthetic.main.toolbar_collapse.*
import kotlinx.android.synthetic.main.toolbar_expand.*
import org.jetbrains.anko.backgroundColor

class ScrollAlipayActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {
    val TAG = "ScrollAlipayActivity"
    private var mMaskColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_alipay)
        rv_content.layoutManager = GridLayoutManager(this, 4)
        mMaskColor = resources.getColor(R.color.blue_dark)
        //给控件abl_bar注册一个位置偏移的监听器
        abl_bar.addOnOffsetChangedListener(this)

        //第一种方式：使用采取了LayoutContainer的适配器
        //rv_content.adapter = RecyclerLifeAdapter(this, LifeItem.default)
        //第二种方式：使用把三类可变要素抽象出来的适配器
        rv_content.adapter = RecyclerCommonAdapter(this, R.layout.item_life, LifeItem.default,
                { view, item ->
                    val iv_pic = view.findViewById<ImageView>(R.id.iv_pic)
                    val tv_title = view.findViewById<TextView>(R.id.tv_title)
                    iv_pic.setImageResource(item.pic_id)
                    tv_title.text = item.title
                })
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
        val offset = Math.abs(verticalOffset)
        val total = appBarLayout.totalScrollRange

        var alpha = 1f * offset / total
        var alphaIn = 255 * alpha
        val alphaInOut = (0.5 - Math.abs(alpha - 0.5)) * 2 * 255
        Log.d(TAG, "offset:${offset}    total:${total}  alpha:${alpha}  alphaIn${alphaIn}   alphaInOut${alphaInOut}")
        val maskColorIn = Color.argb(alphaIn.toInt(), Color.red(mMaskColor), Color.green(mMaskColor), Color.blue(mMaskColor))
        val maskColorInOut = Color.argb(alphaInOut.toInt(), Color.red(mMaskColor), Color.green(mMaskColor), Color.blue(mMaskColor))
        v_pay_mask.backgroundColor = maskColorIn
        v_expand_mask.backgroundColor = maskColorInOut
        v_collapse_mask.backgroundColor = maskColorInOut
        if (alpha - 0.5f < 0) {
            tl_expand.visibility = View.VISIBLE
            tl_collapse.visibility = View.GONE
        } else {
            tl_expand.visibility = View.GONE
            tl_collapse.visibility = View.VISIBLE
        }


    }
}
