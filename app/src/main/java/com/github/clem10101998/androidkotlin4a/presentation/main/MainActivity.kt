package com.github.clem10101998.androidkotlin4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.github.clem10101998.androidkotlin4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    //Creation MainViewModel
    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    //Login Button
        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                //Popup
                is LoginSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setMessage("Known account")
                        .show()
                    val intent = Intent(this, ShowActivity::class.java)
                    startActivity(intent)
                }
                //Error
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Unknown account, please try again or create your account")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })
        login_button.setOnClickListener{
            //mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
           if (login_edit.text.toString().trim().isEmpty()){
                login_edit.error = "Login required"
                Toast.makeText(applicationContext, "Please enter your login", Toast.LENGTH_SHORT).show()
            }else if(password_edit.text.toString().trim().isEmpty()){
                password_edit.error = "Password required"
                Toast.makeText(applicationContext, "Please enter your password", Toast.LENGTH_SHORT).show()
            }else{
               mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
           }
        }
        create_account_button.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
