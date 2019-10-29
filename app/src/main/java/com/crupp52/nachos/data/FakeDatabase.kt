package com.crupp52.nachos.data

import com.crupp52.nachos.data.dao.FakeMovieDao
import com.crupp52.nachos.data.dao.FakePlaylistDao

class FakeDatabase private constructor() {
    var movieDao = FakeMovieDao()
        private set

    var playlistDao = FakePlaylistDao()
        private set

    companion object {
        @Volatile
        private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: FakeDatabase().also { instance = it }
        }
    }
}