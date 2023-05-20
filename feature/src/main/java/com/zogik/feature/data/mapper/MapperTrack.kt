package com.zogik.feature.data.mapper

import com.zogik.core.data.entity.AlbumEntity
import com.zogik.core.data.entity.ArtistEntity
import com.zogik.core.data.entity.TrackEntity
import com.zogik.core.domain.model.Album
import com.zogik.core.domain.model.Artist
import com.zogik.core.domain.model.Track
import com.zogik.feature.data.response.DataItem

object MapperTrack {
    fun responseToEntity(data: List<DataItem>): List<TrackEntity> {
        val dataList = data.map {
            val artistConvert = ArtistEntity(
                it.artistResponse?.id.orEmpty(),
                it.artistResponse?.pictureXl.orEmpty(),
                it.artistResponse?.tracklist.orEmpty(),
                it.artistResponse?.pictureBig.orEmpty(),
                it.artistResponse?.name.orEmpty(),
                it.artistResponse?.link.orEmpty(),
                it.artistResponse?.pictureSmall.orEmpty(),
                it.artistResponse?.type.orEmpty(),
                it.artistResponse?.picture.orEmpty(),
                it.artistResponse?.pictureMedium.orEmpty(),
            )
            val albumConvert = AlbumEntity(
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

            TrackEntity(
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
                isFavorite = false,
            )
        }

        return dataList
    }

    fun entityToDomain(data: List<TrackEntity>): List<Track> {
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

    fun domainToEntity(data: Track): TrackEntity {
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

        return TrackEntity(
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
