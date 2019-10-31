package com.crupp52.nachos.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.crupp52.nachos.data.db.entity.Movie

@Database(
    entities = [Movie::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var instance: MovieDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buidDatabase(context).also { instance = it }
        }

        private fun buidDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MovieDatabase::class.java,
            "movie.db"
        ).build()
    }
}