package com.sitthirat.kotlintotorial.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sitthirat.kotlintotorial.R
import com.sitthirat.kotlintotorial.adapter.ListMainAdapter
import com.sitthirat.kotlintotorial.fragment.AboutFragment
import com.sitthirat.kotlintotorial.fragment.MainFragment
import com.sitthirat.kotlintotorial.model.Model
import com.sitthirat.kotlintotorial.util.Contextor
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_main.*
import kotlinx.android.synthetic.main.toolbar_main.*

class MainActivity : AppCompatActivity() {

    var menuModel = Model.MenuModel(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInstance()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.content_container, MainFragment.newInstance())
                    .commit()
        }
    }

    private fun initInstance() {

        val listMenu = listOf<String>("Home", "About", "Exit")
        menuModel = Model.MenuModel(listMenu)

        val adapter = ListMainAdapter(applicationContext)
        lv_drawer_main.setAdapter(adapter)
        lv_drawer_main.setOnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.content_container, MainFragment.newInstance())
                        .commit()
                drawer_main.closeDrawer(drawer_main_layout)
            }
            if (position == 1) {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.content_container, AboutFragment.newInstance())
                        .commit()
                Toast.makeText(Contextor.context,"Second Fragment",Toast.LENGTH_SHORT).show()
                drawer_main.closeDrawer(drawer_main_layout)
            }
            if (position == 2) {
                finishAffinity()
            }
        }
        adapter.setModel(menuModel)

        iv_toolbar_main.setOnClickListener(View.OnClickListener {
            drawer_main.openDrawer(drawer_main_layout)
        })
    }

    override fun onBackPressed() {

        if (drawer_main.isDrawerOpen(drawer_main_layout)) {
            drawer_main.closeDrawer(drawer_main_layout)
        } else {
            super.onBackPressed()
        }
    }
}
