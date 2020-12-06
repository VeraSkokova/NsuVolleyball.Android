package ru.nsu.fit.nsuvolleyball.model

data class Game(
    val id: Int,
    val firstTeam: String,
    val secondTeam: String,
    val date: String,
    val isHome: Boolean
)