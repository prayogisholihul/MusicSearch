package com.zogik.core.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zogik.core.domain.entity.AlbumEntity
import com.zogik.core.domain.entity.ArtistEntity

class Converter {

    // ALBUM
    @TypeConverter
    fun fromAlbumEntity(value: AlbumEntity): String {
        val gson = Gson()
        val type = object : TypeToken<AlbumEntity>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toAlbumEntity(value: String): AlbumEntity {
        val gson = Gson()
        val type = object : TypeToken<AlbumEntity>() {}.type
        return gson.fromJson(value, type)
    }

    // ARTIST
    @TypeConverter
    fun fromArtistEntity(value: ArtistEntity): String {
        val gson = Gson()
        val type = object : TypeToken<ArtistEntity>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toArtistEntity(value: String): ArtistEntity {
        val gson = Gson()
        val type = object : TypeToken<ArtistEntity>() {}.type
        return gson.fromJson(value, type)
    }
}
