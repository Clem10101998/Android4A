package com.github.clem10101998.androidkotlin4a.presentation.main

import android.provider.ContactsContract

sealed class LoginStatus

data class LoginSuccess(val email: String) : LoginStatus()
object LoginError : LoginStatus()
