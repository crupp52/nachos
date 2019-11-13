package com.crupp52.nachos.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.crupp52.nachos.R
import com.crupp52.nachos.ui.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.R
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.R
import android.widget.Toolbar
import com.crupp52.nachos.data.MovieInfoProvider.Companion.movieList
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.R
import com.crupp52.nachos.data.model.Movie
import com.crupp52.nachos.ui.list.MovieListAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var movieList: List<Movie>
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.crupp52.nachos.R.layout.activity_main)

        recyclerView = findViewById(com.crupp52.nachos.R.id.recycler_view)

        mAdapter = MovieListAdapter()
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = mAdapter
//
//        val apiService = TmdbApiService(ConnectivityInterceptorImpl(this.baseContext!!))
//        val movieDataSource = MovieNetworkDataSourceImpl(apiService)

        //movieDataSource.fetchMovies().observe(this, Observer {
        //    textView.text = it.toString()
        //})

        //val viewmodel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        //viewmodel.addMovie(Movie(10, "Teszt", "2019"))

//        val viewmodel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
//
//        val stringBuilder = StringBuilder()
//        viewmodel.getMovieList().observe(this, Observer { movies ->
//            movies.forEach { movie -> stringBuilder.append("${movie.title} (${movie.releaseDate})\n\n") }
//        })
//
//        textView.text = stringBuilder.toString()

//        GlobalScope.launch(Dispatchers.Main) {
//            //val response = apiService.getMovie(551).await()
//            //textView.text = response.toString()
//
//            movieDataSource.fetchMovies()
//        }
    }
}
