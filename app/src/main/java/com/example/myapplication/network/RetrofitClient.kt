package com.example.myapplication.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val retrofit =
        Retrofit.Builder().baseUrl("http://www.omdbapi.com/").addConverterFactory(
            GsonConverterFactory.create()
        ).build()
    val apiInterface = retrofit.create(MovieInterface::class.java)

    fun getMovies(
        title: String,
        pageNum: Int,
        apiKey: String,
        onDataRecieved: (ArrayList<Movie>) -> Unit
    ): ArrayList<Movie> {
        var list: ArrayList<Movie> = ArrayList()

        apiInterface.getMovies(title, pageNum, apiKey).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                list = response.body()?.SearchList ?: ArrayList()
                onDataRecieved(list)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
        return list
    }
}