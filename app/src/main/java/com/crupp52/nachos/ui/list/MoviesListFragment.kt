package com.crupp52.nachos.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crupp52.nachos.R
import com.crupp52.nachos.data.model.Movie
import kotlinx.android.synthetic.main.fragment_movies_list.*

class MoviesListFragment : Fragment(),
    MovieListAdapter.OnItemClickListener,
    SearchView.OnQueryTextListener,
    SearchView.OnCloseListener {

    private lateinit var searchView: SearchView
    private lateinit var viewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMovieList().observe(this, Observer<List<Movie>> { movies ->
            movies?.let {
                populateMovieList(movies)
            }
        })

        addFab.setOnClickListener{
            view.findNavController().navigate(R.id.action_moviesListFragment_to_addMovieFragment2)
        }
    }

    override fun onItemClick(movie: Movie, itemView: View) {
        val movieBundle = Bundle().apply {
            putInt(getString(R.string.movie_id), movie.id)
        }
        view?.findNavController()?.navigate(R.id.action_moviesListFragment_to_movieDetailsFragment2, movieBundle)
    }

    private fun populateMovieList(peopleList: List<Movie>) {
        movieRecyclerView.adapter = MovieListAdapter(peopleList, this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        viewModel.findMovie(query!!)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    override fun onClose(): Boolean {
        viewModel.getAllMovie()
        searchView.onActionViewCollapsed()
        return true
    }

}