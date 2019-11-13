package com.crupp52.nachos.data

import com.crupp52.nachos.data.model.Movie

class MovieInfoProvider {
    companion object {
        var movieList = initMovieList()

        private fun initMovieList(): MutableList<Movie> {
            movieList = mutableListOf<Movie>()

            movieList.add(Movie(1, "Batman", "2019"))
            movieList.add(Movie(2, "Fast and Furious 21", "2030"))
            movieList.add(Movie(3, "Frozen 2", "2019"))
            movieList.add(Movie(4, "Find Nemo", "2003"))

            return movieList
        }
    }
}