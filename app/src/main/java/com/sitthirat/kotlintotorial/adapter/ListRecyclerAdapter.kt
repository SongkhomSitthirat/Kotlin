package com.sitthirat.kotlintotorial.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.sitthirat.kotlintotorial.R
import com.sitthirat.kotlintotorial.model.Model
import kotlinx.android.synthetic.main.holder_list.view.*

/**
 * Created by Prew on 6/19/2017.
 */
class ListRecyclerAdapter(listener: OnClickListener) : RecyclerView.Adapter<ListRecyclerAdapter.ViewHolder>() {

    var mListModel:Model.ListModel? = null

    val mListener = listener

    interface OnClickListener {
        fun onItemClick(position: Int)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindView()
    }

    override fun getItemCount(): Int {
        return mListModel?.datas?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.holder_list,parent,false))
    }

    fun setListModel(listModel: Model.ListModel?) {
        mListModel = listModel
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView() {
            itemView.setOnClickListener(View.OnClickListener { mListener.onItemClick(adapterPosition) })
            itemView.tv_holder_main?.setText(mListModel?.datas?.get(adapterPosition)?.caption)
            Glide.with(itemView.context).load(mListModel?.datas?.get(adapterPosition)?.imgUrl).into(itemView.iv_holder_main)
        }
    }
}