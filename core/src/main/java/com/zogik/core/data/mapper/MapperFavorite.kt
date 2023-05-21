package com.zogik.core.data.mapper

import com.zogik.core.data.entity.AlbumEntity
import com.zogik.core.data.entity.ArtistEntity
import com.zogik.core.data.entity.FavoriteTrack
import com.zogik.core.domain.model.Album
import com.zogik.core.domain.model.Artist
import com.zogik.core.domain.model.Track

object MapperFavorite {
    fun entityToDomain(data: List<FavoriteTrack>): List<Track> {
        val map = data.map {
            val artistConvert = Artist(
                it.artist.id,
                it.artist.pictureXl,
                it.artist.tracklist,
                it.artist.pictureBig,
                it.artist.name,
                it.artist.link,
                it.artist.pictureSmall,
                it.artist.type,
                it.artist.picture,
                it.artist.pictureMedium,
            )
            val albumConvert = Album(
                it.album.id,
                it.album.cover,
                it.album.md5Image,
                it.album.tracklist,
                it.album.coverXl,
                it.album.coverMedium,
                it.album.coverSmall,
                it.album.title,
                it.album.type,
                it.album.coverBig,
            )

            Track(
                it.id,
                it.readable,
                it.preview,
                it.md5Image,
                artistConvert,
                albumConvert,
                it.link,
                it.explicitContentCover,
                it.title,
                it.titleVersion,
                it.explicitLyrics,
                it.type,
                it.titleShort,
                it.duration,
                it.rank,
                it.position,
                it.explicitContentLyrics,
                it.isFavorite,
            )
        }

        return map
    }

    fun domainToEntity(data: Track): FavoriteTrack {
        val artist = ArtistEntity(
            data.artist.id,
            data.artist.pictureXl,
            data.artist.tracklist,
            data.artist.pictureBig,
            data.artist.name,
            data.artist.link,
            data.artist.pictureSmall,
            data.artist.type,
            data.artist.picture,
            data.artist.pictureMedium,
        )

        val album = AlbumEntity(
            data.album.id,
            data.album.cover,
            data.album.md5Image,
            data.album.tracklist,
            data.album.coverXl,
            data.album.coverMedium,
            data.album.coverSmall,
            data.album.title,
            data.album.type,
            data.album.coverBig,
        )

        return FavoriteTrack(
            data.id,
            data.readable,
            data.preview,
            data.md5Image,
            artist,
            album,
            data.link,
            data.explicitContentCover,
            data.title,
            data.titleVersion,
            data.explicitLyrics,
            data.type,
            data.titleShort,
            data.duration,
            data.rank,
            data.position,
            data.explicitContentLyrics,
            data.isFavorite,
        )
    }
}
