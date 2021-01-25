package ru.nsu.fit.nsuvolleyball.data.api

import io.reactivex.Single
import retrofit2.http.GET
import ru.nsu.fit.nsuvolleyball.model.AlbumsResponse
import ru.nsu.fit.nsuvolleyball.model.GamesResponse

interface NsuVolleyballApi {
    @GET("api/games")
    fun getGames(): Single<GamesResponse>

    @GET("api/gallery/photos")
    fun getPhotos(): Single<AlbumsResponse>

    @GET("api/gallery/videos")
    fun getVideos(): Single<AlbumsResponse>
}