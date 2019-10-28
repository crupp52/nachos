package com.crupp52.nachos.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var title: String,
    var releaseDate: Date,
    var watched: Boolean
)
