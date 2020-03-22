package com.crupp52.nachos.ui.details

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.crupp52.nachos.R
import com.crupp52.nachos.data.model.Movie
import kotlinx.android.synthetic.main.fragment_movie_details.*

class MovieDetailsFragment : Fragment() {

    private lateinit var viewModel: MovieDetailsViewModel
    private lateinit var movie: LiveData<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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
            movie = viewModel.getMovieDeatils(movieId)
            movie.observe(this, Observer { movieDetails ->
                populateMovieDetails(movieDetails)
            })
        }


        rating.setOnRatingBarChangeListener{_, rate, _ ->
            movie.value?.userRating = rate

            //TODO: Rating mechanism
            viewModel.saveMovie(movie.value!!)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_details_movie, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_delete) {
            //Toast.makeText(this.context, movie.value?.title, Toast.LENGTH_SHORT).show()
            viewModel.deleteMovie(movie.value!!)
            view?.findNavController()?.navigate(R.id.action_movieDetailsFragment2_to_moviesListFragment)
        }

        return super.onOptionsItemSelected(item)
    }

    private fun populateMovieDetails(movie: Movie) {
        textTitle.text = movie.title
        textReleaseDate.text = movie.releaseDate
        textAdult.text = movie.adult.toString()
        textOriginalLanguage.text = movie.originalLanguage
        textVoteAverage.text = movie.voteAverage.toString()
        textPopularity.text = movie.popularity.toString()
        rating.rating = movie.userRating
    }
}