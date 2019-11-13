package com.crupp52.nachos.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.crupp52.nachos.data.model.Movie
import java.lang.StringBuilder

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getAll(): LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Movie)

    @Delete
    fun delete(movie: Movie)

    @Query("SELECT * FROM movie WHERE title LIKE '%' ||:title || '%'")
    fun fundByTitle(title: String): LiveData<List<Movie>>

    @Query("SELECT * FROM movie WHERE id = :id")
    fun find(id: Int): LiveData<Movie>
}