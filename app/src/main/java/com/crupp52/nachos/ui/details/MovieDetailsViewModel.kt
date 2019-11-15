package com.crupp52.nachos.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.crupp52.nachos.NachosApplication
import com.crupp52.nachos.data.model.Movie

class MovieDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository = getApplication<NachosApplication>().getMovieRepository()
    private val movieId = MutableLiveData<Int>()

    fun getMovieDeatils(id: Int): LiveData<Movie> {
        movieId.value = id
        val movieDetails = Transformations.switchMap<Int, Movie>(movieId) { id ->
            movieRepository.find(id)
        }

        return movieDetails
    }
}