package com.github.clem10101998.androidkotlin4a.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.clem10101998.androidkotlin4a.R
import kotlinx.android.synthetic.main.activity_data.*

class DataActivity : AppCompatActivity() {

    private val valuesList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        WatchedList()

        recycler_view.setHasFixedSize(true)
        recycler_view.adapter = ListAdapter(valuesList)
        recycler_view.layoutManager = LinearLayoutManager(this)

    }

    private fun addElementList(values1: String){
        valuesList.add(values1)
    }

    private fun WatchedList(){
        for(i in 0 until 100){
            addElementList("Test $i")
        }
    }
}