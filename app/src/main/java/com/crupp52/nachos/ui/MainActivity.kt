package com.crupp52.nachos.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.crupp52.nachos.R
import com.crupp52.nachos.data.api.TmdbApiService
import com.crupp52.nachos.data.network.ConnectivityInterceptorImpl
import com.crupp52.nachos.data.network.MovieNetworkDataSourceImpl
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

        movieDataSource.downloadedMovie.observe(this, Observer {
            textView.text = it.toString()
        })

        GlobalScope.launch(Dispatchers.Main) {
            //val response = apiService.getMovie(551).await()
            //textView.text = response.toString()

            movieDataSource.fetchMovies()
        }
    }
}
