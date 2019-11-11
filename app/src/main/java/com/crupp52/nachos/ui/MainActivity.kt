package com.crupp52.nachos.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.crupp52.nachos.R
import com.crupp52.nachos.data.api.TmdbApiService
import com.crupp52.nachos.data.db.MovieDatabase
import com.crupp52.nachos.data.api.network.ConnectivityInterceptorImpl
import com.crupp52.nachos.data.api.network.MovieNetworkDataSourceImpl
import com.crupp52.nachos.data.db.entity.Movie
import com.crupp52.nachos.data.repository.MovieRepository
import com.crupp52.nachos.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = TmdbApiService(ConnectivityInterceptorImpl(this.baseContext!!))
        val movieDataSource = MovieNetworkDataSourceImpl(apiService)

        //movieDataSource.fetchMovies().observe(this, Observer {
        //    textView.text = it.toString()
        //})

        val viewmodel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        //viewmodel.addMovie(Movie(10, "Teszt", "2019"))

        val stringBuilder = StringBuilder()
        viewmodel.getMovies()?.observe(this, Observer { movies ->
            movies.forEach { movie -> stringBuilder.append("${movie.title} (${movie.releaseDate})\n\n") }
        })

        textView.text = stringBuilder.toString()

        GlobalScope.launch(Dispatchers.Main) {
            //val response = apiService.getMovie(551).await()
            //textView.text = response.toString()

            movieDataSource.fetchMovies()
        }
    }
}
