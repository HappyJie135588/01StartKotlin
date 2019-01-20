package com.example.kotlin.a01startkotlin.class07

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.class07.adapter.PlanetListAdapter
import com.example.kotlin.a01startkotlin.class07.bean.Planet
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val adapter = PlanetListAdapter(this, Planet.defaultList, Color.WHITE)
        lv_planet.adapter = adapter
        lv_planet.onItemClickListener = adapter
        lv_planet.onItemLongClickListener = adapter
    }
}
