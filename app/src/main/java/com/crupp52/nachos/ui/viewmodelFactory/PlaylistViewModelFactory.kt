package com.crupp52.nachos.ui.viewmodelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.crupp52.nachos.data.repository.PlaylistRepository
import com.crupp52.nachos.ui.viewmodel.PlaylistViewModel

class PlaylistViewModelFactory(private val playlistRepository: PlaylistRepository):ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlaylistViewModel(playlistRepository) as T
    }
}