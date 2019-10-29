package com.crupp52.nachos.data.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.crupp52.nachos.data.model.Playlist

class FakePlaylistDao {
    private val playlistList = mutableListOf<Playlist>()
    private val playlists = MutableLiveData<List<Playlist>>()

    init {
        playlists.value = playlistList
    }

    fun add(playlist: Playlist){
        playlistList.add(playlist)
        playlists.value = playlistList
    }

    fun getAll():LiveData<List<Playlist>>{
        return playlists
    }
}