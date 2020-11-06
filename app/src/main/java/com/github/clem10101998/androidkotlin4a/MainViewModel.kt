package com.github.clem10101998.androidkotlin4a

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    //val -> ne change pas
    val text: MutableLiveData<String> = MutableLiveData()
    val counter: MutableLiveData<Int> = MutableLiveData()

    init{
    text.value = "Texte LiveData"
        counter.value = 0
    }
    //fun onStart(){}
    fun onClickedIncrement() {
    counter.value = (counter.value ?: 0) + 1
    }

}