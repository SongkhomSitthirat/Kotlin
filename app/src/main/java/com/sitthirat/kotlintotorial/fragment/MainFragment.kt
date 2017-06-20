package com.sitthirat.kotlintotorial.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.sitthirat.kotlintotorial.R
import com.sitthirat.kotlintotorial.adapter.ListRecyclerAdapter
import com.sitthirat.kotlintotorial.model.Model
import com.sitthirat.kotlintotorial.util.ApiServices
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.Guard

/**
 * Created by prewsitthirat on 6/16/2017 AD.
 */

class MainFragment : Fragment() {

    companion object {
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            var arg = fragment.arguments
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.fragment_main, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInstance()
    }

    private fun initInstance() {

        val adapter = ListRecyclerAdapter(object: ListRecyclerAdapter.OnClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(context,"position : "+position,Toast.LENGTH_SHORT).show()
            }
        })
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recycler_main.adapter = adapter
        recycler_main.layoutManager = layoutManager

        val listItem = ApiServices.endpointInterface.getListItem()
        listItem.enqueue(object: Callback<Model.ListModel?> {
            override fun onResponse(p0: Call<Model.ListModel?>?, p1: Response<Model.ListModel?>?) {
                adapter.setListModel(p1?.body())
            }

            override fun onFailure(p0: Call<Model.ListModel?>?, p1: Throwable?) {

            }
        })
    }
}
