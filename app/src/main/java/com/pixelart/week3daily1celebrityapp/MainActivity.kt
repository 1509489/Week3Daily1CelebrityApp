package com.pixelart.week3daily1celebrityapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileDescriptor

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val listFragment = ListFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.flList, listFragment, "listFragment").commit()

        /*val celebrityDetailFragment = CelebrityDetailFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.flDetails, celebrityDetailFragment, "detailFragment").commit()*/

    }
}
