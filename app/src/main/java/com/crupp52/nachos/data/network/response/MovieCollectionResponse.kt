package com.crupp52.nachos.data.network.response

import com.crupp52.nachos.data.db.entity.Movie
import com.google.gson.annotations.SerializedName

data class MovieCollectionResponse(
    @SerializedName("results")
    val results: List<Movie>
){
    override fun toString(): String {
        var o = ""
        results.forEach { movie->
            o += "$movie\n\n"
        }

        return o
    }
}