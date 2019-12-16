package com.crupp52.nachos.data.db

import android.app.Application
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.crupp52.nachos.data.MovieInfoProvider
import com.crupp52.nachos.data.model.Movie

@Database(entities = [Movie::class],    version = 2)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        private val lock = Any()
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(application: Application): MovieDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE =
                        Room.databaseBuilder(application, MovieDatabase::class.java, "movie.db")
                            .allowMainThreadQueries().addCallback(object : RoomDatabase.Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    INSTANCE?.let {
                                        prePopulate(it, MovieInfoProvider.movieList)
                                    }
                                }
                            })
                            .build()
                }

                return INSTANCE!!
            }
        }

        fun prePopulate(database: MovieDatabase, movieList: List<Movie>) {
            for (movie in movieList) {
                AsyncTask.execute { database.movieDao().insert(movie) }
            }
        }
    }
}