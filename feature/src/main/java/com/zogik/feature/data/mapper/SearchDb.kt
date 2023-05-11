package com.zogik.feature.data.mapper

import com.zogik.core.domain.entity.AlbumEntity
import com.zogik.core.domain.entity.ArtistEntity
import com.zogik.core.domain.entity.SearchEntity
import com.zogik.feature.data.response.DataItem

object SearchDb {
    fun mapper(data: List<DataItem>): List<SearchEntity> {
        val dataList = data.map {
            val artistConvert = ArtistEntity(
                it.artist?.pictureXl,
                it.artist?.tracklist,
                it.artist?.pictureBig,
                it.artist?.name,
                it.artist?.link,
                it.artist?.pictureSmall,
                it.artist?.id,
                it.artist?.type,
                it.artist?.picture,
                it.artist?.pictureMedium,
            )

            val albumConvert = AlbumEntity(
                it.album?.cover,
                it.album?.md5Image,
                it.album?.tracklist,
                it.album?.coverXl,
                it.album?.coverMedium,
                it.album?.coverSmall,
                it.album?.id,
                it.album?.title,
                it.album?.type,
                it.album?.coverBig,
            )

            SearchEntity(
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
                it.id,
                it.explicitContentLyrics,
            )
        }

        return dataList
    }
}
