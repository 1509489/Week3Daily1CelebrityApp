package com.pixelart.week3daily1celebrityapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListAdapter(var applicationContext : Context, resource : Int, var celebrityList : List<Celebrity>) :
    ArrayAdapter<Celebrity>(applicationContext, resource, celebrityList)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val celebrity = celebrityList[position]
        val result = setUpViewHolder()
        val viewHolder : ViewHolder = convertView?.let { it.tag as ViewHolder } ?: result.first
        viewHolder.tvName.text = celebrity.name

        return convertView ?: result.second
    }

    private fun setUpConvertView() = LayoutInflater.from(applicationContext).inflate(R.layout.list_layout, null)

    private fun setUpViewHolder(): Pair<ViewHolder, View>
    {
        val viewHolder = ViewHolder()
        val convertView = setUpConvertView()
        viewHolder.tvName = convertView.findViewById(R.id.tvName)
        convertView.tag = viewHolder
        return Pair(viewHolder, convertView)
    }

    class ViewHolder
    {
        lateinit var tvName : TextView
    }
}