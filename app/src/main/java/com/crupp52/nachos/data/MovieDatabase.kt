package com.crupp52.nachos.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.crupp52.nachos.model.Movie

@Database(entities = [Movie::class], version = 4)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}