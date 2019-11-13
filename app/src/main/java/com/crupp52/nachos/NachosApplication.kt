package com.crupp52.nachos

import android.app.Application
import com.crupp52.nachos.data.repository.MovieRepository

class NachosApplication : Application() {
    fun getMovieRepository() = MovieRepository(this)
}