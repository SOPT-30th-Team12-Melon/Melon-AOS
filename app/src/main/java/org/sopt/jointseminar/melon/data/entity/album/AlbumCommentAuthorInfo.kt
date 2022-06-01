package org.sopt.jointseminar.melon.data.entity.album

import com.google.gson.annotations.SerializedName

data class AlbumCommentAuthorInfo(
    @SerializedName("_id")
    val id: String,
    val nickName: String,
    val image: String,
)