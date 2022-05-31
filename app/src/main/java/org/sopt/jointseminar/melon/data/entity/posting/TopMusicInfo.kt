package org.sopt.jointseminar.melon.data.entity.posting

import org.sopt.jointseminar.melon.data.entity.Rank

data class TopMusicInfo(
    val rank: Rank,
    val title: String,
    val artist: String,
    val image: Int
)
