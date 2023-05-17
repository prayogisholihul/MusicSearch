package com.zogik.core.domain.model

data class Album(
    val id: String,
    val cover: String,
    val md5Image: String,
    val tracklist: String,
    val coverXl: String,
    val coverMedium: String,
    val coverSmall: String,
    val title: String,
    val type: String,
    val coverBig: String,
)
