package com.crupp52.nachos.data.api.network

import androidx.lifecycle.LiveData
import com.crupp52.nachos.data.api.network.response.MovieCollectionResponse

interface MovieNetworkDataSource {
    val downloadedMovie: LiveData<MovieCollectionResponse>

    suspend fun fetchMovies()
}