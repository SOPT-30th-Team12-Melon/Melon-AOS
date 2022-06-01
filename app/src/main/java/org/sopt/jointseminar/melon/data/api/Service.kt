package org.sopt.jointseminar.melon.data.api

import org.sopt.jointseminar.melon.data.entity.music.ResponseHomeFavourite
import org.sopt.jointseminar.melon.data.entity.music.ResponseRecentMusic
import org.sopt.jointseminar.melon.data.entity.posting.RequestPostingData
import org.sopt.jointseminar.melon.data.entity.posting.ResponsePostingData
import retrofit2.Call
import retrofit2.http.*

interface Service {
    @POST("comment/{albumId}")
    fun postComment(
        @Path("albumId") albumId: String,
        @Body body: RequestPostingData
    ): Call<List<ResponsePostingData>>

    @GET("album/recent?type=")
    fun getRecentMusic(
        @Query("type") type: String
    ): Call<ResponseRecentMusic>

    @GET("/playlist/main")
    fun getFavoriteMusic(): Call<ResponseHomeFavourite>
}
