package com.crupp52.nachos.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.crupp52.nachos.R
import com.crupp52.nachos.data.model.Movie
import com.crupp52.nachos.ui.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MoviesListFragment : Fragment(), MovieListAdapter.OnItemClickListener {

    private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_list_row, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMovieList().observe(this, Observer<List<Movie>> { movies ->
            movies?.let {
                populateMoviesList(movies)
            }
        })
    }

    override fun onItemClick(movie: Movie, itemView: View) {

    }

    private fun populateMoviesList(movieList: List<Movie>) {
        recycler_view.adapter = MovieListAdapter(movieList, this)
    }

}