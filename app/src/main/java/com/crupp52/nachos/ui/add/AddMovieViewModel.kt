package com.crupp52.nachos.ui.add

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.crupp52.nachos.NachosApplication
import com.crupp52.nachos.data.model.Movie
import com.crupp52.nachos.data.network.TmdbApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class AddMovieViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository = getApplication<NachosApplication>().getMovieRepository()

    fun addMovie(movie: Movie) {
        movieRepository.insert(movie)
    }

    private val _response = MutableLiveData<List<Movie>>()

    val response: LiveData<List<Movie>>
        get() = _response

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun searchMovies(title: String) {
        coroutineScope.launch {
            var getMovies = TmdbApi.retrofitService.findByTitleAsync(title)

            try {
                var result = getMovies.await()
                _response.value = result.results
                Log.i("api", "Api call success. " + _response.value!!.size)
            } catch (t: Throwable) {
                Log.e("api", t.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}