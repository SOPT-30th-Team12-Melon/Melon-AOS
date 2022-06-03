package org.sopt.jointseminar.melon.data.api

import org.sopt.jointseminar.melon.data.entity.album.ResponseAlbumCommentData
import org.sopt.jointseminar.melon.data.entity.album.ResponseAlbumData
import org.sopt.jointseminar.melon.data.entity.music.ResponseRecentMusicData
import org.sopt.jointseminar.melon.data.entity.posting.RequestPostingData
import org.sopt.jointseminar.melon.data.entity.posting.ResponsePostingData
import retrofit2.Call
import retrofit2.http.*

interface Service {
    @POST("comment/{albumId}")
    fun postComment(
        @Path("albumId") albumId: String,
        @Body body: RequestPostingData
    ): Call<ResponsePostingData>

    @GET("comment/album/{albumId}")
    fun getComment(
        @Path("albumId") albumId: String
    ): Call<ResponseAlbumCommentData>

    @GET("album/{albumId}")
    fun getAlbumInfo(
        @Path("albumId") albumId: String
    ): Call<ResponseAlbumData>

    @GET("album/recent?type=")
    fun getRecentMusic(
        @Query("type") type: String
    ): Call<ResponseRecentMusicData>
}
