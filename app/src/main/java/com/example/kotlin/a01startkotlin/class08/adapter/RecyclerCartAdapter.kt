package com.example.kotlin.a01startkotlin.class08.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import com.example.kotlin.a01startkotlin.MainApplication
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.class07.adapter.RecyclerBaseAdapter
import com.example.kotlin.a01startkotlin.class07.adapter.RecyclerExtras
import com.example.kotlin.a01startkotlin.class08.bean.CartInfo

import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_recycler_cart.*

class RecyclerCartAdapter(context: Context, private val carts: MutableList<CartInfo>) : RecyclerBaseAdapter<ViewHolder>(context) {

    override fun getItemCount(): Int = carts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflater.inflate(R.layout.item_recycler_cart, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vh: ItemHolder = holder as ItemHolder
        vh.bind(carts[position], itemClickListener, itemLongClickListener)
    }

    class ItemHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(item: CartInfo,
                 clickListener: RecyclerExtras.OnItemClickListener?,
                 longClickListener: RecyclerExtras.OnItemLongClickListener?) {
            iv_thumb.setImageBitmap(MainApplication.instance().mIconMap[item.goods_id])
            tv_name.text = item.goods.name
            tv_desc.text = item.goods.desc
            tv_count.text = item.count.toString()
            tv_price.text =  item.goods.price.toString()
            tv_sum.text = (item.count * item.goods.price).toString()
            // 列表项的点击事件需要自己实现
            ll_item.setOnClickListener { v ->
                clickListener?.onItemClick(v, position)
            }
            ll_item.setOnLongClickListener { v ->
                longClickListener?.onItemLongClick(v, position)
                true
            }
        }
    }

}
