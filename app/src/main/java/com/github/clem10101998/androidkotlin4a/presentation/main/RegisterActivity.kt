package com.github.clem10101998.androidkotlin4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.clem10101998.androidkotlin4a.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class RegisterActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        create_account_button.setOnClickListener {
            //mainViewModel.OnClickedCreate(login_edit.text.toString().trim(), password_edit.text.toString())
            if (login_edit.text.toString().trim().isEmpty() ){
                login_edit.error = "Login required"
                Toast.makeText(applicationContext, "Please enter your login", Toast.LENGTH_SHORT).show()
            }else if(password_edit.text.toString().trim().isEmpty()){
                password_edit.error = "Password required"
                Toast.makeText(applicationContext, "Please enter your password", Toast.LENGTH_SHORT).show()
            }else{
                mainViewModel.OnClickedCreate(login_edit.text.toString().trim(), password_edit.text.toString())
                Toast.makeText(applicationContext, "Account well created", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}