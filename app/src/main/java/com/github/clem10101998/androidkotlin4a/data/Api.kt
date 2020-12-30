package com.github.clem10101998.androidkotlin4a.data

import com.github.clem10101998.androidkotlin4a.data.local.models.Donnees
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("films")
    fun AllMovies(): Call<List<Donnees>>
}