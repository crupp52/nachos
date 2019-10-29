package com.crupp52.nachos.data.repository

import androidx.lifecycle.LiveData
import com.crupp52.nachos.data.dao.FakeMovieDao
import com.crupp52.nachos.data.model.Movie

class FakeMovieRepository private constructor(private val movieDao: FakeMovieDao) {
    fun add(movie: Movie){
        movieDao.add(movie)
    }

    fun getAll(): LiveData<List<Movie>> {
        return movieDao.getAll()
    }

    companion object {
        @Volatile
        private var instance: FakeMovieRepository? = null

        fun getInstance(movieDao: FakeMovieDao) = instance ?: synchronized(this) {
            instance ?: FakeMovieRepository(movieDao).also { instance = it }
        }
    }
}