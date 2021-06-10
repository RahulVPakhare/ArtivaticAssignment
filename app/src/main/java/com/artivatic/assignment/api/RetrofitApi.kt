package com.artivatic.assignment.api

import com.artivatic.assignment.model.Data
import retrofit2.http.GET

interface RetrofitApi {

    @GET("c4ab4c1c-9a55-4174-9ed2-cbbe0738eedf")
    suspend fun getData(): Data
}