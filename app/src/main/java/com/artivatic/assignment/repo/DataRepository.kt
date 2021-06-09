package com.artivatic.assignment.repo

import com.artivatic.assignment.api.DataApi
import com.artivatic.assignment.model.Data

class DataRepository(private val dataApi: DataApi) {

    suspend fun getData(): Data {
        return dataApi.getData()
    }
}