package org.sopt.jointseminar.melon.data.entity.album

data class AlbumInfo(
    val id: String,
    val coverImage: String,
    val title: String,
    val releaseDate: String,
    val score: Int,
    val numOfPeople: Int,
    val singerName: String,
    val artistImage: String,
    val likeNum: Int,
    val type: String,
    val genre: String,
    val time: String,
    val description: String,
    val publisher: String,
    val agency: String,
)
