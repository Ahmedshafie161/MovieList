package com.example.myapplication.network

import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @SerializedName("Search") var SearchList: ArrayList<Movie> = arrayListOf(),
    @SerializedName("totalResults") var totalResults: String? = null,
    @SerializedName("Response") var Response: String? = null
)