package com.crupp52.nachos.ui.add

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.crupp52.nachos.R
import com.crupp52.nachos.data.model.Movie
import com.crupp52.nachos.ui.list.MovieListAdapter
import kotlinx.android.synthetic.main.fragment_add_movie.*
import kotlinx.android.synthetic.main.fragment_movie_details.*

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

        search_movie_title.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.searchMovies(search_movie_title.text.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

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

    private fun populateMovieList(movies: List<Movie>) {
        searchMovieRecyclerView.adapter = MovieListAdapter(movies, this)
    }

    override fun onItemClick(movie: Movie, itemView: View) {
        viewModel.addMovie(movie)
    }
}