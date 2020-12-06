package ru.nsu.fit.nsuvolleyball.ui.games

import androidx.annotation.DrawableRes

data class GameView(
    val teams: String,
    val date: String,
    @DrawableRes val placeImage: Int
)