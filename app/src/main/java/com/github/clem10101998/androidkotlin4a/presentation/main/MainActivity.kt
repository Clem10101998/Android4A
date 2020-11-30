package com.github.clem10101998.androidkotlin4a.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.github.clem10101998.androidkotlin4a.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    //Creation MainViewModel
    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_button.setOnClickListener{
            mainViewModel.onClickedIncrement("")
        }
        mainViewModel.counter.observe(this, Observer {
                value -> main_text.text = value.toString()

        })
        //mainViewModel.onStart()
    }
}
