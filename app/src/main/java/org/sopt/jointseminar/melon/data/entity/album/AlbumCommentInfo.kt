package org.sopt.jointseminar.melon.data.entity.album

data class AlbumCommentInfo(
    val id: String,
    val author: String,
    val authorImage: String,
    val createdAt: String,
    val comment: String,
    val likeNum: Int,
    val hateNum: Int,
    val replyNum: Int,
)
