package com.crupp52.nachos.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.crupp52.nachos.data.api.TmdbApiService
import com.crupp52.nachos.data.network.response.MovieCollectionResponse
import com.crupp52.nachos.internal.NoConnectivityException

class MovieNetworkDataSourceImpl(
    private val tmdbApiService: TmdbApiService
) : MovieNetworkDataSource {

    private val _downloadedMovieCollection = MutableLiveData<MovieCollectionResponse>()

    override val downloadedMovie: LiveData<MovieCollectionResponse>
        get() = _downloadedMovieCollection

    override suspend fun fetchMovies() {
        try {
            val fetchedMovieCollection = tmdbApiService.getTrending().await()
            _downloadedMovieCollection.postValue(fetchedMovieCollection)
        }

        catch (e: NoConnectivityException){
            Log.e("Connectivity", "No internet connection.", e)
        }
    }
}