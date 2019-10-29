package com.crupp52.nachos.data.repository

import androidx.lifecycle.LiveData
import com.crupp52.nachos.data.dao.FakePlaylistDao
import com.crupp52.nachos.data.model.Playlist

class FakePlaylistRepository private constructor(private val playlistDao: FakePlaylistDao){
    fun add(playlist: Playlist){
        playlistDao.add(playlist)
    }

    fun getAll(): LiveData<List<Playlist>> {
        return playlistDao.getAll()
    }

    companion object {
        @Volatile
        private var instance: FakePlaylistRepository? = null

        fun getInstance(playlistDao: FakePlaylistDao) = instance ?: synchronized(this) {
            instance ?: FakePlaylistRepository(playlistDao).also { instance = it }
        }
    }
}