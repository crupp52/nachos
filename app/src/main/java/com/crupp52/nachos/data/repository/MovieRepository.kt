package com.crupp52.nachos.data.repository

import android.annotation.SuppressLint
import android.content.Context
import com.crupp52.nachos.data.api.TmdbApiService
import com.crupp52.nachos.data.api.network.ConnectivityInterceptorImpl
import com.crupp52.nachos.data.db.MovieDao
import com.crupp52.nachos.data.api.network.MovieNetworkDataSource
import com.crupp52.nachos.data.api.network.MovieNetworkDataSourceImpl
import com.crupp52.nachos.data.db.MovieDatabase

class MovieRepository private constructor(
    private val context: Context
) {

    val apiService = TmdbApiService(ConnectivityInterceptorImpl(context))

    private var movieDao: MovieDao = MovieDatabase.getInstance(context)!!.movieDao()
    private var movieNetworkDataSource: MovieNetworkDataSource =
        MovieNetworkDataSourceImpl(apiService)


    fun getFavoutirtes() = movieDao.getAll()

    fun getTrending() = movieNetworkDataSource.downloadedMovie

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: MovieRepository? = null

        fun getInstance(
            context: Context
        ) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MovieRepository(context.applicationContext).also {
                    INSTANCE = it
                }
            }
    }

}