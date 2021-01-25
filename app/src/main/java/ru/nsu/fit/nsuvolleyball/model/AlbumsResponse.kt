package ru.nsu.fit.nsuvolleyball.model

import kotlinx.serialization.Serializable

@Serializable
class AlbumsResponse(val albums : List<Album>) {
}