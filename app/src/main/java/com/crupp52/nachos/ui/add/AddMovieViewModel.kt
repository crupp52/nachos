package com.crupp52.nachos.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.crupp52.nachos.NachosApplication
import com.crupp52.nachos.data.model.Movie

class AddMovieViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository = getApplication<NachosApplication>().getMovieRepository()

    fun addMovie(movie: Movie) {
        movieRepository.insert(movie)
    }

}