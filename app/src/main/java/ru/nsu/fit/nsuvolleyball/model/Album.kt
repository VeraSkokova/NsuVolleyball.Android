package ru.nsu.fit.nsuvolleyball.model

import kotlinx.serialization.Serializable

@Serializable
data class Album(val id: Int, val name: String, val type: String)