package org.sopt.jointseminar.melon.data.api

import org.sopt.jointseminar.melon.data.entity.posting.RequestPostingData
import org.sopt.jointseminar.melon.data.entity.posting.ResponsePostingData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface Service {
    @POST("comment/{albumId}")
    fun postComment(
        @Path("albumId") albumId: String,
        @Body body: RequestPostingData
    ): Call<ResponsePostingData>
}