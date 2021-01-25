package ru.nsu.fit.nsuvolleyball.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Game(
    val id: Int,
    val iconUrl: String,
    @SerialName("firstTeamName")
    val firstTeam: String,
    @SerialName("home")
    val isHome: Boolean,
    val address: String,
    @SerialName("time")
    val date: String,
    @SerialName("secondTimeName")
    val secondTeam: String
)