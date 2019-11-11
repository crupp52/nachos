package com.crupp52.nachos.data.db.entity

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val releaseDate: String

    /*@SerializedName("adult")
    val adult: Boolean,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: Double*/
) {
    override fun toString(): String {
        return "$title (${releaseDate.substring(0, 4)})"
    }
}