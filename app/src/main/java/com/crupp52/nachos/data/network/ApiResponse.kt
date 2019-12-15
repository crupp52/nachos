package com.crupp52.nachos.data.network


import com.crupp52.nachos.data.model.Movie
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("results")
    val results: List<Movie>
)