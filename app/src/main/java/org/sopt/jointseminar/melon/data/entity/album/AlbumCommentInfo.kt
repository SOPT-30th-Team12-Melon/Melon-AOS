package org.sopt.jointseminar.melon.data.entity.album

data class AlbumCommentInfo(
    val id: String,
    val author: AlbumCommentAuthorInfo,
    val comment: String,
)
