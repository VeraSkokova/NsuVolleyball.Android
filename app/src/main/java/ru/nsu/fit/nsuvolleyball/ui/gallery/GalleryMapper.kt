package ru.nsu.fit.nsuvolleyball.ui.gallery

import ru.nsu.fit.nsuvolleyball.model.Album

class GalleryMapper {
    fun toGalleryView(album: Album): GalleryView {
        return GalleryView(album.name)
    }
}