package org.sopt.jointseminar.melon.data.entity.music

data class ResponseRecentMusicData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<Data>
) {
    data class Data(
        val title: String,
        val singer: String,
        val image: String,
        val albumId: String
    )
}
