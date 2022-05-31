package org.sopt.jointseminar.melon.data.entity.album

import com.google.gson.annotations.SerializedName

data class ResponseAlbumCommentData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<Data>,
) {
    data class Data(
        @SerializedName("albumId")
        val id: String,
        val author: String,
        @SerializedName("image")
        val authorImage: String,
        val createdAt: String,
        @SerializedName("commentBody")
        val comment: String,
        val likeNum: Int,
        val hateNum: Int,
        @SerializedName("commentNum")
        val replyNum: Int,
    ) {
        fun convertToAlbumCommentInfo(comment: Data): AlbumCommentInfo {
            return AlbumCommentInfo(comment.id,
                comment.author,
                comment.authorImage,
                comment.createdAt,
                comment.comment,
                comment.likeNum,
                comment.hateNum,
                comment.replyNum)
        }
    }
}