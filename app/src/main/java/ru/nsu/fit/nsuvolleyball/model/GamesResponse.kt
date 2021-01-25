package ru.nsu.fit.nsuvolleyball.model

import kotlinx.serialization.Serializable

@Serializable
class GamesResponse(val past: List<Game>, val future: List<Game>) {
}