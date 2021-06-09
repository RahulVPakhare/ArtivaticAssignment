package com.artivatic.assignment.api

import com.artivatic.assignment.model.Data

interface DataApi {

    suspend fun getData(): Data
}