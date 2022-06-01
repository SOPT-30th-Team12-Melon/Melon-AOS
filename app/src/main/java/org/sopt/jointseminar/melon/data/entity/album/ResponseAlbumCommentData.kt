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
        @SerializedName("userId")
        val authorInfo: AlbumCommentAuthorInfo,
        @SerializedName("commentBody")
        val comment: String,
    ) {
        fun convertToAlbumCommentInfo(comment: Data): AlbumCommentInfo {
            return AlbumCommentInfo(
                comment.id,
                comment.authorInfo,
                comment.comment,
            )
        }
    }
}