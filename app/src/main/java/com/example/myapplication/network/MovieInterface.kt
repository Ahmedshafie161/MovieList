package com.example.myapplication.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {
    @GET("/")
    fun getMovies(
        @Query("s") s: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String
    ): Call<MovieResponse>
}