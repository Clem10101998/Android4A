package com.github.clem10101998.androidkotlin4a.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.clem10101998.androidkotlin4a.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.widget.Toast


class DataActivity : AppCompatActivity() {

    //private val valuesList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        makeApiCall()
        // WatchedList()

        /* recycler_view.setHasFixedSize(true)
         recycler_view.adapter = ListAdapter(valuesList)
         recycler_view.layoutManager = LinearLayoutManager(this)*/

    }
    private fun showList(values: List<Donnees>){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@DataActivity)
            adapter = ListAdapter(values)
        }
    }

    private fun makeApiCall(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)
        api.AllMovies().enqueue(object : Callback<List<Donnees>>{
            override fun onResponse(call: Call<List<Donnees>>, response: Response<List<Donnees>>) {
                showList(response.body()!!)
                //Toast.makeText(getApplicationContext(), "API Success", Toast.LENGTH_SHORT).show()
            }
            override fun onFailure(call: Call<List<Donnees>>, t: Throwable) {
                //Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
    /*private fun addElementList(values1: String){
        valuesList.add(values1)
    }

    private fun WatchedList(){
        for(i in 0 until 100){
            addElementList("Test $i")
        }*/
}
