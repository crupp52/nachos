package com.crupp52.nachos.data.model

import java.util.*

data class Movie(
    val title: String,
    val release: Date,
    val genres: List<Genre>,
    val id: Int,
    val description: String,
    val voteAverage: Double
) {
    override fun toString(): String {
        return "$title (${release.year})"
    }
}
