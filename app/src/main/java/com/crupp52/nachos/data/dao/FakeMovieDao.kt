package com.crupp52.nachos.data.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.crupp52.nachos.data.model.Movie

class FakeMovieDao {
    private val moviesList = mutableListOf<Movie>()
    private val movies = MutableLiveData<List<Movie>>()

    init {
        movies.value = moviesList
    }

    fun add(movie: Movie){
        moviesList.add(movie)
        movies.value = moviesList
    }

    fun getAll(): LiveData<List<Movie>> {
        return movies
    }
}