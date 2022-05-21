package org.sopt.jointseminar.melon.data.posting

import org.sopt.jointseminar.melon.data.Rank

data class TopMusicInfo(
    val rank: Rank,
    val title: String,
    val artist: String,
    val image: Int
)
