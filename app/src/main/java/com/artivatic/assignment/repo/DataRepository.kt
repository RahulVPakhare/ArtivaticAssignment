package com.artivatic.assignment.repo

import com.artivatic.assignment.api.DataApi

class DataRepository(private val dataApi: DataApi) {

    suspend fun getData() = dataApi.getData()
}