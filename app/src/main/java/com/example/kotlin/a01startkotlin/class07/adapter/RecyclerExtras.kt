package com.example.kotlin.a01startkotlin.class07.adapter

import android.view.View

class RecyclerExtras {

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(view: View, position: Int)
    }

    interface OnItemDeleteClickListener {
        fun onItemDeleteClick(view: View, position: Int)
    }

}
