package org.sopt.jointseminar.melon.data.entity.music

data class ResponseHomeFavourite(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<Data>
) {
    data class Data(
        val title: String,
        val image: String,
        val body: String,
        val hashtag: List<String>
    )
}
