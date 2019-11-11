package com.crupp52.nachos.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.crupp52.nachos.data.db.entity.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getAll(): LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(movie: Movie)
}