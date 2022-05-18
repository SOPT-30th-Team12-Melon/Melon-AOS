package org.sopt.jointseminar.melon.model

import java.util.*

data class CommentInfo(
    val comment: String,
    val id: String = UUID.randomUUID().toString()
)
