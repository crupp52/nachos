package com.crupp52.nachos.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.crupp52.nachos.R
import com.crupp52.nachos.data.model.Movie
import kotlinx.android.synthetic.main.fragment_movie_details.*

class MovieDetailsFragment : Fragment() {
    private lateinit var viewModel: MovieDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MovieDetailsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieId = activity?.intent?.getIntExtra(getString(R.string.movie_id), 0)
        movieId?.let { viewModel.getMovieDeatils(movieId).observe(this, Observer { movieDetails->
            populateMovieDetails(movieDetails)
        }) }
    }

    private fun populateMovieDetails(movie: Movie?) {
        textTitle.text = movie?.title
        textReleaseDate.text = movie?.releaseDate
    }
}