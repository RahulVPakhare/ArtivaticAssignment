package com.artivatic.assignment.api

class DataApi(private val retrofitApi: RetrofitApi) {

    suspend fun getData() = retrofitApi.getData()
}