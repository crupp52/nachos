package com.crupp52.nachos.ui.add

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.crupp52.nachos.R
import com.crupp52.nachos.data.model.Movie
import com.crupp52.nachos.ui.list.MovieListAdapter
import kotlinx.android.synthetic.main.fragment_add_movie.*
import kotlinx.android.synthetic.main.fragment_movies_list.*

class AddMovieFragment : Fragment(),
    MovieListAdapter.OnItemClickListener {

    private lateinit var viewModel: AddMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = ViewModelProviders.of(this).get(AddMovieViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        search_button.setOnClickListener {
            viewModel.searchMovies(search_movie_title.text.toString())
        }

        viewModel.response.observe(this, Observer { movies ->
            movies?.let {
                populateMovieList(movies)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_movie, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_add_movie, menu)
    }

    private fun populateMovieList(movies: List<Movie>) {
        searchMovieRecyclerView.adapter = MovieListAdapter(movies, this)
    }

    override fun onItemClick(movie: Movie, itemView: View) {
        viewModel.addMovie(movie)
    }
}