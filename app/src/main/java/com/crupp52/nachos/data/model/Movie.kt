package com.crupp52.nachos.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import retrofit2.http.Field

@Entity
data class Movie(

    @PrimaryKey
    val id: Int,

    val title: String,

    @Json(name = "release_date")
    val releaseDate: String,

    val adult: Boolean,

    @Json(name = "original_language")
    val originalLanguage: String,

    @Json(name = "original_title")
    val originalTitle: String,

    val overview: String,

    val popularity: Double,

    @Json(name = "poster_path")
    val posterPath: String,

    @Json(name = "vote_average")
    val voteAverage: Double,

    var userRate: Float = 0.0f
)