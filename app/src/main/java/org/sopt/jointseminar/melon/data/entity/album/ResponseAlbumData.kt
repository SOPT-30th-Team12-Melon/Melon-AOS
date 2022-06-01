package org.sopt.jointseminar.melon.data.entity.album

import com.google.gson.annotations.SerializedName

data class ResponseAlbumData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data,
) {
    data class Data(
        @SerializedName("_id")
        val id: String,
        @SerializedName("albumImage")
        val coverImage: String,
        @SerializedName("albumTitle")
        val title: String,
        @SerializedName("albumDate")
        val releaseDate: String,
        @SerializedName("albumScope")
        val score: Int,
        @SerializedName("numberPeople")
        val numOfPeople: Int,
        val singerName: String,
        @SerializedName("singerImage")
        val artistImage: String,
        @SerializedName("likeNumber")
        val likeNum: Int,
        @SerializedName("albumSing")
        val songList: List<AlbumSongInfo>,
        @SerializedName("albumType")
        val type: String,
        @SerializedName("albumGenre")
        val genre: String,
        @SerializedName("albumTime")
        val time: String,
        @SerializedName("albumContent")
        val description: String,
        @SerializedName("albumCompany")
        val publisher: String,
        @SerializedName("company")
        val agency: String,
    ) {
        fun convertToAlbumInfo(album: Data): AlbumInfo {
            return AlbumInfo(album.id,
                album.coverImage,
                album.title,
                album.releaseDate,
                album.score,
                album.numOfPeople,
                album.singerName,
                album.artistImage,
                album.likeNum,
                album.songList,
                album.type,
                album.genre,
                album.time,
                album.description,
                album.publisher,
                album.agency
            )
        }
    }
}