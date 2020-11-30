package ru.nsu.fit.nsuvolleyball.model

data class News(
    val id: Int,
    val title: String,
    val date: String,
    val shortDescription: String,
    val fullDescription: String,
    val imageUrl: String
)