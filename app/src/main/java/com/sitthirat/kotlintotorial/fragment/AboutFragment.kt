package com.sitthirat.kotlintotorial.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sitthirat.kotlintotorial.R

/**
 * Created by prewsitthirat on 6/16/2017 AD.
 */

class AboutFragment : Fragment() {

    companion object {
        fun newInstance() : AboutFragment {
            val fragment = AboutFragment()
            var arg = fragment.arguments
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.fragment_about,container,false)
        return rootView
    }
}
