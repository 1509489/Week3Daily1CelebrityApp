package com.pixelart.week3daily1celebrityapp


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_list.*
import java.util.*

class ListFragment : Fragment() {
    val TAG : String = "ListFragment"
    lateinit var celebrityList : MutableList<Celebrity>
    lateinit var adapter : ListAdapter

    override fun getContext(): Context? {
        return super.getContext()
    }

    companion object {
        fun newInstance() = ListFragment()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        initCelebrity(context!!)
        adapter = ListAdapter(context!!, R.layout.list_layout, celebrityList)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onResume() {
        super.onResume()

        lvCelebrities.adapter = adapter
        adapter.notifyDataSetChanged()


        lvCelebrities.setOnItemClickListener{ parent, view, position, id ->

            val manager = fragmentManager
            val celebrityDetailFragment = CelebrityDetailFragment.newInstance(celebrityList.get(position).name, celebrityList.get(position).description,
                celebrityList.get(position).age, celebrityList.get(position).celebrityType, celebrityList.get(position).image)
            manager!!.beginTransaction().replace(R.id.flDetails, celebrityDetailFragment, "detailFragment").commit()
        }
    }

    private fun initCelebrity(context:Context)
    {
        celebrityList = ArrayList()
        var name:String
        var description:String
        var image : String
        var type : String
        var age : Int

        val resources = context.resources
        var names = resources.getStringArray(R.array.name)
        var descriptions = resources.getStringArray(R.array.description)
        var images = resources.getStringArray(R.array.image)
        var types = resources.getStringArray(R.array.type)
        var ages = resources.getStringArray(R.array.age)

        for (i in names.indices)
        {
            name = names[i]
            description = descriptions[i]
            image = images[i]
            type = types[i]
            age = Integer.parseInt(ages[i])
            celebrityList.add((Celebrity(name, age, description, type, image)))
        }

    }
}
