package com.crupp52.nachos.data.network

import androidx.lifecycle.LiveData
import com.crupp52.nachos.data.network.response.MovieCollectionResponse

interface MovieNetworkDataSource {
    val downloadedMovie: LiveData<MovieCollectionResponse>

    suspend fun fetchMovies()
}