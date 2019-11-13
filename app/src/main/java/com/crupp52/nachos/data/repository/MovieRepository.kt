package com.crupp52.nachos.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.crupp52.nachos.data.db.MovieDao
import com.crupp52.nachos.data.db.MovieDatabase
import com.crupp52.nachos.data.model.Movie

class MovieRepository(application: Application) {

    private val movieDao: MovieDao

    init {
        val movieDatabase = MovieDatabase.getInstance(application)
        movieDao = movieDatabase.movieDao()
    }

    fun getAll(): LiveData<List<Movie>> {
        return movieDao.getAll()
    }

    fun insert(movie: Movie) {
        movieDao.insert(movie)
    }

    fun delete(movie: Movie) {
        movieDao.delete(movie)
    }

    fun find(id: Int): LiveData<Movie> {
        return movieDao.find(id)
    }

    fun findByTitle(title: String): LiveData<List<Movie>> {
        return movieDao.fundByTitle(title)
    }
}