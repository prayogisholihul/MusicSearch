package com.zogik.feature.data.mapper

import com.zogik.core.domain.entity.AlbumEntity
import com.zogik.core.domain.entity.ArtistEntity
import com.zogik.core.domain.entity.SearchEntity
import com.zogik.feature.data.response.DataItem

object SearchDb {
    fun mapper(data: List<DataItem>): List<SearchEntity> {
        val dataList = data.map {
            val artistConvert = ArtistEntity(
                it.artist?.id.orEmpty(),
                it.artist?.pictureXl.orEmpty(),
                it.artist?.tracklist.orEmpty(),
                it.artist?.pictureBig.orEmpty(),
                it.artist?.name.orEmpty(),
                it.artist?.link.orEmpty(),
                it.artist?.pictureSmall.orEmpty(),
                it.artist?.type.orEmpty(),
                it.artist?.picture.orEmpty(),
                it.artist?.pictureMedium.orEmpty(),
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

            SearchEntity(
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
                it.explicitContentLyrics ?: 0,
            )
        }

        return dataList
    }
}
