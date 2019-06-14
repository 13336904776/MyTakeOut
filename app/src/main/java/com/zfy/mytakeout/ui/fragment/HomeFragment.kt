package com.zfy.mytakeout.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zfy.mytakeout.R
import com.zfy.mytakeout.ui.adapter.HomeAdapter

/**
 *
 */
class HomeFragment:Fragment(){
    lateinit var homeAdapter:HomeAdapter
    lateinit var rvHome:RecyclerView
    val list = ArrayList<String>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(context, R.layout.fragment_home, null)
        rvHome = view.findViewById<RecyclerView>(R.id.rv_home)
        rvHome.layoutManager = LinearLayoutManager(context)
        homeAdapter = HomeAdapter(context)
        rvHome.adapter = homeAdapter
        initData()
        homeAdapter.setData(list)
        return view
    }

    private fun initData() {
        for (i in 0 .. 20){
            list.add("我是第{$i}个")
        }
    }
}
