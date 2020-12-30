package com.github.clem10101998.androidkotlin4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.clem10101998.androidkotlin4a.R
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        button.setOnClickListener(){
            val intent = Intent(this, DataActivity::class.java)
            startActivity(intent)
        }
    }
}