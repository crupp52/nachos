package com.crupp52.nachos.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.crupp52.nachos.data.model.Playlist
import com.crupp52.nachos.data.repository.PlaylistRepository

class PlaylistViewModel(private val playlistRepository: PlaylistRepository) : ViewModel() {
    fun getAll(): LiveData<List<Playlist>> {
        return playlistRepository.getAll()
    }

    fun add(playlist: Playlist){
        playlistRepository.add(playlist)
    }
}