package com.github.clem10101998.androidkotlin4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.clem10101998.androidkotlin4a.domain.entity.User
import com.github.clem10101998.androidkotlin4a.domain.usecase.CreateUserUseCase
import com.github.clem10101998.androidkotlin4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){
    //val -> ne change pas
    //val text: MutableLiveData<String> = MutableLiveData()
    val counter: MutableLiveData<Int> = MutableLiveData()

    init{
        //text.value = "Texte LiveData"
        counter.value = 0
    }
    //fun onStart(){}
    fun onClickedIncrement(emailUser: String) {
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User("test"))
            val user = getUserUseCase.invoke("test")
            val debug = "debug"
        }

        //counter.value = (counter.value ?: 0) + 1
    }

}
