package com.crupp52.nachos.data.model

data class Genre(
    val id: Int,
    val name: String
) {
    override fun toString(): String {
        return name
    }
}
