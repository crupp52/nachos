package com.crupp52.nachos.utils

import com.crupp52.nachos.data.FakeDatabase
import com.crupp52.nachos.data.repository.MovieRepository
import com.crupp52.nachos.data.repository.PlaylistRepository
import com.crupp52.nachos.ui.viewmodelFactory.MoviesViewModelFactory
import com.crupp52.nachos.ui.viewmodelFactory.PlaylistViewModelFactory

object InjectorUtils {
    fun provideMoviesViewModelFatory(): MoviesViewModelFactory {
        return MoviesViewModelFactory(
            MovieRepository.getInstance(
                FakeDatabase.getInstance().movieDao
            )
        )
    }

    fun providePlaylistViewModelFatory(): PlaylistViewModelFactory {
        return PlaylistViewModelFactory(
            PlaylistRepository.getInstance(
                FakeDatabase.getInstance().playlistDao
            )
        )
    }
}