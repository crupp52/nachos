package com.crupp52.nachos.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.crupp52.nachos.data.db.MovieDao
import com.crupp52.nachos.data.db.MovieDatabase
import com.crupp52.nachos.data.model.Movie

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val selected: MutableLiveData<Movie> = MutableLiveData()
    private var movieList: LiveData<List<Movie>>? = null

    private var movieDao: MovieDao = MovieDatabase.getInstance(getApplication())!!.movieDao()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        movieList = movieDao.getAll()
    }

    fun addMovie(movie: Movie) {
        movieDao.upsert(movie)
    }

    fun getMovies(): LiveData<List<Movie>>? {
        return movieList
    }

    fun onItemClick(movie: Movie) {
        selected.value = movie
        selected.postValue(null)
    }

    fun getSelectedMovie(): LiveData<Movie> {
        return selected
    }
}