package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_list.view.*


class ListAdapter(val list: List<StatewiseItem>): BaseAdapter() {
    override fun getCount(): Int =list.size

    override fun getItem(p0: Int)= list[p0]

    override fun getItemId(p0: Int)= p0.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view = convertView?:LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_list,parent,false)

        val item = list[position]

        view.confirmedTv.text = item.confirmed
        view.activeTv.text = item.active
        view.recoveredTv.text = item.recovered
        view.deathTv.text = item.deaths
        view.stateTv.text = item.state

        return view
    }
}