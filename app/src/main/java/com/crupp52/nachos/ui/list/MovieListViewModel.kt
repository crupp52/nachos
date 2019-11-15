package com.crupp52.nachos.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.crupp52.nachos.NachosApplication
import com.crupp52.nachos.data.model.Movie

class MovieListViewModel(application: Application) : AndroidViewModel(application) {

    private val movieRepository = getApplication<NachosApplication>().getMovieRepository()
    private val movieList = MediatorLiveData<List<Movie>>()

    init {
        getAllMovie()
    }

    fun getMovieList(): LiveData<List<Movie>> {
        return movieList
    }

    fun getAllMovie() {
        movieList.addSource(movieRepository.getAll()) { movies ->
            movieList.postValue(movies)
        }
    }

    fun findMovie(title: String) {
        movieList.addSource(movieRepository.findByTitle(title)) { movies ->
            movieList.postValue(movies)
        }
    }
}