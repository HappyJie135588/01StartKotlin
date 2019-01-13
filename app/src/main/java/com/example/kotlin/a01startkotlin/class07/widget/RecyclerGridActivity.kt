package com.example.kotlin.a01startkotlin.class07.widget

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import com.example.complex.adapter.RecyclerGridAdapter
import com.example.complex.widget.SpacesItemDecoration
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.class07.bean.RecyclerInfo
import kotlinx.android.synthetic.main.activity_recycler_grid.*

class RecyclerGridActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_grid)

        rv_grid.layoutManager = GridLayoutManager(this, 5)
        val adapter = RecyclerGridAdapter(this, RecyclerInfo.defaultGrid)
        adapter.setOnItemClickListener(adapter)
        adapter.setOnItemLongClickListener(adapter)
        rv_grid.adapter = adapter
        rv_grid.itemAnimator = DefaultItemAnimator()
        rv_grid.addItemDecoration(SpacesItemDecoration(1))
    }
}
