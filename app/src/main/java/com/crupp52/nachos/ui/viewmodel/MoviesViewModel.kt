package com.crupp52.nachos.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.crupp52.nachos.data.model.Movie
import com.crupp52.nachos.data.repository.MovieRepository

class MoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getAll(): LiveData<List<Movie>> {
        return movieRepository.getAll()
    }

    fun add(movie: Movie){
        movieRepository.add(movie)
    }
}