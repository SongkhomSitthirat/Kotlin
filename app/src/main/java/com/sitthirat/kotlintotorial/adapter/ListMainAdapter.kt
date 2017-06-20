package com.sitthirat.kotlintotorial.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.sitthirat.kotlintotorial.R
import com.sitthirat.kotlintotorial.model.Model
import kotlinx.android.synthetic.main.item_list_view_main.*
import kotlinx.android.synthetic.main.item_list_view_main.view.*

/**
 * Created by prewsitthirat on 6/16/2017 AD.
 */

class ListMainAdapter(var context :Context) : BaseAdapter() {

    var menuModel: Model.MenuModel? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rootView = LayoutInflater.from(context).inflate(R.layout.item_list_view_main,parent,false)
        rootView.tv_item_main_menu?.setText(menuModel?.menuName?.get(position))
        return rootView
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount() = menuModel?.menuName?.size ?: 0

    fun setModel(model: Model.MenuModel) {
        menuModel = model
        notifyDataSetChanged()
    }
}
