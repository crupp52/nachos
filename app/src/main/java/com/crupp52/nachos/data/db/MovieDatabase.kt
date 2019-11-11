package com.crupp52.nachos.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.crupp52.nachos.data.db.entity.Movie

@Database(
    entities = [Movie::class],
    version = 5
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    init {
        movieDao().upsert(Movie(10,"asd", "2018"))
    }

    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder<MovieDatabase>(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "movie_db"
                ).build()
            }
            return INSTANCE
        }
    }
}