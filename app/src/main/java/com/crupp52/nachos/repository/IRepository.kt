package com.crupp52.nachos.repository

import com.crupp52.nachos.model.Movie

interface IRepository {
    suspend fun getAll(): List<Movie>
    suspend fun add(movie: Movie)
    suspend fun delete(movie: Movie)
    suspend fun update(movie: Movie)
}