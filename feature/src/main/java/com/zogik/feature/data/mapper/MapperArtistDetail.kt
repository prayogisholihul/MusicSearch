package com.zogik.feature.data.mapper

import com.zogik.core.data.entity.FavoriteTrack
import com.zogik.core.domain.model.Album
import com.zogik.core.domain.model.Artist
import com.zogik.core.domain.model.Track
import com.zogik.feature.data.response.DataItem

object MapperArtistDetail {

    fun List<DataItem>.responseToDomain(): List<Track> {
        val data = map {
            val contributor = it.contributors.orEmpty().first()
            val artistConvert = Artist(
                contributor.id.orEmpty(),
                contributor.pictureXl.orEmpty(),
                contributor.tracklist.orEmpty(),
                contributor.pictureBig.orEmpty(),
                contributor.name.orEmpty(),
                contributor.link.orEmpty(),
                contributor.pictureSmall.orEmpty(),
                contributor.type.orEmpty(),
                contributor.picture.orEmpty(),
                contributor.pictureMedium.orEmpty(),
            )
            val albumConvert = Album(
                it.album?.id.orEmpty(),
                it.album?.cover.orEmpty(),
                it.album?.md5Image.orEmpty(),
                it.album?.tracklist.orEmpty(),
                it.album?.coverXl.orEmpty(),
                it.album?.coverMedium.orEmpty(),
                it.album?.coverSmall.orEmpty(),
                it.album?.title.orEmpty(),
                it.album?.type.orEmpty(),
                it.album?.coverBig.orEmpty(),
            )

            Track(
                it.id.orEmpty(),
                it.readable ?: false,
                it.preview.orEmpty(),
                it.md5Image.orEmpty(),
                artistConvert,
                albumConvert,
                it.link.orEmpty(),
                it.explicitContentCover ?: 0,
                it.title.orEmpty(),
                it.titleVersion.orEmpty(),
                it.explicitLyrics ?: false,
                it.type.orEmpty(),
                it.titleShort.orEmpty(),
                it.duration ?: 0,
                it.rank ?: 0,
                it.position.orEmpty(),
                it.explicitContentLyrics ?: 0,
            )
        }

        return data
    }

    fun List<FavoriteTrack>.entityToDomain(): List<Track> {
        val data = map {
            val artistConvert = Artist(
                it.artist.id.orEmpty(),
                it.artist.pictureXl.orEmpty(),
                it.artist.tracklist.orEmpty(),
                it.artist.pictureBig.orEmpty(),
                it.artist.name.orEmpty(),
                it.artist.link.orEmpty(),
                it.artist.pictureSmall.orEmpty(),
                it.artist.type.orEmpty(),
                it.artist.picture.orEmpty(),
                it.artist.pictureMedium.orEmpty(),
            )
            val albumConvert = Album(
                it.album.id.orEmpty(),
                it.album.cover.orEmpty(),
                it.album.md5Image.orEmpty(),
                it.album.tracklist.orEmpty(),
                it.album.coverXl.orEmpty(),
                it.album.coverMedium.orEmpty(),
                it.album.coverSmall.orEmpty(),
                it.album.title.orEmpty(),
                it.album.type.orEmpty(),
                it.album.coverBig.orEmpty(),
            )

            Track(
                it.id.orEmpty(),
                it.readable ?: false,
                it.preview.orEmpty(),
                it.md5Image.orEmpty(),
                artistConvert,
                albumConvert,
                it.link.orEmpty(),
                it.explicitContentCover ?: 0,
                it.title.orEmpty(),
                it.titleVersion.orEmpty(),
                it.explicitLyrics ?: false,
                it.type.orEmpty(),
                it.titleShort.orEmpty(),
                it.duration ?: 0,
                it.rank ?: 0,
                it.position.orEmpty(),
                it.explicitContentLyrics ?: 0,
            )
        }

        return data
    }
}
