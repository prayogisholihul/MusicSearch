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

    fun FavoriteTrack?.entityToDomain(): Track {
        val artistConvert = Artist(
            this?.artist?.id.orEmpty(),
            this?.artist?.pictureXl.orEmpty(),
            this?.artist?.tracklist.orEmpty(),
            this?.artist?.pictureBig.orEmpty(),
            this?.artist?.name.orEmpty(),
            this?.artist?.link.orEmpty(),
            this?.artist?.pictureSmall.orEmpty(),
            this?.artist?.type.orEmpty(),
            this?.artist?.picture.orEmpty(),
            this?.artist?.pictureMedium.orEmpty(),
        )
        val albumConvert = Album(
            this?.album?.id.orEmpty(),
            this?.album?.cover.orEmpty(),
            this?.album?.md5Image.orEmpty(),
            this?.album?.tracklist.orEmpty(),
            this?.album?.coverXl.orEmpty(),
            this?.album?.coverMedium.orEmpty(),
            this?.album?.coverSmall.orEmpty(),
            this?.album?.title.orEmpty(),
            this?.album?.type.orEmpty(),
            this?.album?.coverBig.orEmpty(),
        )

        return Track(
            this?.id.orEmpty(),
            this?.readable ?: false,
            this?.preview.orEmpty(),
            this?.md5Image.orEmpty(),
            artistConvert,
            albumConvert,
            this?.link.orEmpty(),
            this?.explicitContentCover ?: 0,
            this?.title.orEmpty(),
            this?.titleVersion.orEmpty(),
            this?.explicitLyrics ?: false,
            this?.type.orEmpty(),
            this?.titleShort.orEmpty(),
            this?.duration ?: 0,
            this?.rank ?: 0,
            this?.position.orEmpty(),
            this?.explicitContentLyrics ?: 0,
        )
    }
}
