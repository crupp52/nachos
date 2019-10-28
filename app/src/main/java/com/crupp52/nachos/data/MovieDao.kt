package com.crupp52.nachos.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.crupp52.nachos.model.Movie

interface MovieDao {
    @Query("SELECT * from movie")
    suspend fun getAll():List<Movie>

    @Insert
    suspend fun add(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)

    @Update
    suspend fun update(movie: Movie)
}