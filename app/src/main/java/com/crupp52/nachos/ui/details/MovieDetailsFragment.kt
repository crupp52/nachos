package com.crupp52.nachos.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieId = arguments?.getInt(getString(R.string.movie_id))
        movieId?.let {
            viewModel.getMovieDeatils(movieId).observe(this, Observer { movieDetails ->
                populateMovieDetails(movieDetails)
            })
        }
    }

    private fun populateMovieDetails(movie: Movie?) {
        textTitle.text = movie?.title
        textReleaseDate.text = movie?.releaseDate
    }
}