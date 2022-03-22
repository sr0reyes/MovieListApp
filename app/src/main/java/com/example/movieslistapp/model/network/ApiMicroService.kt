package com.example.movieslistapp.model.network

import retrofit2.http.*

interface ApiMicroService {

    @GET("list/1")
    suspend fun GetData(
        @Query("api_key") api_key: String
    ): MovieListResponse

}