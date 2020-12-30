package com.github.clem10101998.androidkotlin4a.presentation.main

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.clem10101998.androidkotlin4a.domain.entity.User
import com.github.clem10101998.androidkotlin4a.domain.usecase.CreateUserUseCase
import com.github.clem10101998.androidkotlin4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){
    //val -> ne change pas
    //val text: MutableLiveData<String> = MutableLiveData()
    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    //fun onStart(){}
    //Login -> Appel base de données : Success ou Error
    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser, password)
            //createUserUseCase.invoke(User("test"))
            //val user = getUserUseCase.invoke("test")
            //val debug = "debug"
            val loginStatus = if(user != null){
                LoginSuccess(user.email)

            }else{
                LoginError
            }
            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }
        }
    }
    fun OnClickedCreate(emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
                createUserUseCase.invoke(User(emailUser, password))
                //createUserUseCase.invoke(User("test"))
                //val user = getUserUseCase.invoke("test")
                //val debug = "debug"
            }
        }
    }
