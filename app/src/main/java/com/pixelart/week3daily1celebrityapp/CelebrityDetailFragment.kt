package com.pixelart.week3daily1celebrityapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_celebrity_detail.*

class CelebrityDetailFragment : Fragment() {
    val TAG : String = "DetailActivity"

    lateinit var celebrity: Celebrity
    lateinit var celebrityName:String
    lateinit var celebrityDescription : String
    var celebrityAge : Int = 0
    lateinit var celebrityType : String
    lateinit var celebrityImage : String

    companion object {
        /*fun newInstance(name : String, description : String, age : Int, type : String, image : String) : CelebrityDetailFragment
        {
            val detailFragment = CelebrityDetailFragment()
            val args = Bundle()
            args.putString("name", name)
            args.putString("description", description)
            args.putInt("age", age)
            args.putString("type", type)
            args.putString("image", image)
            detailFragment.arguments = args
            return detailFragment
        }*/

        fun newInstance(celebrity : Celebrity): CelebrityDetailFragment {
            val detailFragment = CelebrityDetailFragment()
            val args = Bundle()
            args.putParcelable("celebrity", celebrity)
            detailFragment.arguments = args
            return detailFragment
        }
        fun newInstance() = CelebrityDetailFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            /*celebrityName = it.getString("name")
            celebrityDescription = it.getString("description")
            celebrityAge = it.getInt("age")
            celebrityType = it.getString("type")
            celebrityImage = it.getString("image")*/

            celebrity = it.getParcelable("celebrity")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_celebrity_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        var imageId : Int = resources.getIdentifier(celebrityImage, "drawable", context!!.getPackageName())

        var imageId : Int = resources.getIdentifier(celebrity.image, "drawable", context!!.getPackageName())

        /*tvName.text = celebrityName
        tvAge.text = celebrityAge.toString()
        tvCelebrityType.text = celebrityType
        tvDescription.text = celebrityDescription
        imageView.setImageResource(imageId)*/

        tvName.text = celebrity.name
        tvAge.text = celebrity.age.toString()
        tvCelebrityType.text = celebrity.celebrityType
        tvDescription.text = celebrity.description
        imageView.setImageResource(imageId)
    }


}
