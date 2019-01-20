package com.example.kotlin.a01startkotlin.class07

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.class07.adapter.PlanetGridAdapter
import com.example.kotlin.a01startkotlin.class07.bean.Planet
import kotlinx.android.synthetic.main.activity_grid_view.*

class GridViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        val adapter = PlanetGridAdapter(this,Planet.defaultList, Color.WHITE)
        gv_planet.adapter = adapter
        gv_planet.onItemClickListener=adapter
        gv_planet.onItemLongClickListener=adapter
    }
}
