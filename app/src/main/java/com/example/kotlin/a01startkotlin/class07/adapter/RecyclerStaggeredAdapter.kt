package com.example.kotlin.a01startkotlin.class07.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.class07.bean.RecyclerInfo
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_recycler_staggered.*
import org.jetbrains.anko.imageResource

class RecyclerStaggeredAdapter(context: Context, private val infos: MutableList<RecyclerInfo>) : RecyclerBaseAdapter<RecyclerView.ViewHolder>(context) {
    override fun getItemCount(): Int = infos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = inflater.inflate(R.layout.item_recycler_staggered, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemHolder).bind(infos[position])
    }

    class ItemHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(item: RecyclerInfo) {
            iv_pic.imageResource = item.pic_id
            tv_title.text = item.title
        }
    }
}