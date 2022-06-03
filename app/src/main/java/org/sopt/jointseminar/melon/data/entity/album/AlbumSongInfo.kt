package org.sopt.jointseminar.melon.data.entity.album

import com.google.gson.annotations.SerializedName

data class AlbumSongInfo(
    val number: Int,
    @SerializedName("singname")
    val title: String,
)
