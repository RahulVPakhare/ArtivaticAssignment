package com.artivatic.assignment.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val builder = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: RetrofitApi = builder.create(RetrofitApi::class.java)
}