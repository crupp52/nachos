package com.crupp52.nachos.ui.viewmodelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.crupp52.nachos.data.repository.MovieRepository
import com.crupp52.nachos.ui.viewmodel.MoviesViewModel

class MoviesViewModelFactory(private val movieRepository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(movieRepository) as T
    }
}